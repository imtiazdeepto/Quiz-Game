// ================================================================
// FILE 4: QuestionFactory.java (FACTORY DESIGN PATTERN)
// ================================================================
// TYPE: Factory Class
// PURPOSE: Creates all question objects in ONE place
// PATTERN: FACTORY - hides object creation using 'new' keyword
// WHY FACTORY: 
//   - Other classes don't need to know which constructor to call
//   - Easy to add new question types later
//   - Centralized object creation

public class QuestionFactory {

    // FACTORY METHOD for MCQ
    // Called by: GameManager.loadMCQQuestions() (FILE 5)
    // Creates: MCQQuestion object (FILE 2)
    // Returns: Question type (FILE 1) - can hold any implementation
    public static Question createMCQ(String questionText, String optionA,
                                     String optionB, String optionC, String optionD, String correctAnswer) {

        // Creating MCQQuestion (FILE 2) which implements Question (FILE 1)
        return new MCQQuestion(questionText, optionA, optionB, optionC, optionD, correctAnswer);
    }

    // FACTORY METHOD for True/False
    // Called by: GameManager.loadTrueFalseQuestions() (FILE 5)
    // Creates: TrueFalseQuestion object (FILE 3)
    // Returns: Question type (FILE 1) - can hold any implementation
    public static Question createTrueFalse(String questionText, String correctAnswer) {

        // Creating TrueFalseQuestion (FILE 3) which implements Question (FILE 1)
        return new TrueFalseQuestion(questionText, correctAnswer);
    }
}
