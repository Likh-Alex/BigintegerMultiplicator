package handler.impl;

import handler.CommandHandler;

public class UnknownCommandHandlerImpl implements CommandHandler {
    @Override
    public void handle() {
        System.out.println("Bad parameter. Please try again");
    }
}
