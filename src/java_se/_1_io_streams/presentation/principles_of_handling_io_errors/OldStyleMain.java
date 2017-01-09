package java_se._1_io_streams.presentation.principles_of_handling_io_errors;

import java_se._1_io_streams.presentation.stream_classes.PathsUtil;

import java.io.*;

public class OldStyleMain {

    public static void main(String[] args) throws IOException {

        InputStream input = null;
        try {
            input = new FileInputStream(filePathInCurrentClassDirectory("files/file.txt"));
            int data = input.read();
            while (data != -1) {
                System.out.print((char) data);
                data = input.read();
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    public static String filePathInCurrentClassDirectory(String filePath) {
        return PathsUtil.getClassDirectory(OldStyleMain.class, PathsUtil.CodeSourceDirectory.SRC) + filePath;
    }
}
