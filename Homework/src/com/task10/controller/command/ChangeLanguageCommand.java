package com.task10.controller.command;

import com.task10.exception.UnExistItemMenu;
import com.task10.util.InputUtility;

public class ChangeLanguageCommand extends Command {
    @Override
    public String execute() {
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
        return null;
    }
}
