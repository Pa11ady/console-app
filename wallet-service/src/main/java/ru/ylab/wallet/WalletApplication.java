package ru.ylab.wallet;

import ru.ylab.wallet.application.WalletFacade;
import ru.ylab.wallet.domain.EventRepository;
import ru.ylab.wallet.domain.TransactionRepository;
import ru.ylab.wallet.domain.UserRepository;
import ru.ylab.wallet.domain.service.EventService;
import ru.ylab.wallet.domain.service.TransactionService;
import ru.ylab.wallet.domain.service.UserService;
import ru.ylab.wallet.infrastructure.in.ui.Command;
import ru.ylab.wallet.infrastructure.in.ui.CommandProcessor;
import ru.ylab.wallet.infrastructure.in.ui.ConsoleInput;
import ru.ylab.wallet.infrastructure.in.ui.Input;
import ru.ylab.wallet.infrastructure.in.ui.command.*;
import ru.ylab.wallet.infrastructure.storage.memory.MemoryEventRepository;
import ru.ylab.wallet.infrastructure.storage.memory.MemoryTransactionRepository;
import ru.ylab.wallet.infrastructure.storage.memory.MemoryUserRepository;

import java.util.List;

/**
 * Этот класс является основным классом для приложения wallet-service.
 * Он настраивает все компоненты приложения и запускает консоль.
 */

public class WalletApplication {
    public static void main(String[] args) {
        Input in = new ConsoleInput();
        EventRepository eventRepository = new MemoryEventRepository();
        TransactionRepository transactionRepository = new MemoryTransactionRepository();
        UserRepository userRepository = new MemoryUserRepository();

        EventService eventService = new EventService(eventRepository);
        TransactionService transactionService = new TransactionService(transactionRepository);
        UserService userService = new UserService(userRepository);
        WalletFacade walletFacade = new WalletFacade(userService, transactionService, eventService);

        List<Command> subCommands = List.of(
                new UserInfoCommand(walletFacade),
                new CreditCommand(in, walletFacade),
                new DebitCommand(in, walletFacade),
                new TransactionHistoryCommand(walletFacade),
                new LogoutCommand(walletFacade)
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
