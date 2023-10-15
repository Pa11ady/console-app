package ru.ylab.wallet.infrastructure.in.ui.command;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.application.WalletFacade;
import ru.ylab.wallet.application.dto.AuthenticationRequest;
import ru.ylab.wallet.infrastructure.in.ui.Command;
import ru.ylab.wallet.infrastructure.in.ui.CommandProcessor;
import ru.ylab.wallet.infrastructure.in.ui.Input;

import java.io.PrintStream;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class LoginCommand implements Command {
    private final PrintStream out = System.out;
    private final Input in;
    private final WalletFacade walletFacade;
    private final CommandProcessor subCommandProcessor;

    @Override
    public String name() {
        return "Войти с паролем";
    }

    @Override
    public boolean execute(UUID token) {
        out.println("=== Вход ===");
        String login = in.askString("Введите логин: ");
        String password = in.askString("Введите пароль: ");
        Optional<UUID> id = walletFacade.authenticate(new AuthenticationRequest(login, password));
        if (id.isEmpty()) {
            out.println("Неверный логин или пароль!");
            return true;
        }
        subCommandProcessor.setCaption("\n======= Вы прошли аутентификацию");
        subCommandProcessor.setToken(id.get());
        subCommandProcessor.start();
        return true;
    }
}
