package com.task09.task09_01.controller;

import com.task09.task09_01.service.Service;
import com.task09.task09_01.util.InputUtility;
import com.task09.task09_01.view.View;

public class Controller {

    private Service service = new Service();
    private View view = new View();

    public void run() {
        view.printMessage(View.MAIN_MENU);
        while (true) {
            int number = InputUtility.inputInt(view);
            ItemMenu command = defineMenuItem(number);
            switch (command) {
                case SHOW_BOOKS:
                    view.printMessage(View.ALL_BOOKS);
                    view.printMessage(service.showAllBooks());
                    break;
                case FIND_AUTHOR:
                    view.printMessage(service.searchBooksByAuthor(InputUtility.inputString(view)));
                    break;
                case FIND_PUBLISH:
                    view.printMessage(service.searchBooksByPublisher(InputUtility.inputString(view)));
                    break;
                case FIND_YEAR:
                    view.printMessage(service.searchBooksAfterYear(InputUtility.inputInt(view)));
                    break;
                case SORT_PUBLISH:
                    view.printMessage(View.SORTED_BOOKS);
                    view.printMessage(service.sortByPublisher());
                    break;
                case EXIT:
                    service.saveBooks();
                    System.exit(0);
                    break;
                default:
                    view.printMessage(View.WRONG_INPUT_DATA);
            }
        }
    }

    private ItemMenu defineMenuItem(int number) {
        ItemMenu[] itemMenus = ItemMenu.values();
        if (number < 0 || number >= itemMenus.length) {
            return ItemMenu.DEFAULT;
        }
        return itemMenus[number];
    }
}
