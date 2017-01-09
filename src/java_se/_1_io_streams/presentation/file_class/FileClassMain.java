package java_se._1_io_streams.presentation.file_class;

import java_se._1_io_streams.presentation.stream_classes.PathsUtil;

import java.io.*;

public class FileClassMain {

    public static void main(String[] args) {
        File file= new File(filePathInCurrentClassDirectory("files/testfile.txt"));
        //Check if Path is File or Directory
        boolean isDirectory= file.isDirectory();
        System.out.println("File: is directory - " + isDirectory);
        //Check if File Exists
        boolean fileExists= file.exists();
        System.out.println("File: file exists - " + fileExists);
        //File Length
        long length = file.length();
        System.out.println("File: file length - " + length);
        //Rename or Move File
        boolean sucMov= file.renameTo(new File(filePathInCurrentClassDirectory("files/testfile.txt")));
        System.out.println("File: rename file - " + sucMov);
        //Delete File
        //boolean successDel= file.delete();
        //System.out.println("File: is deleted - " + successDel);
    }

    public static String filePathInCurrentClassDirectory(String filePath) {
        return PathsUtil.getClassDirectory(FileClassMain.class, PathsUtil.CodeSourceDirectory.SRC) + filePath;
    }
}
