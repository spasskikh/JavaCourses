package com.task10.controller.command;

public enum ItemMenu {
    EXIT(new ExitCommand()),
    SHOW_BOOKS(new ShowBooksCommand()),
    FIND_AUTHOR(new FindAuthorsCommand()),
    FIND_PUBLISH(new FindPublisherCommand()),
    FIND_YEAR(new FindYearCommand()),
    SORT_PUBLISH(new SortCommand()),
    LANG(new ChangeLanguageCommand());

    private Command command;

    ItemMenu(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}