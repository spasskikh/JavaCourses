package com.task10.controller.command;

import com.task10.util.InputUtility;

public class FindYearCommand extends Command {
    @Override
    public String execute() {
        return service.searchBooksAfterYear(InputUtility.inputInt(view, manager));
    }
}
