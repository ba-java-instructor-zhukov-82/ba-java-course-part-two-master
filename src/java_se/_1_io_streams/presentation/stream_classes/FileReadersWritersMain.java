package java_se._1_io_streams.presentation.stream_classes;

import java.io.FileReader;
import java.io.FileWriter;

public class FileReadersWritersMain {

    public static void main(String[] args) throws Exception {
        FileReader inputStream = null;
        FileWriter outputStream = null;
        try {
            inputStream = new FileReader(FileStreamsMain.filePathInCurrentClassDirectory("files/input.txt"));
            outputStream = new FileWriter(FileStreamsMain.filePathInCurrentClassDirectory("files/output.txt"));
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) inputStream.close();
            if (outputStream != null) outputStream.close();
        }
    }
}
