package com.task11.task11_02.controller.command;

import com.task11.task11_02.service.Service;
import com.task11.task11_02.util.ResourceManager;
import com.task11.task11_02.view.View;

abstract public class Command {
    protected View view = new View();
    protected ResourceManager manager = ResourceManager.INSTANCE;

    public abstract String execute(Service service);
}
