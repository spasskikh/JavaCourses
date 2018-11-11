package service;

import model.Model;
import model.entity.PunctuationMark;
import model.entity.Sentence;
import model.entity.Word;
import util.UserInput;
import util.Validator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Service {

    private Model model;
    private UserInput input;

    public void init() {
        model = new Model();
        input = new UserInput();
    }

    public int getSwitcher() {
        return input.getInt("Enter an action: ");
    }

    public List<Sentence> analyze() {

        List<String> rawText = getText();

        if (rawText != null) {
            parseRawData(rawText);
            model.getText().sort(Comparator.comparingInt(Sentence::getWords));
            return model.getText().stream().limit(10).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    private void parseRawData(List<String> text) {
        Pattern p = Validator.sentence;

        for (String s : text) {
            Matcher m = p.matcher(s);
            while (m.find()) {
                model.addSentence(parseSentence(m.group().trim()));
            }
        }
    }

    private Sentence parseSentence(String rawSentence) {
        Matcher word = Validator.word.matcher(rawSentence);
        Matcher symbol = Validator.symbol.matcher(rawSentence);
        Sentence sentence = new Sentence();

        while (word.find()) {
            sentence.put(new Word(word.group()));
            if (symbol.find()) {
                sentence.put(new PunctuationMark(symbol.group()));
            }
        }
        return sentence;
    }

    private List<String> getText() {

        Path path = Paths.get("/home/anton/Documents/java/IdeaProjects/JavaCourses/Project02_v02/text.txt");
        Charset charset = Charset.forName("UTF-8");
        List<String> lines;

        try {
            lines = Files.readAllLines(path, charset);
        } catch (IOException e) {
            lines = null;
        }

        return lines;

    }
}
