package ru.ylab.wallet.infrastructure.in.ui;

public interface Input {
    int askInt(String question);

    String askString(String question);

    void close();
}
