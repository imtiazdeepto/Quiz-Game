/*

 * FILES:
 * FILE 1: Question.java          - INTERFACE (contract for all questions)
 * FILE 2: MCQQuestion.java       - implements Question (FILE 1)
 * FILE 3: TrueFalseQuestion.java - implements Question (FILE 1)
 * FILE 4: QuestionFactory.java   - FACTORY PATTERN (creates objects)
 * FILE 5: GameManager.java       - SINGLETON PATTERN (controls game)
 * FILE 6: Main.java              - Entry point
 *
 * DESIGN PATTERNS :
 * 1. FACTORY PATTERN  - QuestionFactory creates objects
 * 2. SINGLETON PATTERN - GameManager has only one instance
 *
 * OOP CONCEPTS:
 * 1. INTERFACE     - Question defines contract
 * 2. IMPLEMENTATION - MCQQuestion & TrueFalseQuestion implement Question
 * 3. POLYMORPHISM  - Different behavior for ask() in each class
 * 4. ENCAPSULATION - Private fields with public methods
 */


// ================================================================
// FILE 1: Question.java (INTERFACE)
// ================================================================
// TYPE: Interface
// PURPOSE: Defines CONTRACT that all question types must follow
// WHY INTERFACE: All questions must have these methods, but each
//                implements them differently

public interface Question {

    // Any class that implements Question MUST provide these methods
    // No body here - just method signatures

    // Must be implemented by: MCQQuestion (FILE 2), TrueFalseQuestion (FILE 3)
    void ask();

    // Must be implemented by: MCQQuestion (FILE 2), TrueFalseQuestion (FILE 3)
    boolean checkAnswer(String userAnswer);

    // Must be implemented by: MCQQuestion (FILE 2), TrueFalseQuestion (FILE 3)
    String getCorrectAnswer();
}

