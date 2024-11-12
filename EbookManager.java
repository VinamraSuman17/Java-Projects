import java.io.*;

public class EbookManager {
    // Array to store eBook metadata (title, author, and file path)
    private String[] ebookTitles = new String[100];  // Array to store titles of up to 100 eBooks
    private String[] ebookAuthors = new String[100]; // Array to store authors of up to 100 eBooks
    private String[] ebookFilePaths = new String[100]; // Array to store file paths of up to 100 eBooks
    private int ebookCount = 0; // Counter to track number of eBooks uploaded

    // Method to upload an eBook using character streams
    public void uploadEbook(String title, String author, String content) {
        String fileName = title + ".txt";
        try (FileWriter writer = new FileWriter("eBooks/" + fileName)) {
            writer.write(content);

            // Store metadata in arrays
            ebookTitles[ebookCount] = title;
            ebookAuthors[ebookCount] = author;
            ebookFilePaths[ebookCount] = "eBooks/" + fileName;
            ebookCount++;

            System.out.println("eBook '" + title + "' uploaded successfully.");
        } catch (IOException e) {
            System.out.println("Error uploading eBook: " + e.getMessage());
        }
    }

    // Method to download an eBook using character streams
    public void downloadEbook(String title) {
        int index = findEbookByTitle(title);
        if (index == -1) {
            System.out.println("eBook not found.");
            return;
        }

        String filePath = ebookFilePaths[index];
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error downloading eBook: " + e.getMessage());
        }
    }

    // Method to find an eBook index by its title
    private int findEbookByTitle(String title) {
        for (int i = 0; i < ebookCount; i++) {
            if (ebookTitles[i].equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    // Method to display all available eBooks
    public void displayEbooks() {
        System.out.println("Available eBooks:");
        for (int i = 0; i < ebookCount; i++) {
            System.out.println("Title: " + ebookTitles[i] + ", Author: " + ebookAuthors[i]);
        }
    }
}
