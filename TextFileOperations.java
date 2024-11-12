import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileOperations {

    // Method to write content to a text file
    public static void writeToFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            System.out.println("Content written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a text file
    public static void readFromFile(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println("\nFile read successfully.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filename = "sample.txt";
        String content = "Welcome to the File Management System!\nThis is a sample text file content.";

        // Write content to text file
        writeToFile(filename, content);

        // Read content from text file
        System.out.println("Reading from file:");
        readFromFile(filename);
    }
}
