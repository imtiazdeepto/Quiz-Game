<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/Design%20Patterns-Factory%20%7C%20Singleton-blue?style=for-the-badge" alt="Design Patterns"/>
  <img src="https://img.shields.io/badge/OOP-Interface%20%7C%20Polymorphism-green?style=for-the-badge" alt="OOP"/>
</p>

<h1 align="center">🎯 Java Quiz Game</h1>

<p align="center">
  A console-based quiz application demonstrating <b>Design Patterns</b> and <b>OOP Concepts</b> in Java 
</p>

<p align="center">
  <a href="#features">Features</a> •
  <a href="#design-patterns">Design Patterns</a> •
  <a href="#installation">Installation</a> •
  <a href="#usage">Usage</a> •
  <a href="#project-structure">Structure</a>
</p>

---

## 📖 About

This project is a **Quiz Game** application built in Java with help of AI that allows users to test their Java programming knowledge. It demonstrates the practical implementation of **Factory Pattern**, **Singleton Pattern**, and core **OOP concepts** like Interface, Polymorphism, and Encapsulation.

---

## ✨ Features

- 📋 **Multiple Choice Questions (MCQ)** - Questions with 4 options (A/B/C/D)
- ✓✗ **True/False Questions** - Simple true or false questions
- 📊 **Score Calculation** - Automatic scoring with percentage
- 🏆 **Grade System** - Excellent / Good / Needs Improvement
- 🔄 **Replay Option** - Take multiple quizzes without restarting
- 🎨 **Clean Interface** - Simple and user-friendly console UI

---

## 🏗️ Design Patterns

### 1. Factory Pattern
> **File:** `QuestionFactory.java`

Creates question objects without exposing instantiation logic.

```java
// Instead of using 'new' directly
Question q = new MCQQuestion(...);  // ❌

// We use Factory method
Question q = QuestionFactory.createMCQ(...);  // ✅
```

**Benefits:**
- Centralized object creation
- Easy to add new question types
- Hides implementation details

---

### 2. Singleton Pattern
> **File:** `GameManager.java`

Ensures only ONE instance of GameManager exists throughout the application.

```java
// Cannot create directly (private constructor)
GameManager gm = new GameManager();  // ❌ ERROR

// Must use getInstance()
GameManager gm = GameManager.getInstance();  // ✅
```

**Benefits:**
- Single point of control
- Global access
- Resource efficiency

---

## 📚 OOP Concepts

| Concept | Implementation | File |
|---------|----------------|------|
| **Interface** | `Question` defines contract | `Question.java` |
| **Implementation** | `implements Question` | `MCQQuestion.java`, `TrueFalseQuestion.java` |
| **Polymorphism** | `q.ask()` calls correct version | `GameManager.java` |
| **Encapsulation** | Private fields, public methods | All classes |

---

## 📁 Project Structure

```
java-quiz-game/
│
├── 📄 Question.java              # Interface - defines contract
├── 📄 MCQQuestion.java           # Implements Question - MCQ logic
├── 📄 TrueFalseQuestion.java     # Implements Question - T/F logic
├── 📄 QuestionFactory.java       # Factory Pattern - creates objects
├── 📄 GameManager.java           # Singleton Pattern - game controller
├── 📄 Main.java                  # Entry point
└── 📄 README.md                  # Documentation
```

---

## 🔄 Application Flow

```
Main.java
    │
    ▼
GameManager.getInstance() ─────────── Singleton Pattern
    │
    ▼
loadQuestions()
    │
    ▼
QuestionFactory ──────────────────── Factory Pattern
    │
    ├──► MCQQuestion
    │         │
    └──► TrueFalseQuestion
              │
              ▼
         Question (Interface)
              │
              ▼
startGame() ─► Menu ─► Quiz ─► Results ─► Menu (loop)
```

---

## ⚙️ Installation

### Prerequisites
- Java JDK 8 or higher
- Git (optional)

### Clone Repository
```bash
git clone https://github.com/yourusername/java-quiz-game.git
cd java-quiz-game
```

### Compile
```bash
javac *.java
```

### Run
```bash
java Main
```

---

## 🎮 Usage

1. Run the application
2. Choose quiz type from menu:
   - `1` - MCQ Quiz
   - `2` - True/False Quiz
   - `3` - Exit
3. Answer the questions
4. View your results
5. Return to menu or exit

---

## 📸 Screenshots

### Main Menu
```
============================================
         JAVA QUIZ GAME - MAIN MENU         
============================================
  1. MCQ Quiz
  2. True/False Quiz
  3. Exit
============================================
Enter your choice (1/2/3): 
```

### MCQ Question
```
Question 1 of 5
----------------------------------------
MCQ: What is the size of int in Java?
A) 8 bit
B) 16 bit
C) 32 bit
D) 64 bit
Your answer (A/B/C/D): 
```

### Results
```
============================================
            MCQ QUIZ RESULTS
============================================
Score: 4 / 5
Percentage: 80.00%
Result: EXCELLENT!
============================================
```

---

## 📋 Class Diagram

```
┌─────────────────────────────────────────────────────────────┐
│                    <<interface>>                            │
│                      Question                               │
├─────────────────────────────────────────────────────────────┤
│ + ask(): void                                               │
│ + checkAnswer(userAnswer: String): boolean                  │
│ + getCorrectAnswer(): String                                │
└─────────────────────────────────────────────────────────────┘
                    △                     △
                    │ implements          │ implements
                    │                     │
┌───────────────────┴───┐     ┌──────────┴────────────┐
│    MCQQuestion        │     │  TrueFalseQuestion    │
├───────────────────────┤     ├───────────────────────┤
│ - questionText        │     │ - questionText        │
│ - correctAnswer       │     │ - correctAnswer       │
│ - optionA/B/C/D       │     ├───────────────────────┤
├───────────────────────┤     │ + ask()               │
│ + ask()               │     │ + checkAnswer()       │
│ + checkAnswer()       │     │ + getCorrectAnswer()  │
│ + getCorrectAnswer()  │     └───────────────────────┘
└───────────────────────┘
            △                           △
            │ creates                   │ creates
            └───────────┬───────────────┘
                        │
          ┌─────────────┴─────────────┐
          │     QuestionFactory       │
          │     <<Factory>>           │
          ├───────────────────────────┤
          │ + createMCQ(): Question   │
          │ + createTrueFalse():      │
          │   Question                │
          └───────────────────────────┘
                        △
                        │ uses
                        │
          ┌─────────────┴─────────────┐
          │      GameManager          │
          │      <<Singleton>>        │
          ├───────────────────────────┤
          │ - instance: GameManager   │
          │ - mcqQuestions: List      │
          │ - trueFalseQuestions: List│
          ├───────────────────────────┤
          │ + getInstance()           │
          │ + loadQuestions()         │
          │ + startGame()             │
          └───────────────────────────┘
                        △
                        │ calls
                        │
          ┌─────────────┴─────────────┐
          │          Main             │
          ├───────────────────────────┤
          │ + main(args: String[])    │
          └───────────────────────────┘
```

---

## 🎓 Learning Objectives

This project helps understand:

- [x] How to define and implement **Interfaces**
- [x] **Factory Pattern** for object creation
- [x] **Singleton Pattern** for single instance
- [x] **Polymorphism** with interface references
- [x] **Encapsulation** with private fields
- [x] Menu-driven console applications

---

## 🚀 Future Enhancements

- [ ] Add Fill-in-the-Blank questions
- [ ] Implement timer for each question
- [ ] Load questions from JSON/XML file
- [ ] Add difficulty levels
- [ ] Save high scores
- [ ] Create GUI version (JavaFX/Swing)

---

## 🤝 Contributing

Contributions are welcome! Feel free to:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/NewFeature`)
3. Commit changes (`git commit -m 'Add NewFeature'`)
4. Push to branch (`git push origin feature/NewFeature`)
5. Open a Pull Request

---

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**Imtiaz Deepto**

- GitHub:  [@imtiazdeepto](https://github.com/imtiazdeepto)

---

<p align="center">
  Made with ❤️ for learning Java Design Patterns
</p>

<p align="center">
  ⭐ Star this repo if you found it helpful!
</p>
