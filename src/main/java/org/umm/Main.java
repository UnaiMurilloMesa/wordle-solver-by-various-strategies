package org.umm;

import org.umm.json_reader.WordleDictionary;
import org.umm.menus.MainMenu;
import org.umm.menus.MenuHandler;
import org.umm.strategies.SolverStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuHandler menuHandler = new MainMenu(sc);
        WordleDictionary wordleDictionary = new WordleDictionary("src/main/resources/palabras5Letras.json");
        int option;

        do {
            menuHandler.displayMenu();
            option = menuHandler.getChoice();
            SolverStrategy run = menuHandler.chooseChoice(option);
            run.play(wordleDictionary.getWords());
        } while (!menuHandler.shouldExit(option));


    }
}