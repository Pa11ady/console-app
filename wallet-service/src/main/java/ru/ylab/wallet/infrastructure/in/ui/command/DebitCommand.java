package ru.ylab.wallet.infrastructure.in.ui.command;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.application.WalletFacade;
import ru.ylab.wallet.application.dto.AddTransactionRequest;
import ru.ylab.wallet.infrastructure.in.ui.Command;
import ru.ylab.wallet.infrastructure.in.ui.Input;
import ru.ylab.wallet.infrastructure.in.ui.RubleConverter;

import java.io.PrintStream;
import java.util.UUID;

@RequiredArgsConstructor
public class DebitCommand implements Command {
    private final PrintStream out = System.out;
    private final Input in;
    private final WalletFacade walletFacade;

    @Override
    public String name() {
        return "Снятие средств";
    }

    @Override
    public boolean execute(UUID token) {
        if (token == null) {
            return false;
        }
        out.println("=== Снятие (дебит) ===");
        AddTransactionRequest request;
        UUID transactionId = UUID.randomUUID();
        long amount = RubleConverter.rublesToKopecks(in.askString("Введите сумму операции ##.##"));

        walletFacade.createDebitTransaction(new AddTransactionRequest(token, transactionId, amount));
        //todo обраб исключения
        return true;
    }
}
