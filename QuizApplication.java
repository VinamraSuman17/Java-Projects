import java.util.Scanner;

public class QuizApplication {
    private static String[] questions = {
        "What is the capital of France?",
        "Which planet is known as the Red Planet?",
        "Who wrote 'Hamlet'?",
        "What is the smallest prime number?",
        "Which element has the chemical symbol 'O'?"
    };

    private static String[][] options = {
        {"Paris", "London", "Berlin", "Madrid"},
        {"Earth", "Mars", "Jupiter", "Saturn"},
        {"Shakespeare", "Tolkien", "Rowling", "Dickens"},
        {"0", "1", "2", "3"},
        {"Oxygen", "Gold", "Silver", "Iron"}
    };

    private static String[] correctAnswers = {
        "Paris",
        "Mars",
        "Shakespeare",
        "2",
        "Oxygen"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println("  " + (j + 1) + ". " + options[i][j]);
            }

            System.out.print("Enter your answer (1-4): ");
            int answer = scanner.nextInt();
            if (options[i][answer - 1].equals(correctAnswers[i])) {
                score++;
            }
        }

        System.out.println("Quiz Completed! Your score is: " + score + "/" + questions.length);
        scanner.close();
    }
}
