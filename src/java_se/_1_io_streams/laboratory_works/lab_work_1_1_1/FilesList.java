package java_se._1_io_streams.laboratory_works.lab_work_1_1_1;

import java.io.File;

public class FilesList {

    public static void main(String[] args) {
        File directory = null;

        if (args.length == 0)
            directory = new File(".");
        else
            directory = new File(args[0]);

        if (directory.isDirectory()) {
            File[] listFiles = directory.listFiles();
            System.out.println("Content directory " + directory);
            for (File file : listFiles)
                System.out.println(file.getName());
        } else {
            System.out.println("Not specified directory -> " + directory);
        }
    }
}
