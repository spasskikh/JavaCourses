package com.task11.task11_01.controller.command;

import com.task11.task11_01.service.Service;
import com.task11.task11_01.util.ResourceManager;
import com.task11.task11_01.view.View;

abstract public class Command {
    protected View view = new View();
    protected ResourceManager manager = ResourceManager.INSTANCE;

    public abstract String execute(Service service);
}
