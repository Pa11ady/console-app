package ru.ylab.wallet.infrastructure.in.ui.command;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.application.WalletFacade;
import ru.ylab.wallet.application.dto.UserInfoResponse;
import ru.ylab.wallet.common.RubleConverter;
import ru.ylab.wallet.infrastructure.in.ui.Command;

import java.io.PrintStream;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UserInfoCommand implements Command {
    private final PrintStream out = System.out;
    private final WalletFacade walletFacade;

    @Override
    public String name() {
        return "Информация о  пользователе";
    }

    @Override
    public boolean execute(UUID token) {
        if (token == null) {
            return false;
        }
        out.println("=== Информация ===");
        Optional<UserInfoResponse> response = walletFacade.getUserInfo(token);
        if (response.isEmpty()) {
            out.println("Пользователь не найден");
            return false;
        }
        UserInfoResponse userInfo = response.get();
        out.println("Пользователь: " + userInfo.fullName());
        out.println("Логин: " + userInfo.login());
        out.println("Баланс: " + RubleConverter.kopecksToRubles(userInfo.balance()));
        return true;
    }
}
