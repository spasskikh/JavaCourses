package com.task10.controller.command;

public class ShowBooksCommand extends Command {
    @Override
    public String execute() {
        return service.showAllBooks(manager.getMessage("listBooks"));
    }
}
