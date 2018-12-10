package com.task11.task11_02.controller;

import com.task11.task11_02.controller.command.Command;
import com.task11.task11_02.controller.command.ItemMenu;
import com.task11.task11_02.exception.UnExistItemMenu;
import com.task11.task11_02.service.Service;
import com.task11.task11_02.util.InputUtility;
import com.task11.task11_02.util.ResourceManager;
import com.task11.task11_02.view.View;

public class Controller {

    private ResourceManager manager = ResourceManager.INSTANCE;
    private View view = new View();
    private Service service = new Service();

    public void run() {

        String result = ItemMenu.INIT_DATA.getCommand().execute(service);
        if (result != null) {
            view.printMessage(result);
            System.exit(0);
        }

        while (true) {
            try {
                view.printMessage(manager.getMessage("MAIN_MENU"));
                int number = InputUtility.inputInt(view, manager);
                Command command = defineCommand(number);
                view.printMessage(command.execute(service));
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
