package handler.impl;

import handler.CommandHandler;

public class MenuCommandHandlerImpl implements CommandHandler {
    @Override
    public void handle() {
        System.out.println("In this application you can multiply two BigIntegers");
        System.out.println("please choose the algorithm");
        System.out.println("1 - BigInteger");
        System.out.println("2 - Custom Algorithm");
        System.out.println("restart");
        System.out.println("quit");
    }
}
