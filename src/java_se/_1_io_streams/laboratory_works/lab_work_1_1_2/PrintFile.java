package java_se._1_io_streams.laboratory_works.lab_work_1_1_2;

import java.io.*;

public class PrintFile {
    public static void main(String[] args) {
        File ff = null;

        if (args.length != 0) {
            ff = new File(args[0]);

            if ( !ff.isDirectory() ) {

                try (BufferedReader br = new BufferedReader(new FileReader(ff))) {
                    String string;
                    while ((string = br.readLine()) != null)
                        System.out.println(string);
                } catch (IOException exp) {
                    System.out.println("Error reading file!");
                }

            } else {
                System.out.println("This are directory, you need a file!");
            }

        } else {
            System.out.println("The file name is not specified!");
        }
    }
}
