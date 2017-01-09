package java_se._1_io_streams.presentation.stream_classes;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamMain {

    public static void main(String[] args) throws Exception {
        OutputStream stdout = System.out;
        try {
            stdout.write(new byte[]{97, 98, 99});
        } catch (IOException e) {

        } finally {
            stdout.close();
        }
    }
}
