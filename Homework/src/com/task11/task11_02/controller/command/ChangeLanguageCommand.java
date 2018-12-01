package com.task11.task11_02.controller.command;

import com.task11.task11_02.exception.UnExistItemMenu;
import com.task11.task11_02.service.Service;
import com.task11.task11_02.util.InputUtility;

public class ChangeLanguageCommand extends Command {
    @Override
    public String execute(Service service) {
        view.printMessage(manager.getMessage("LANGUAGE"));
        while (true) {
            try {
                service.changeLanguage(
                        InputUtility.inputInt(view, manager));
                break;
            } catch (UnExistItemMenu exp) {
                view.printError(exp.getMessage());
            }
        }
        return "";
    }
}
