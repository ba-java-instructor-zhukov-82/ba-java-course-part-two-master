package java_se._1_io_streams.presentation.stream_classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamsMain {

    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(filePathInCurrentClassDirectory("files/input.txt"));
            out = new FileOutputStream(filePathInCurrentClassDirectory("files/output.txt"));
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }

    public static String filePathInCurrentClassDirectory(String filePath) {
        return PathsUtil.getClassDirectory(FileStreamsMain.class, PathsUtil.CodeSourceDirectory.SRC) + filePath;
    }
}
