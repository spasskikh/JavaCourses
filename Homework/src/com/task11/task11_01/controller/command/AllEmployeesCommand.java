package com.task11.task11_01.controller.command;

import com.task11.task11_01.service.Service;

public class AllEmployeesCommand extends Command {
    @Override
    public String execute(Service service) {
        return service.showAll(manager.getMessage("ALL_EMPS"), "Employees");
    }
}
