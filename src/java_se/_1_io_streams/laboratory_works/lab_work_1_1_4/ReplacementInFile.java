package java_se._1_io_streams.laboratory_works.lab_work_1_1_4;

import java.io.*;
import java.util.Scanner;

public class ReplacementInFile {
    public static void main(String[] args) {
        String sourceStr = "public",
               replaceStr = "private",
               lineStr = null;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        File replaceFile = new File(sc.next());
        File temp = new File("d:\\temp.txt");

        try (BufferedReader fp = new BufferedReader(new FileReader(replaceFile));
             BufferedWriter fp1 = new BufferedWriter(new FileWriter(temp)) ) {
            System.out.println("Replacing a file....");
            while ((lineStr = fp.readLine()) != null) {
                lineStr = lineStr.replaceAll(sourceStr, replaceStr);
                fp1.write(lineStr);
                fp1.write("\r\n");
            }
            System.out.println("Replacement completed!");
        } catch (FileNotFoundException ee) {
            System.out.println("File not found!");
        } catch (IOException exp) {
            System.out.println("Error working with the file!");
        }

        replaceFile.delete();
        temp.renameTo(replaceFile);

    }
}
