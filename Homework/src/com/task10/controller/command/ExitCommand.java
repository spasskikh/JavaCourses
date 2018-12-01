package com.task10.controller.command;

public class ExitCommand extends Command {
    @Override
    public String execute() {
        service.saveBooks();
        System.exit(0);
        return null;
    }
}
