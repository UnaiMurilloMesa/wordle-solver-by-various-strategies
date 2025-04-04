# Wordle Solver for Spanish Words — Multiple Solving Strategies

This project implements several strategies to solve the popular game "Wordle" (in Spanish: *La Palabra del Día*).

The main goal is to keep the code clean, modular, extensible, and decoupled by applying **SOLID principles** and useful **design patterns**, such as the **Strategy Pattern**.

---

## 🧠 Strategies

- **Random Strategy**  
  Picks random words from the full word list without using any feedback. It’s not effective, but it can be fun if it happens to guess correctly early on.

- **Human-like Strategy**  
  Simulates how a person would play. Starts with all possible words and narrows them down based on the feedback (correct/incorrect letters). Prioritizes words with unique letters to maximize information gained.

- **Entropy-based Strategy** *(in progress)*  
  A more mathematical approach aimed at maximizing information through entropy. Likely to be the most optimal, although further improvements could still be made.

---

## 🚀 How to Run

1. **Clone the repository**
2. **Compile the project**  
   - Java SDK used: *Amazon Corretto 21.0.3*
3. **Run the `Main` class** alongside the game: [La Palabra del Día](https://lapalabradeldia.com/)
4. **Choose your strategy**
   - Keep in mind: the Random Strategy is just for fun.
5. **Enter feedback for each guess**  
   - Use `v` for green (correct letter & position)  
   - Use `a` for yellow (correct letter, wrong position)  
   - Use `g` for gray (incorrect letter)

---

Enjoy solving Wordle the smart way in Spanish! 🇪🇸
