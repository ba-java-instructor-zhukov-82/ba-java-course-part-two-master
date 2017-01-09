package java_se._1_io_streams.presentation.random_access_file;

import java_se._1_io_streams.presentation.stream_classes.PathsUtil;

import java.io.*;
import java.util.*;

public class RandomAccessFileMain {

    public static void main(String[] args) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(filePathInCurrentClassDirectory("files/ra_test.txt"), "rw");
            raf.write(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
            raf.seek(5);
            raf.write(new byte[]{66, 77, 88});
            raf.seek(0);
            byte[] buf = new byte[10];
            int n = raf.read(buf, 0, 10);
            System.out.println(Arrays.toString(buf));
            raf.close();
        } catch (IOException e) {
        }
    }

    public static String filePathInCurrentClassDirectory(String filePath) {
        return PathsUtil.getClassDirectory(RandomAccessFileMain.class, PathsUtil.CodeSourceDirectory.SRC) + filePath;
    }
}
