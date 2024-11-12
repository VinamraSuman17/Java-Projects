import java.io.IOException;
import java.io.RandomAccessFile;

public class EbookNavigator {
    private RandomAccessFile ebook;
    private String[] chapterTitles = new String[100]; // Array to store up to 100 chapters
    private long[] chapterPositions = new long[100];  // Array to store chapter positions
    private int chapterCount = 0;

    // Open the eBook file
    public void openEbook(String filePath) throws IOException {
        ebook = new RandomAccessFile(filePath, "r");
        System.out.println("Opened eBook: " + filePath);
    }

    // Close the eBook file
    public void closeEbook() throws IOException {
        if (ebook != null) {
            ebook.close();
        }
    }

    // Create a table of contents for the eBook
    public void createTableOfContents() throws IOException {
        if (ebook == null) {
            throw new IOException("No eBook opened.");
        }

        String line;
        long position;
        ebook.seek(0);  // Start from the beginning of the file

        while ((line = ebook.readLine()) != null) {
            position = ebook.getFilePointer();  // Get the position of each line
            if (line.startsWith("Chapter")) {  // Assuming chapters start with "Chapter"
                chapterTitles[chapterCount] = line;
                chapterPositions[chapterCount] = position;
                chapterCount++;
            }
        }
        System.out.println("Table of Contents created with " + chapterCount + " chapters.");
    }

    // Navigate to a specific chapter
    public void navigateToChapter(String chapterTitle) throws IOException {
        for (int i = 0; i < chapterCount; i++) {
            if (chapterTitles[i].equalsIgnoreCase(chapterTitle)) {
                ebook.seek(chapterPositions[i]);
                System.out.println("Navigating to: " + chapterTitle);
                System.out.println(ebook.readLine());
                return;
            }
        }
        System.out.println("Chapter not found in Table of Contents.");
    }
}
