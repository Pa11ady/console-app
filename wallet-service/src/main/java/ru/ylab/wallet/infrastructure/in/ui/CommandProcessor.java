package ru.ylab.wallet.infrastructure.in.ui;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.PrintStream;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class CommandProcessor {
    private final PrintStream out = System.out;
    private final Input in;
    private final List<Command> commands;

    @Setter
    private UUID token = null;

    @Setter
    private String caption = """
            
            ==================================
                            Меню
            ==================================
            """;

    public void start() {
        int select;
        do {
            showCommands();
           select = in.askInt("Выберите: ");
            if (select < 0 || select >= commands.size()) {
                out.println("Выберите: 0 .. " + (commands.size() - 1));
            }
        } while (commands.get(select).execute(token));
    }

    private void showCommands() {
        out.println(caption);
        for (int i = 0; i < commands.size(); i++) {
            out.println(i + ". " + commands.get(i).name());
        }
    }
}
