import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class QuizApplet extends Applet implements ActionListener {
    private Label questionLabel;
    private CheckboxGroup optionsGroup;
    private Checkbox option1, option2, option3, option4;
    private Button nextButton;
    private String[] questions;
    private String[][] options;
    private String[] correctAnswers;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int numberOfQuestions;
    private int timeLimit;

    // Lifecycle method: init()
    public void init() {
        setLayout(new FlowLayout());

        // Read parameters from the HTML page
        String numQuestionsParam = getParameter("numberOfQuestions");
        String timeLimitParam = getParameter("timeLimit");

        // Parse parameters and handle invalid or missing values
        try {
            numberOfQuestions = Integer.parseInt(numQuestionsParam);
        } catch (NumberFormatException e) {
            numberOfQuestions = 5;  // Default number of questions
        }

        try {
            timeLimit = Integer.parseInt(timeLimitParam);
        } catch (NumberFormatException e) {
            timeLimit = 30;  // Default time limit in seconds
        }

        // Initialize quiz questions and options
        initializeQuiz();

        // Set up UI components
        questionLabel = new Label();
        optionsGroup = new CheckboxGroup();
        option1 = new Checkbox("", optionsGroup, false);
        option2 = new Checkbox("", optionsGroup, false);
        option3 = new Checkbox("", optionsGroup, false);
        option4 = new Checkbox("", optionsGroup, false);
        nextButton = new Button("Next");

        // Add components to the applet
        add(questionLabel);
        add(option1);
        add(option2);
        add(option3);
        add(option4);
        add(nextButton);

        // Set up action listener for the button
        nextButton.addActionListener(this);

        // Display the first question
        displayQuestion();
    }

    // Lifecycle method: start()
    public void start() {
        System.out.println("Applet started.");
    }

    // Lifecycle method: stop()
    public void stop() {
        System.out.println("Applet stopped.");
    }

    // Lifecycle method: destroy()
    public void destroy() {
        System.out.println("Applet destroyed.");
    }

    // Initialize quiz questions, options, and answers
    private void initializeQuiz() {
        questions = new String[]{
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "Who wrote 'Hamlet'?",
            "What is the smallest prime number?",
            "Which element has the chemical symbol 'O'?"
        };

        options = new String[][]{
            {"Paris", "London", "Berlin", "Madrid"},
            {"Earth", "Mars", "Jupiter", "Saturn"},
            {"Shakespeare", "Tolkien", "Rowling", "Dickens"},
            {"0", "1", "2", "3"},
            {"Oxygen", "Gold", "Silver", "Iron"}
        };

        correctAnswers = new String[]{
            "Paris",
            "Mars",
            "Shakespeare",
            "2",
            "Oxygen"
        };
    }

    // Display the current question and options
    private void displayQuestion() {
        if (currentQuestionIndex < numberOfQuestions) {
            questionLabel.setText(questions[currentQuestionIndex]);
            option1.setLabel(options[currentQuestionIndex][0]);
            option2.setLabel(options[currentQuestionIndex][1]);
            option3.setLabel(options[currentQuestionIndex][2]);
            option4.setLabel(options[currentQuestionIndex][3]);
        } else {
            // Show the result if all questions are answered
            showResult();
        }
    }

    // Event handling for the "Next" button
    public void actionPerformed(ActionEvent e) {
        Checkbox selectedOption = optionsGroup.getSelectedCheckbox();
        if (selectedOption != null) {
            String selectedAnswer = selectedOption.getLabel();
            if (selectedAnswer.equals(correctAnswers[currentQuestionIndex])) {
                score++;
            }
        }
        currentQuestionIndex++;
        displayQuestion();
    }

    // Show the final result
    private void showResult() {
        removeAll(); // Remove all UI components
        Label resultLabel = new Label("Quiz Completed! Your score is: " + score + "/" + numberOfQuestions);
        add(resultLabel);
        validate();
    }
}
