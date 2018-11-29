package com.task09.task09_02.controller;

import com.task09.task09_02.service.Service;
import com.task09.task09_02.util.InputUtility;
import com.task09.task09_02.util.ResourceManager;
import com.task09.task09_02.view.View;

public class Controller {

    private Service service = new Service();
    private View view = new View();
    private ResourceManager manager = ResourceManager.INSTANCE;

    public void run() {
        while (true) {
            view.printMessage(manager.getMessage("mainMenu"));
            int number = InputUtility.inputInt(view, manager);
            ItemMenu command = defineMenuItem(number);
            switch (command) {
                case SHOW_BOOKS:
                    view.printMessage(manager.getMessage("listBooks"));
                    view.printMessage(service.showAllBooks());
                    break;
                case FIND_AUTHOR:
                    view.printMessage(service.searchBooksByAuthor(InputUtility.inputString(view, manager)));
                    break;
                case FIND_PUBLISH:
                    view.printMessage(service.searchBooksByPublisher(InputUtility.inputString(view, manager)));
                    break;
                case FIND_YEAR:
                    view.printMessage(service.searchBooksAfterYear(InputUtility.inputInt(view, manager)));
                    break;
                case SORT_PUBLISH:
                    view.printMessage(manager.getMessage("SORTED_BOOKS"));
                    view.printMessage(service.sortByPublisher());
                    break;
                case LANG:
                    view.printMessage(manager.getMessage("LANGUAGE"));
                    service.changeLanguage(InputUtility.inputInt(view, manager));
                    break;
                case EXIT:
                    service.saveBooks();
                    System.exit(0);
                    break;
                default:
                    view.printMessage(
                            manager.getMessage("WRONG_INPUT_DATA"));
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
