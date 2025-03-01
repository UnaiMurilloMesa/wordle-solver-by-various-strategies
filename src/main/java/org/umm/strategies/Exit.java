package org.umm.strategies;

import java.util.List;

public class Exit implements SolverStrategy {

    @Override
    public String getNextGuess(List<String> words, String feedback) {
        return "";
    }

    @Override
    public void play(List<String> words) {
        System.out.println("Finalizando programa...");
    }
}
