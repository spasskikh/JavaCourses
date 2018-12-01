package com.task10.controller;

import com.task10.controller.command.Command;
import com.task10.controller.command.ItemMenu;
import com.task10.exception.UnExistItemMenu;
import com.task10.util.InputUtility;
import com.task10.util.ResourceManager;
import com.task10.view.View;

public class Controller {

    private ResourceManager manager = ResourceManager.INSTANCE;
    private View view = new View();

    public void run() {
        while (true) {
            try {
                view.printMessage(manager.getMessage("mainMenu"));
                int number = InputUtility.inputInt(view, manager);
                Command command = defineCommand(number);
                view.printMessage(command.execute());
            } catch (UnExistItemMenu exp) {
                view.printError(exp.getMessage());
            }
        }
    }
    private Command defineCommand(int number) throws UnExistItemMenu {
        ItemMenu[] itemMenus = ItemMenu.values();
        if (number < 0 || number >= itemMenus.length) {
            throw new UnExistItemMenu(manager.getMessage("WRONG_INPUT_DATA"));
        }
        return itemMenus[number].getCommand();
    }
}
