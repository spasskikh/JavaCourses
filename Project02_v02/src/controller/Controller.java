package controller;

import model.entity.Sentence;
import service.Service;
import view.Viewer;

import java.util.List;

public class Controller {

    private Service service;
    private Viewer<Sentence> viewer;

    public Controller() {
        this.service = new Service();
        this.viewer = new Viewer<>();
    }

    public void run() {
        service.init();
        viewer.printMenu();

        int switcher = service.getSwitcher();

        while (switcher != 0) {
            switch (switcher) {
                case 1:
                    process();
                    switcher = service.getSwitcher();
                    break;
                default:
                    viewer.printMessage("Incorrect input.");
                    switcher = service.getSwitcher();
                    break;
            }
        }
    }

    private void process() {
        List<Sentence> text = service.analyze();
        if (text == null) {
            viewer.printMessage("Text is currently unavailable.");
        } else {
            viewer.printText("Sorted sentences:", text);
        }
    }
}
