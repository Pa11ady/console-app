package ru.ylab.wallet.infrastructure.in.ui;

import java.util.UUID;

public interface Command {
    String name();

    boolean execute(UUID token);
}
