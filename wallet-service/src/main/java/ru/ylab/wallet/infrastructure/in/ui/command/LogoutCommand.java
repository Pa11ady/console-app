package ru.ylab.wallet.infrastructure.in.ui.command;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.application.WalletFacade;
import ru.ylab.wallet.application.dto.TransactionResponse;
import ru.ylab.wallet.infrastructure.in.ui.Command;
import ru.ylab.wallet.infrastructure.in.ui.Input;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RequiredArgsConstructor
public class LogoutCommand implements Command {
    private final PrintStream out = System.out;
    private final WalletFacade walletFacade;

    @Override
    public String name() {
        return "==== Выход из профиля";
    }

    @Override
    public boolean execute(UUID token) {
        if (token == null) {
            return false;
        }
        walletFacade.logout(token);
        return false;
    }
}
