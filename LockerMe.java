package com.company;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

public class LockerMe {
    public static void listingFile() {
        File fileDir = new File("C:\\lockerme");
        fileDir.mkdir();


        if (fileDir.isDirectory()) {
            List<String> listFile = Arrays.asList(fileDir.list());
            Collections.sort(listFile);
            System.out.println("Following Files are Present ");
            for (String s : listFile) {
                System.out.println(s);

            }
        } else {
            System.out.println(fileDir.getAbsolutePath() + " is not a directory");
        }
        LockerMe.mainMenu();

    }

    public static void createFile() {
        File file = new File("C:\\locker");
        file.mkdir();


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file name : ");
        String name = sc.nextLine();
        File file1 = new File("C:\\lockerme\\" + name);

        try {
            if (file1.createNewFile()) {
                System.out.println("Created a File");
                LockerMe.fileMenuOperations();
            } else {
                System.out.println("File already Present");
                LockerMe.fileMenuOperations();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void deleteMethod() {
        String filename;
        Scanner scan = new Scanner(System.in);

        System.out.println("File name  to Delete: ");
        filename = scan.nextLine();

        File file = new File("C:\\locker\\" + filename);

        if (file.delete()) {
            System.out.println("File deleted ");
            LockerMe.fileMenuOperations();
        } else {
            System.out.println(" File not found");
            LockerMe.fileMenuOperations();
        }

    }

    public static void searchMethod() {
        System.out.println("Enter file name to Search");
        Scanner s1 = new Scanner(System.in);
        String folderName = s1.next();
        File file = new File("C:\\lockerme\\" + folderName);

        if (file.exists()) {
            System.out.println("File found" + "\n" + " file location");
            System.out.println(file.getAbsolutePath());
            LockerMe.fileMenuOperations();
        } else {
            System.out.println("File Not Found");
            LockerMe.fileMenuOperations();
        }
    }

    public static void mainMenu() {
        System.out.println("Choose from the following");
        System.out.println("1.List of Files ");
        System.out.println("2.Business Level Operations");
        System.out.println("3.Close application");

    }

    public static void fileMenuOperations() {

        System.out.println("Please choose one of the following options :-");
        System.out.println("1. Add a file");
        System.out.println("2. Delete a File");
        System.out.println("3. Search a File");
        System.out.println("4. Return to main menu");
        Scanner sc2 = new Scanner(System.in);
        try {

            int choice = sc2.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add a File selected");
                    createFile();

                    break;
                case 2:
                    System.out.println(" Delete file Selected");
                    deleteMethod();
                    break;
                case 3:
                    System.out.println("Search a File");
                    searchMethod();
                    break;
                case 4:
                    System.out.println("Going back to MainMenu");
                    LockerMe.mainMenu();
                    break;
            }

        } catch (Exception e) {
            System.out.println("Enter a valid number");
            LockerMe.fileMenuOperations();
        }


    }

    public static void main(String[] args) {

        System.out.println("Welcome to LOCKERME");
        System.out.println("Developed by Nitin");

        Scanner sc = new Scanner(System.in);
        LockerMe.mainMenu();
        while (true) {


            try {

                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("These are the files ");
                        listingFile();
                        break;
                    case 2:
                        LockerMe.fileMenuOperations();
                        break;

                    case 3:
                        System.out.println("Closed");

                        System.exit(option);
                        break;
                    default:
                        System.out.println("Enter a valid number");
                        break;

                }
            } catch (Exception e) {
                System.out.println("Enter valid number");
                LockerMe.main(args);
            }
        }
    }
}