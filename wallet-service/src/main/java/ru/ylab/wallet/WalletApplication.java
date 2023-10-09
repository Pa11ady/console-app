package ru.ylab.wallet;

import ru.ylab.wallet.application.WalletFacade;
import ru.ylab.wallet.domain.service.EventService;
import ru.ylab.wallet.domain.service.TransactionService;
import ru.ylab.wallet.domain.service.UserService;
import ru.ylab.wallet.infrastructure.in.ui.Command;
import ru.ylab.wallet.infrastructure.in.ui.ConsoleInput;
import ru.ylab.wallet.infrastructure.in.ui.CommandProcessor;
import ru.ylab.wallet.infrastructure.in.ui.Input;
import ru.ylab.wallet.infrastructure.in.ui.command.*;

import java.util.List;

public class WalletApplication {
    public static void main(String[] args) {
        Input in = new ConsoleInput();
        UserService userService = new UserService();
        TransactionService transactionService = new TransactionService();
        EventService eventService = new EventService();
        WalletFacade walletFacade = new WalletFacade(userService, transactionService, eventService);
        List<Command> subCommands = List.of(
                new UserInfoCommand(walletFacade),
                new CreditCommand(in, walletFacade),
                new DebitCommand(in, walletFacade),
                new TransactionHistoryCommand(in, walletFacade),
                new ExitCommand("==== Выход из профиля")
        );
        CommandProcessor subCommandProcessor = new CommandProcessor(in, subCommands);
        List<Command> commands = List.of(
                new RegistrationCommand(in, walletFacade),
                new LoginCommand(in, walletFacade, subCommandProcessor),
                new AuditCommand(in, walletFacade),
                new ExitCommand("Завершить работу")
        );
        new CommandProcessor(in, commands).start();
        in.close();
    }
}
