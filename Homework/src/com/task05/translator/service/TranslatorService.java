package com.task05.translator.service;

import com.task05.recordbook.util.UserInput;
import com.task05.translator.model.TranslatorModel;

import java.util.Map;
//fixing
public class TranslatorService {

    private TranslatorModel model;
    private UserInput input;

    public TranslatorService() {
        model = new TranslatorModel();
        input = new UserInput();
    }

    public void init() {
        model.init();
    }

    public int getSwitcher() {
        return input.getInt("Enter an action: ");
    }

    public Map<String, String> getDictionary() {
        return model.getDictionary();
    }

    public void addNewWord() {
        input.nextLine();
        String key = input.getLine("Enter a word in english: ");
        String value = input.getLine("Enter a word in russian: ");

        model.add(key, value);
    }

    public String translate(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            String russian = model.getDictionary().get(words[i].toLowerCase());
            if (russian != null) {
                words[i] = russian;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(words[0].substring(0, 1).toUpperCase() + words[0].substring(1));
        for (int i = 1; i < words.length; i++) {
            sb.append(' ' + words[i]);
        }

        return sb.toString();
    }
}
