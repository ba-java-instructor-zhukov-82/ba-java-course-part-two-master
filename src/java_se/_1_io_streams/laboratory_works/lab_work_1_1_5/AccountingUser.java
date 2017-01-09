package java_se._1_io_streams.laboratory_works.lab_work_1_1_5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccountingUser {
    private RandomAccessFile file;

    public AccountingUser() {
        try {
            file = new RandomAccessFile("d:\\users.txt","rw");
        } catch (FileNotFoundException ef) {
            System.out.println("File not found!");
        }
    }

    public void printFile() {
        try {
            file.seek(0L);
            String line = null;
            while ( (line = file.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException exp) {
            System.out.println("Error reading file!");
        }
    }

    public void testUsers(String nameUser) {
        try {
            String line = null;

            file.seek(0L);
            while ( (line = file.readLine()) != null) {
                if (verificationUser(line, nameUser)) {
                    replaceNumber(line);
                    return;
                }
            }

            String newRecordUser = nameUser + ":" + 1;
            file.writeBytes(newRecordUser);
            file.writeBytes("\r\n");
        } catch (IOException ee) {
            System.out.println("Error working with the file!");
        }
    }

    private boolean verificationUser(String recordUser, String nameUser) {
        String name = recordUser.substring(0, recordUser.indexOf(":"));
        return name.equalsIgnoreCase(nameUser);
    }

    private void replaceNumber(String recordUser) {
        String number = recordUser.substring(recordUser.indexOf(":") + 1);
        int count = Integer.parseInt(number) + 1;
        String newNumber = "" + count;

        try {
            file.seek(file.getFilePointer() - 3);
            file.writeBytes(newNumber);
        } catch (IOException ee) {
            System.out.println("Error working with the file!");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            file.close();
        } catch (IOException ee) {
            System.out.println("Error closing file!");
        }
    }
}
