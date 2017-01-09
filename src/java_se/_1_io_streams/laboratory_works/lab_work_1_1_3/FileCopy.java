package java_se._1_io_streams.laboratory_works.lab_work_1_1_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        if (args.length > 1) {
            try {
                inputStream = new FileInputStream(args[0]);
                outputStream = new FileOutputStream(args[1]);
                int character = 0;
                while ((character = inputStream.read()) != -1) {
                    outputStream.write(character);
                }
                System.out.println("Copying the file is complete!");

            } catch (FileNotFoundException ee) {
                System.out.println("File not found!");
            } catch (IOException exp) {
                System.out.println("Error working with the file!");
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error closing the file!");
                }
            }

        } else {
            System.out.println("The file names are not specified");
        }
    }
}
