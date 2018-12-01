package com.task11.task11_02.controller.command;

import com.task11.task11_02.service.Service;

public class ShowBooksCommand extends Command {
    @Override
    public String execute(Service service) {
        return service.showAllBooks(manager.getMessage("listBooks"));
    }
}
