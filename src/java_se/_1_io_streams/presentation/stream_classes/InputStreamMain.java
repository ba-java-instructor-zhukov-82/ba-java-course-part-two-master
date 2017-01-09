package java_se._1_io_streams.presentation.stream_classes;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamMain {

    public static void main(String[] args) {
        InputStream stdin = System.in;
        try {
            int val = stdin.read();
            System.out.println(val);
        } catch (IOException e) {

        }
    }
}
