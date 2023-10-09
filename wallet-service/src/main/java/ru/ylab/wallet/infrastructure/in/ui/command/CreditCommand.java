package ru.ylab.wallet.infrastructure.in.ui.command;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.application.WalletFacade;
import ru.ylab.wallet.application.dto.AddTransactionRequest;
import ru.ylab.wallet.application.exception.TransactionIdNotUniqueException;
import ru.ylab.wallet.infrastructure.in.ui.Command;
import ru.ylab.wallet.infrastructure.in.ui.Input;
import ru.ylab.wallet.infrastructure.in.ui.RubleConverter;

import java.io.PrintStream;
import java.util.UUID;

@RequiredArgsConstructor
public class CreditCommand implements Command {
    private final PrintStream out = System.out;
    private final Input in;
    private final WalletFacade walletFacade;

    @Override
    public String name() {
        return "Пополнение средств";
    }

    @Override
    public boolean execute(UUID token) {
        if (token == null) {
            return false;
        }
        out.println("=== Пополнение (кредит) ===");
        UUID transactionId = UUID.randomUUID();
        try {
            long amount = RubleConverter.rublesToKopecks(in.askString("Введите сумму операции "));
            walletFacade.createCreditTransaction(new AddTransactionRequest(token, transactionId, amount));
        } catch (NumberFormatException e) {
            out.print("==Неверный формат. Разделитель дроби точка==");
        } catch (TransactionIdNotUniqueException exception) {
            out.println(exception.getMessage());
        }
        return true;
    }
}
