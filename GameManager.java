
// ================================================================
// FILE 5: GameManager.java (SINGLETON DESIGN PATTERN)
// ================================================================
// TYPE: Singleton Class
// PURPOSE: Controls the entire game - menu, quiz, scoring
// PATTERN: SINGLETON  - only ONE instance allowed in whole application
// WHY SINGLETON:
//   - Only one game controller needed
//   - One score counter, one question list
//   - Access using getInstance() not 'new'

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {

    // SINGLETON Step 1: Private static instance variable
    private static GameManager instance;

    // List<Question> can hold MCQQuestion (FILE 2) or TrueFalseQuestion (FILE 3)
    // Because both implement Question interface (FILE 1) - POLYMORPHISM
    private List<Question> mcqQuestions = new ArrayList<>();
    private List<Question> trueFalseQuestions = new ArrayList<>();
    private Scanner scanner;

    // SINGLETON Step 2: Private constructor
    // Cannot call: new GameManager() from outside
    private GameManager() {
        scanner = new Scanner(System.in);
    }

    // SINGLETON Step 3: Public static method to get instance
    // Called by: Main.java (FILE 6)
    // Returns: The single GameManager object
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager(); // Created only ONCE
        }
        return instance; // Always returns SAME object
    }

    // Called by: Main.java (FILE 6)
    public void loadQuestions() {
        loadMCQQuestions();
        loadTrueFalseQuestions();
    }

    // Uses FACTORY PATTERN: QuestionFactory.createMCQ() (FILE 4)
    // Which creates: MCQQuestion objects (FILE 2)
    private void loadMCQQuestions() {

        // QuestionFactory (FILE 4) creates MCQQuestion (FILE 2)
        // Returns as Question interface type (FILE 1)
        mcqQuestions.add(QuestionFactory.createMCQ(
                "What is the size of int in Java?",
                "8 bit", "16 bit", "32 bit", "64 bit", "C"));

        mcqQuestions.add(QuestionFactory.createMCQ(
                "Which keyword is used to inherit a class in Java?",
                "implement", "inherits", "extends", "instanceof", "C"));

        mcqQuestions.add(QuestionFactory.createMCQ(
                "Which of these is NOT a Java primitive type?",
                "int", "boolean", "String", "char", "C"));

        mcqQuestions.add(QuestionFactory.createMCQ(
                "What is the default value of a boolean in Java?",
                "true", "false", "null", "0", "B"));

        mcqQuestions.add(QuestionFactory.createMCQ(
                "Which method is the entry point of a Java program?",
                "start()", "main()", "run()", "init()", "B"));
    }

    // Uses FACTORY PATTERN: QuestionFactory.createTrueFalse() (FILE 4)
    // Which creates: TrueFalseQuestion objects (FILE 3)
    private void loadTrueFalseQuestions() {

        // QuestionFactory (FILE 4) creates TrueFalseQuestion (FILE 3)
        // Returns as Question interface type (FILE 1)
        trueFalseQuestions.add(QuestionFactory.createTrueFalse(
                "Java is a platform independent language.", "true"));

        trueFalseQuestions.add(QuestionFactory.createTrueFalse(
                "In Java, '==' compares the content of two Strings.", "false"));

        trueFalseQuestions.add(QuestionFactory.createTrueFalse(
                "A class can extend multiple classes in Java.", "false"));

        trueFalseQuestions.add(QuestionFactory.createTrueFalse(
                "The 'final' keyword prevents a variable from being changed.", "true"));

        trueFalseQuestions.add(QuestionFactory.createTrueFalse(
                "Java supports operator overloading.", "false"));
    }

    // Called by: Main.java (FILE 6)
    public void startGame() {
        boolean running = true;

        while (running) {
            displayMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    // mcqQuestions contains MCQQuestion objects (FILE 2)
                    runQuiz(mcqQuestions, "MCQ");
                    break;
                case "2":
                    // trueFalseQuestions contains TrueFalseQuestion objects (FILE 3)
                    runQuiz(trueFalseQuestions, "TRUE/FALSE");
                    break;
                case "3":
                    System.out.println("\nThank you for playing! Goodbye!\n");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice! Please enter 1, 2, or 3.\n");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n============================================");
        System.out.println("         JAVA QUIZ GAME - MAIN MENU         ");
        System.out.println("============================================");
        System.out.println("  1. MCQ Quiz");
        System.out.println("  2. True/False Quiz");
        System.out.println("  3. Exit");
        System.out.println("============================================");
        System.out.print("Enter your choice (1/2/3): ");
    }

    // POLYMORPHISM: List<Question> can hold any class that implements Question
    // q.ask() calls the correct implementation based on actual object
    private void runQuiz(List<Question> questions, String quizType) {
        int score = 0;

        System.out.println("\n========== " + quizType + " QUIZ ==========");
        System.out.println("Total questions: " + questions.size());

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQuestion " + (i + 1) + " of " + questions.size());

            // q is Question interface type (FILE 1)
            // But holds actual object: MCQQuestion (FILE 2) or TrueFalseQuestion (FILE 3)
            Question q = questions.get(i);

            // POLYMORPHISM: Calls correct ask() implementation
            // If MCQQuestion (FILE 2) -> shows A,B,C,D options
            // If TrueFalseQuestion (FILE 3) -> shows true/false
            q.ask();

            String userAnswer = scanner.nextLine();

            // checkAnswer() implemented in FILE 2 or FILE 3
            if (q.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                // getCorrectAnswer() implemented in FILE 2 or FILE 3
                System.out.println("Wrong! Correct answer: " + q.getCorrectAnswer());
            }
        }

        displayResults(score, questions.size(), quizType);
    }

    private void displayResults(int score, int total, String quizType) {
        double percentage = (score * 100.0) / total;

        System.out.println("\n============================================");
        System.out.println("            " + quizType + " QUIZ RESULTS");
        System.out.println("============================================");
        System.out.println("Score: " + score + " / " + total);
        System.out.printf("Percentage: %.2f%%\n", percentage);

        if (percentage >= 80) {
            System.out.println("Result: EXCELLENT!");
        } else if (percentage >= 50) {
            System.out.println("Result: GOOD");
        } else {
            System.out.println("Result: NEEDS IMPROVEMENT");
        }
        System.out.println("============================================");

        System.out.println("\nPress Enter to return to Main Menu...");
        scanner.nextLine();
    }
}

