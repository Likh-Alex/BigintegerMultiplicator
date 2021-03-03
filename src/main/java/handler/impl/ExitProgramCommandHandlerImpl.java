package handler.impl;

import handler.CommandHandler;

public class ExitProgramCommandHandlerImpl implements CommandHandler {
    @Override
    public void handle() {
        System.out.println("Thank you for choosing our software");
        System.exit(0);
    }
}
