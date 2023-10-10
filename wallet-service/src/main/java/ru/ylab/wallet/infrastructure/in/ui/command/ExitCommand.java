package ru.ylab.wallet.infrastructure.in.ui.command;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.infrastructure.in.ui.Command;

import java.util.UUID;

@RequiredArgsConstructor
public class ExitCommand implements Command {
    private final String name;

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean execute(UUID token) {
        return false;
    }
}
