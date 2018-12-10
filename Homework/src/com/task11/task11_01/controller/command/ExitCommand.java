package com.task11.task11_01.controller.command;

import com.task11.task11_01.service.Service;

public class ExitCommand extends Command {
    @Override
    public String execute(Service service) {
        service.closeConnection();
        System.exit(0);
        return null;
    }
}
