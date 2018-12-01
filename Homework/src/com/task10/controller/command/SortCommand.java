package com.task10.controller.command;

public class SortCommand extends Command {
    @Override
    public String execute() {
        return  service.sortByPublisher(manager.getMessage("SORTED_BOOKS"));
    }
}
