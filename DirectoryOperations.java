import java.io.File;
import java.io.IOException;

public class DirectoryOperations {

    // Method to list all files in a directory
    public static void listFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            System.out.println("Files in directory: " + directoryPath);
            for (String fileName : directory.list()) {
                System.out.println(fileName);
            }
        } else {
            System.out.println(directoryPath + " is not a valid directory.");
        }
    }

    // Method to create a new file in a directory
    public static void createFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    // Method to delete a file from a directory
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("File deleted: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void main(String[] args) {
        String directoryPath = "test_directory";
        String filePath = directoryPath + "/testfile.txt";

        // Create directory if it doesn't exist
        new File(directoryPath).mkdir();

        // List files in the directory
        listFilesInDirectory(directoryPath);

        // Create a new file
        createFile(filePath);

        // List files again to confirm file creation
        listFilesInDirectory(directoryPath);

        // Delete the file
        deleteFile(filePath);

        // List files again to confirm deletion
        listFilesInDirectory(directoryPath);
    }
}
