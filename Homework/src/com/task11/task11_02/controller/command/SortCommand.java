package com.task11.task11_02.controller.command;

import com.task11.task11_02.service.Service;

public class SortCommand extends Command {
    @Override
    public String execute(Service service) {
        return  service.sortByPublisher(manager.getMessage("SORTED_BOOKS"));
    }
}
