package com.task11.task11_01.controller.command;

import com.task11.task11_01.service.Service;
import com.task11.task11_01.util.InputUtility;

public class EmpsByDepCommand extends Command {
    @Override
    public String execute(Service service) {
        return service.showEmpsByDep(InputUtility.inputInt(view, manager));
    }
}
