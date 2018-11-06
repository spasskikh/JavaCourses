package com.task05.recordbook.controller;

import com.task05.recordbook.service.RecordsService;
import com.task05.recordbook.view.Viewer;

public class RecordsController {

    private RecordsService service;
    private Viewer viewer;

    public RecordsController() {
        service = new RecordsService();
        viewer = new Viewer();
    }

    public void run() {
        service.initData();

        viewer.printMenu();

        int switcher = service.getSwitcher();

        while (switcher != 0) {
            switch (switcher) {
                case 1:
                    viewer.print("All records:", service.getAllRecords());
                    switcher = service.getSwitcher();
                    break;
                case 2:
                    service.addRecord();
                    viewer.printMessage("New record added.");
                    switcher = service.getSwitcher();
                    break;
                default:
                    viewer.printMessage("Incorrect parameter.");
                    switcher = service.getSwitcher();
                    break;
            }
        }

    }
}
