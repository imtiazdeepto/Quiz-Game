
// ================================================================
// FILE 6: Main.java (Entry Point)
// ================================================================
// PURPOSE: Starting point of the application

public class Main {
    public static void main(String[] args) {

        // SINGLETON PATTERN: Get instance from GameManager (FILE 5)
        // Cannot use: new GameManager() - constructor is private
        GameManager gameManager = GameManager.getInstance();

        // Calls FILE 5 method
        // -> Uses FACTORY PATTERN: QuestionFactory (FILE 4)
        // -> Creates MCQQuestion (FILE 2) and TrueFalseQuestion (FILE 3)
        gameManager.loadQuestions();

        // Calls FILE 5 method -> shows menu, runs quiz
        // Inside runQuiz() uses POLYMORPHISM:
        //   - q.ask() -> FILE 2 or FILE 3 implementation
        //   - q.checkAnswer() -> FILE 2 or FILE 3 implementation
        //   - q.getCorrectAnswer() -> FILE 2 or FILE 3 implementation
        gameManager.startGame();
    }
}