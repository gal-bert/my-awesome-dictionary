package com.gregorius.myawesomedictionary;

import java.util.List;

public class Word {

    private String word;
    private List<Definitions> definitions;

    public Word(String word, List<Definitions> definitions) {
        this.word = word;
        this.definitions = definitions;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Definitions> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definitions> definitions) {
        this.definitions = definitions;
    }
}
