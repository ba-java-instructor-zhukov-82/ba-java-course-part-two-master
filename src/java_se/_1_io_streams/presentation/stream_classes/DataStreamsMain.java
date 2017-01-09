package java_se._1_io_streams.presentation.stream_classes;

import java.io.*;

public class DataStreamsMain {

    public static void main(String[] args) {
        writeData();
        readData();
    }

    private static void writeData() {
        try {
            DataOutputStream out = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    FileStreamsMain.filePathInCurrentClassDirectory("files/dataout.dat"))));
            out.writeShort(1200);
            out.writeInt(50000);
            out.writeLong(12345678L);
            out.writeDouble(55.66);
            out.writeBoolean(true);
            out.writeUTF("Hello!!!");
            out.flush();
        } catch (IOException ex) {

        }
    }

    private static void readData() {
        try {
            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    FileStreamsMain.filePathInCurrentClassDirectory("files/dataout.dat"))));
            System.out.println("short: " + in.readShort());
            System.out.println("int: " + in.readInt());
            System.out.println("long: " + in.readLong());
            System.out.println("double: " + in.readDouble());
            System.out.println("boolean: " + in.readBoolean());
            System.out.println("String UTF: " + in.readUTF());
            System.out.println();
        } catch (IOException ex) {
        }
    }
}