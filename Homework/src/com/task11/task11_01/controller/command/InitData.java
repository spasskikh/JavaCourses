package com.task11.task11_01.controller.command;

import com.task11.task11_01.service.Service;

public class InitData extends Command {
    @Override
    public String execute(Service service) {
        return service.init();
    }
}
