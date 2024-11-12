import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileErrorHandling {

    public static void readFile(String filename) {
        File file = new File(filename);
        try (FileReader reader = new FileReader(file)) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println("\nFile read successfully.");
        } catch (IOException e) {
            System.out.println("Error handling file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test file error handling
        readFile("nonexistentfile.txt");
    }
}
