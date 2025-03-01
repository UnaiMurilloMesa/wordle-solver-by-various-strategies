package org.umm.json_reader;

import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class WordleDictionary {
    private List<String> words;


    public WordleDictionary(String path) {
        this.words = new ArrayList<>();
        loadWordsFromJson(path);
    }

    private void loadWordsFromJson(String path) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            JSONArray jsonArray = new JSONArray(new JSONTokener(content));
            for (int i=0; i<jsonArray.length(); i++) {
                words.add(jsonArray.getString(i));
            }
        } catch (IOException e) {
            System.err.println("Error loading words from " + e.getMessage());
            words = List.of();
        } catch (Exception e) {
            System.err.println("Error loading words from " + e.getMessage());
        }
    }

    public List<String> getWords() {
        return words;
    }
}
