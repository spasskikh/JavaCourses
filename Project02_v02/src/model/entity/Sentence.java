package model.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private List<Symbol> value;
    private int words;

    public Sentence() {
        value = new ArrayList<>();
    }

    public Sentence(List<Symbol> value) {
        this.value = value;
    }

    public List<Symbol> getValue() {
        return value;
    }

    public void setValue(List<Symbol> value) {
        this.value = value;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public void put(Symbol s) {
        value.add(s);
        if (s instanceof Word) {
            words++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Symbol s : value) {
            sb.append(s);
        }
        return sb.toString();
    }
}
