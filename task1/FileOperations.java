import java.io.*;
import java.util.*;

public class FileOperations {

    // Write to file
    public static void writeFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Hello, this is a sample file.\n");
            writer.write("This file is created for internship task.\n");
            writer.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    // Read file
    public static void readFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            System.out.println("\nReading File:");
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }

    // Modify file (append content)
    public static void modifyFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName, true); // true = append
            writer.write("This line is added later (modification).\n");
            writer.close();
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file.");
        }
    }

    public static void main(String[] args) {
        String fileName = "sample.txt";

        writeFile(fileName);
        readFile(fileName);
        modifyFile(fileName);
        readFile(fileName);
    }
}