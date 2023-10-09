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
public class TransactionHistoryCommand implements Command {
    private final PrintStream out = System.out;
    private final Input in;
    private final WalletFacade walletFacade;

    @Override
    public String name() {
        return "История операций";
    }

    @Override
    public boolean execute(UUID token) {
        if (token == null) {
            return false;
        }
        out.println("=== История ===");
        List<TransactionResponse> transactions = walletFacade.transactionHistory(token);
        if (transactions.isEmpty()) {
            out.println("История пуста!");
            return true;
        }
        transactions.sort(Comparator.comparing(TransactionResponse::transactionDate));
        out.println("Номер\t\tСумма");
        int i = 1;
        for (TransactionResponse transaction : transactions) {
            out.printf(Locale.US, "%-6d\t\t%.2f%n", i, transaction.amount() / 100.0);
            i++;
        }
        return true;
    }
}
