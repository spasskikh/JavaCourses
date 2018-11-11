package model;

import model.entity.Sentence;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<Sentence> text;

    public Model() {
        text = new ArrayList<>();
    }

    public Model(List<Sentence> text) {
        this.text = text;
    }

    public List<Sentence> getText() {
        return text;
    }

    public void setText(List<Sentence> text) {
        this.text = text;
    }

    public void addSentence(Sentence sentence) {
        text.add(sentence);
    }
}
