package ru.ylab.wallet.infrastructure.in.ui;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private final PrintStream out = System.out;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int askInt(String question) {
        while (true) {
            try {
                return Integer.parseInt(askString(question));
            } catch (NumberFormatException exception) {
                out.println("Введите валидные данные");
            }
        }
    }

    @Override
    public String askString(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
