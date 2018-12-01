package com.task10.controller.command;

import com.task10.service.Service;
import com.task10.util.ResourceManager;
import com.task10.view.View;

abstract public class Command {
    protected Service service = new Service();
    protected View view = new View();
    protected ResourceManager manager = ResourceManager.INSTANCE;

    public abstract String execute();
}
