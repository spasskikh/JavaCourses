package com.task05.translator.controller;

import com.task05.translator.view.View;
import com.task05.translator.service.TranslatorService;
//fixing
public class TranslatorController {

    private TranslatorService service;
    private View view;

    public TranslatorController() {
        service = new TranslatorService();
        view = new View();
    }

    public void run() {
        service.init();

        view.printMenu();
        int switcher = service.getSwitcher();

        while (switcher != 0) {
            switch (switcher) {
                case 1:
                    view.printDictionary(service.getDictionary());
                    switcher = service.getSwitcher();
                    break;
                case 2:
                    service.addNewWord();
                    switcher = service.getSwitcher();
                    break;
                case 3:
                    String red = service.translate("This is red table");
                    view.printMessage(red);
                    switcher = service.getSwitcher();
                    break;
                case 4:
                    String black = service.translate("This is black table");
                    view.printMessage(black);
                    switcher = service.getSwitcher();
                    break;
                default:
                    view.printMessage("Incorrect parameter.");
                    switcher = service.getSwitcher();
                    break;
            }
        }


    }
}
