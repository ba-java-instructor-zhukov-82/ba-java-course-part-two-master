package java_se._1_io_streams.presentation.stream_classes;

import java.io.*;

public class BufferedInputStreamMain {

    public static void main(String[] args) {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(
                    new FileInputStream(FileStreamsMain.filePathInCurrentClassDirectory("files/input.txt")));
            out = new BufferedOutputStream(
                    new FileOutputStream(FileStreamsMain.filePathInCurrentClassDirectory("files/file.txt")));
            int byteRead;
            while ((byteRead = in.read()) != -1) {
                out.write(byteRead);
            }
        } catch (IOException ex) {
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException ex) {

            }
        }
    }
}
