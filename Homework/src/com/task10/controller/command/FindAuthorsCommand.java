package com.task10.controller.command;

import com.task10.util.InputUtility;

public class FindAuthorsCommand extends Command {
    @Override
    public String execute() {
        return service.searchBooksByAuthor(InputUtility.inputString(view, manager));
    }
}
