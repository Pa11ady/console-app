package ru.ylab.wallet;

import ru.ylab.wallet.application.WalletFacade;
import ru.ylab.wallet.infrastructure.in.ui.Command;
import ru.ylab.wallet.infrastructure.in.ui.ConsoleInput;
import ru.ylab.wallet.infrastructure.in.ui.CommandProcessor;
import ru.ylab.wallet.infrastructure.in.ui.Input;
import ru.ylab.wallet.infrastructure.in.ui.command.ExitCommand;
import ru.ylab.wallet.infrastructure.in.ui.command.LoginCommand;
import ru.ylab.wallet.infrastructure.in.ui.command.RegistrationCommand;
import ru.ylab.wallet.infrastructure.in.ui.command.UserInfoCommand;

import java.util.List;

public class WalletApplication {
    public static void main(String[] args) {
        Input in = new ConsoleInput();
        WalletFacade walletFacade = new WalletFacade();
        List<Command> subCommands = List.of(
                new UserInfoCommand(walletFacade),
                new ExitCommand("==== Выход из профиля")
        );
        CommandProcessor subCommandProcessor = new CommandProcessor(in, subCommands);
        List<Command> commands = List.of(
                new RegistrationCommand(in, walletFacade),
                new LoginCommand(in, walletFacade, subCommandProcessor),
                new ExitCommand("Завершить работу")
        );
        new CommandProcessor(in, commands).start();
        in.close();
    }
}
