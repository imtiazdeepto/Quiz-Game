// ================================================================
// FILE 2 : MCQQuestion.java
// ================================================================
// TYPE: Concrete Class
// PURPOSE: Multiple Choice Questions with 4 options
// PATTERN: implements Question (FILE 1) - must provide all methods

public class MCQQuestion implements Question {

    // ENCAPSULATION: private fields
    private String questionText;
    private String correctAnswer;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    // Called by: QuestionFactory.createMCQ() (FILE 4)
    public MCQQuestion(String questionText, String optionA, String optionB,
                       String optionC, String optionD, String correctAnswer) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    // Implementing interface method from Question (FILE 1)
    // Called by: GameManager.runQuiz() (FILE 5)
    @Override
    public void ask() {
        System.out.println("----------------------------------------");
        System.out.println("MCQ: " + questionText);
        System.out.println("A) " + optionA);
        System.out.println("B) " + optionB);
        System.out.println("C) " + optionC);
        System.out.println("D) " + optionD);
        System.out.print("Your answer (A/B/C/D): ");
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
