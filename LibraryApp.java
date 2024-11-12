import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LibraryApp extends Frame implements ActionListener {
    private EbookManager ebookManager = new EbookManager();
    private TextArea textArea = new TextArea();
    private TextField titleField = new TextField();
    private TextField authorField = new TextField();
    private TextField contentField = new TextField();

    public LibraryApp() {
        setLayout(new FlowLayout());

        // Set up GUI components
        Label titleLabel = new Label("eBook Title:");
        Label authorLabel = new Label("eBook Author:");
        Label contentLabel = new Label("eBook Content:");
        Button uploadButton = new Button("Upload");
        Button downloadButton = new Button("Download");
        Button displayButton = new Button("Display eBooks");

        // Add components to Frame
        add(titleLabel);
        add(titleField);
        add(authorLabel);
        add(authorField);
        add(contentLabel);
        add(contentField);
        add(uploadButton);
        add(downloadButton);
        add(displayButton);
        add(textArea);

        // Set up button actions
        uploadButton.addActionListener(this);
        downloadButton.addActionListener(this);
        displayButton.addActionListener(this);

        // Set Frame properties
        setTitle("Digital Library System");
        setSize(600, 400);
        setVisible(true);
    }

    // Action listener for buttons
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String title = titleField.getText();
        String author = authorField.getText();
        String content = contentField.getText();

        switch (command) {
            case "Upload":
                ebookManager.uploadEbook(title, author, content);
                break;
            case "Download":
                ebookManager.downloadEbook(title);
                break;
            case "Display eBooks":
                ebookManager.displayEbooks();
                break;
        }
    }

    public static void main(String[] args) {
        new LibraryApp();
    }
}
