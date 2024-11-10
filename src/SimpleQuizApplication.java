import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleQuizApplication {

    // Question class to hold question data
    static class Question {
        private String questionText;
        private List<String> options;
        private int correctAnswerIndex;

        public Question(String questionText, List<String> options, int correctAnswerIndex) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public String getQuestionText() {
            return questionText;
        }

        public List<String> getOptions() {
            return options;
        }

        public boolean isCorrectAnswer(int answerIndex) {
            return answerIndex == correctAnswerIndex;
        }
    }

    // Main method
    public static void main(String[] args) {
        List<Question> quizQuestions = new ArrayList<>();
        initializeQuestions(quizQuestions);

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Simple Quiz Application!");
        System.out.println("Please answer the following questions:");

        for (Question question : quizQuestions) {
            System.out.println("\n" + question.getQuestionText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter the number of your answer: ");
            int userAnswer = scanner.nextInt() - 1; // Convert to zero-based index

            if (question.isCorrectAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + options.get(question.correctAnswerIndex));
            }
        }

        System.out.println("\nYour total score: " + score + "/" + quizQuestions.size());
        scanner.close();
    }

    // Method to initialize quiz questions
    private static void initializeQuestions(List<Question> quizQuestions) {
        quizQuestions.add(new Question("What is the capital of France?",
                List.of("Berlin", "Madrid", "Paris", "Rome"), 2));
        quizQuestions.add(new Question("What is 2 + 2?",
                List.of("3", "4", "5", "6"), 1));
        quizQuestions.add(new Question("What is the largest planet in our solar system?",
                List.of("Earth", "Mars", "Jupiter", "Saturn"), 2));
        quizQuestions.add(new Question("Which element has the chemical symbol 'O'?",
                List.of("Oxygen", "Gold", "Silver", "Hydrogen"), 0));
        quizQuestions.add(new Question("What is the boiling point of water?",
                List.of("50°C", "100°C", "0°C", "200°C"), 1));
    }
}