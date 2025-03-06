package org.umm;

import org.umm.json_reader.WordleDictionaryJSON;
import org.umm.json_reader.WordleDictionaryTXT;
import org.umm.menus.MainMenu;
import org.umm.menus.MenuHandler;
import org.umm.strategies.SolverStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuHandler menuHandler = new MainMenu(sc);
        WordleDictionaryJSON wordleDictionaryJSON = new WordleDictionaryJSON("src/main/resources/palabras5Letras.json");
        WordleDictionaryTXT wordleDictionaryTXT = new WordleDictionaryTXT("src/main/resources/words-en.txt");

        int option;

        do {
            menuHandler.displayMenu();
            option = menuHandler.getChoice();
            SolverStrategy run = menuHandler.chooseChoice(option);
            run.play(wordleDictionaryJSON.getWords());
        } while (!menuHandler.shouldExit(option));


    }
}