package com.task11.task11_02.controller.command;

import com.task11.task11_02.service.Service;
import com.task11.task11_02.util.InputUtility;

public class FindPublisherCommand extends Command {
    @Override
    public String execute(Service service) {
        return service.searchBooksByPublisher(InputUtility.inputString(view, manager));
    }
}
