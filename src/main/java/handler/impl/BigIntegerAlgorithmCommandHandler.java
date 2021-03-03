package handler.impl;

import handler.CommandHandler;
import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerAlgorithmCommandHandler implements CommandHandler {
    private static final String WHITESPACE = " ";

    @Override
    public void handle() {
        promptUser();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        processInput(input);
    }

    private void promptUser() {
        System.out.println("BigInt algorithm");
        System.out.println("Please enter two numbers to multiply");
        System.out.println("separated by space or * sign");
    }

    public void processInput(String input) {
        if (input.contains(WHITESPACE)) {
            String firstNumber = input.substring(0, input.indexOf(WHITESPACE));
            String secondNumber = input.substring(input.lastIndexOf(WHITESPACE) + 1);
            boolean isFirstNumeric = firstNumber.chars().allMatch(Character::isDigit);
            boolean isSecondNumeric = secondNumber.chars().allMatch(Character::isDigit);
            if (isFirstNumeric && isSecondNumeric) {
                calculate(firstNumber, secondNumber);
                return;
            }
        }
        System.out.println("Bad parameters. Please try again");
    }

    public BigInteger calculate(String firstNumber, String secondNumber) {
        BigInteger a = new BigInteger(firstNumber);
        BigInteger b = new BigInteger(secondNumber);
        BigInteger result = a.multiply(b);
        System.out.println("Using BigInteger algorithm");
        System.out.println("Result of multiplying:\n" + a + "\nand\n"
                + b + "\nWill be : " + result);
        return result;
    }
}
