package model.entity;

public class PunctuationMark implements Symbol {

    private String value;

    public PunctuationMark() {
    }

    public PunctuationMark(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
