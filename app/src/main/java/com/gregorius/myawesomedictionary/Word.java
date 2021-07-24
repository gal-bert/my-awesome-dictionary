package com.gregorius.myawesomedictionary;

import java.util.List;

public class Word {

    private String word;
    private List<Definition> definitions;

    public Word(String word, List<Definition> definitions) {
        this.word = word;
        this.definitions = definitions;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }
}
