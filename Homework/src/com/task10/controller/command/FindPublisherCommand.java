package com.task10.controller.command;

import com.task10.util.InputUtility;

public class FindPublisherCommand extends Command {
    @Override
    public String execute() {
        return service.searchBooksByPublisher(InputUtility.inputString(view, manager));
    }
}
