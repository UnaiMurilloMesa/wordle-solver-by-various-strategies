package org.umm.menus;

import org.umm.strategies.*;

import java.util.Scanner;

public class MainMenu implements MenuHandler {
    private final Scanner sc;

    public MainMenu(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void displayMenu() {
        System.out.println();
        System.out.println();
        System.out.println("---- Wordle Solver ----");
        System.out.println("Escoge la estrategia para el solver");
        System.out.println(" 0 _ Palabras aleatorias");
        System.out.println(" 1 _ Estrategia simple");
        System.out.println(" 2 _ Estrategia entropía");
        System.out.println(" 3 _ Salir");
        System.out.print("Elige la opción: ");
    }

    @Override
    public int getChoice() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public SolverStrategy chooseChoice(int option) {
        switch (option) {
            case 0:
                return new RandomStrategy();
            case 1:
                return new SimpleStrategy();
            case 2:
                return new EntropyStrategy();
            case 3:
                return new Exit();
            default:
                System.out.println("Opción no válida, escoge entre las opciones señaladas en el menú");
                return null;
        }
    }

    @Override
    public boolean shouldExit(int option) {
        return option == 3;
    }
}
