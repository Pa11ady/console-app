package ru.ylab.wallet.infrastructure.in.ui.command;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.application.WalletFacade;
import ru.ylab.wallet.application.dto.AddUserRequest;
import ru.ylab.wallet.infrastructure.in.ui.Command;
import ru.ylab.wallet.infrastructure.in.ui.Input;

import java.io.PrintStream;
import java.util.UUID;

@RequiredArgsConstructor
public class RegistrationCommand implements Command {
    private final PrintStream out = System.out;
    private final Input in;
    private final WalletFacade walletFacade;

    @Override
    public String name() {
        return "Регистрация нового пользователя";
    }

    @Override
    public boolean execute(UUID token) {
        out.println("=== Регистрация ===");
        String fullName = in.askString("Введите ФИО: ");
        String login = in.askString("Введите логин: ");
        String password = in.askString("Введите пароль: ");
        UUID id = UUID.randomUUID();
        walletFacade.registerUser(new AddUserRequest(id, fullName, login, password));
        out.println("Регистрация завершена");
        return true;
    }
}
