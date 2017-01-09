package java_se._1_io_streams.laboratory_works.lab_work_1_1_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountingUser users = new AccountingUser();
        String nameUser,
               next;

        System.out.println("List of users visiting the site:");
        users.printFile();

        do {
            System.out.print("\nEnter the user name who came to the site: ");
            nameUser = scanner.next();
            users.testUsers(nameUser);
            System.out.print("Enter the user yet? (Press y -> Yes, n -> No): ");
            next = scanner.next();
        } while (next.equalsIgnoreCase("y"));

        System.out.println("List of users visiting the site:");
        users.printFile();
    }
}
