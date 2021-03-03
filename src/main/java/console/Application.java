package console;

import handler.CommandHandler;
import handler.impl.BigIntegerAlgorithmCommandHandler;
import handler.impl.CustomAlgorithmCommandHandlerImpl;
import handler.impl.ExitProgramCommandHandlerImpl;
import handler.impl.MenuCommandHandlerImpl;
import handler.impl.UnknownCommandHandlerImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    private final Map<String, CommandHandler> commandHandlers = new HashMap<>();

    {
        commandHandlers.put("1", new BigIntegerAlgorithmCommandHandler());
        commandHandlers.put("2", new CustomAlgorithmCommandHandlerImpl());
        commandHandlers.put("restart", new MenuCommandHandlerImpl());
        commandHandlers.put("quit", new ExitProgramCommandHandlerImpl());
    }

    public void run() {
        new MenuCommandHandlerImpl().handle();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        handleCommand(command);
    }

    private void handleCommand(String command) {
        while (true) {
            if (command.equals("restart")) {
                new MenuCommandHandlerImpl().handle();
                Scanner scanner = new Scanner(System.in);
                handleCommand(scanner.nextLine());
            }
            commandHandlers.getOrDefault(command, new UnknownCommandHandlerImpl()).handle();
            command = "restart";
        }
    }
}
