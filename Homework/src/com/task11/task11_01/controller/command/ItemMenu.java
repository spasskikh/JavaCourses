package com.task11.task11_01.controller.command;

public enum ItemMenu {
    EXIT(new ExitCommand()),
    ALL_EMPLOYEES(new AllEmployeesCommand()),
    ALL_TASKS(new AllTasksCommand()),
    EMPS_BY_DEP(new EmpsByDepCommand()),
    TASKS_BY_EMP(new TasksByEmp()),
    NEW_TASK(new NewTaskCommand()),
    INIT_DATA(new InitData());

    private Command command;

    ItemMenu(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
