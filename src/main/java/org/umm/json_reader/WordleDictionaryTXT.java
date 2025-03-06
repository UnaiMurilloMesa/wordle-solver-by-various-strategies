package org.umm.json_reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordleDictionaryTXT {
    private List<String> words;

    public WordleDictionaryTXT(String path) {
        this.words = new ArrayList<>();
        loadWordsFromTXT(path);
    }

    public void loadWordsFromTXT(String path) {
        try {
            words = new ArrayList<>();
            Scanner s = new Scanner(new FileReader(path));
            while (s.hasNext()) {
                words.add(s.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getWords() {
        return words;
    }
}
