package ru.ylab.wallet.infrastructure.in.ui.command;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.application.WalletFacade;
import ru.ylab.wallet.infrastructure.in.ui.Command;

import java.util.UUID;

@RequiredArgsConstructor
public class LogoutCommand implements Command {
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
