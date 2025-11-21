
// ================================================================
// FILE 3: TrueFalseQuestion.java
// ================================================================
// TYPE: Concrete Class
// PURPOSE: True/False Questions
// PATTERN: implements Question (FILE 1) - must provide all methods

public class TrueFalseQuestion implements Question {

    // ENCAPSULATION: private fields
    private String questionText;
    private String correctAnswer;

    // Called by: QuestionFactory.createTrueFalse() (FILE 4)
    public TrueFalseQuestion(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    // Implementing interface method from Question (FILE 1)
    // Called by: GameManager.runQuiz() (FILE 5)
    @Override
    public void ask() {
        System.out.println("----------------------------------------");
        System.out.println("True/False: " + questionText);
        System.out.print("Your answer (true/false): ");
    }

    // Implementing interface method from Question (FILE 1)
    // Called by: GameManager.runQuiz() (FILE 5)
    @Override
    public boolean checkAnswer(String userAnswer) {
        if (userAnswer == null) return false;
        return correctAnswer.equalsIgnoreCase(userAnswer.trim());
    }

    // Implementing interface method from Question (FILE 1)
    // Called by: GameManager.runQuiz() (FILE 5)
    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
