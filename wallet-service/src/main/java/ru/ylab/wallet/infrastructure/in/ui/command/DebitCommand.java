package ru.ylab.wallet.infrastructure.in.ui.command;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.application.WalletFacade;
import ru.ylab.wallet.application.dto.AddTransactionRequest;
import ru.ylab.wallet.application.exception.NotEnoughMoneyException;
import ru.ylab.wallet.domain.exception.TransactionIdNotUniqueException;
import ru.ylab.wallet.infrastructure.in.ui.Command;
import ru.ylab.wallet.infrastructure.in.ui.Input;
import ru.ylab.wallet.common.RubleConverter;

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
        UUID transactionId = UUID.randomUUID();
        try {
            long amount = RubleConverter.rublesToKopecks(in.askString("Введите сумму операции "));
            walletFacade.createDebitTransaction(new AddTransactionRequest(token, transactionId, amount));
            if (amount <= 0) {
                out.print("Сумма операции должна быть больше 0");
                return true;
            }
        } catch (NumberFormatException e) {
            out.print("==Неверный формат. Разделитель дроби точка==");
        } catch (TransactionIdNotUniqueException | NotEnoughMoneyException exception) {
            out.println(exception.getMessage());
        }
        return true;
    }
}
