package org.umm.strategies;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomStrategy implements SolverStrategy {
    private Random random = new Random();
    Scanner sc = new Scanner(System.in);

    @Override
    public String getNextGuess(List<String> words, String feedback) {
        if (words.isEmpty()) {
            return "";
        } else {
            return words.get(random.nextInt(words.size()));
        }
    }

    @Override
    public void play(List<String> words) {
        boolean correct = false;
        String response;
        int count = 0;

        System.out.println("___________Has escogido la estrategia de palabras aleatorias___________");
        do {
            System.out.println("\nGuess: " + getNextGuess(words, ""));
            System.out.print("Es esa la palabra? Escribe 'C' si es correcta o 'I' en caso contratio: ");
            response = sc.nextLine();
            if (response.equals("C")) {
                correct = true;
            } else {
                count++;
            }
        } while (!correct && count < 6);

        if (!correct) {
            System.out.println("\n----------------Otra vez será...----------------");
        } else {
            System.out.println("\n----------------Oleee!!!----------------");
        }
    }
}
