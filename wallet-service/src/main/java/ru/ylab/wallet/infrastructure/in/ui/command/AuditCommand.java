package ru.ylab.wallet.infrastructure.in.ui.command;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.application.WalletFacade;
import ru.ylab.wallet.application.dto.EventResponse;
import ru.ylab.wallet.infrastructure.in.ui.Command;
import ru.ylab.wallet.infrastructure.in.ui.Input;

import java.io.PrintStream;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class AuditCommand implements Command {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
    private final PrintStream out = System.out;
    private final Input in;
    private final WalletFacade walletFacade;

    @Override
    public String name() {
        return "Аудит";
    }

    @Override
    public boolean execute(UUID token) {
        out.println("=== Аудит ===");
        out.println("Тестовый пароль ad");
        String password = in.askString("Введите пароль администратора: ");
        if (!"ad".equals(password)) {
            out.println("=Неверный пароль=");
            out.println("Тестовый пароль ad");
            return true;
        }
        List<EventResponse> events = walletFacade.getAllEvents();
        if (events.isEmpty()) {
            out.println("Список событий пуст!");
            return true;
        }
        events.sort(Comparator.comparing(EventResponse::userLogin).thenComparing(EventResponse::eventDate));
        int i = 1;
        for (EventResponse event : events) {
            out.printf("%-5s\t%-20s\t%-10s\t%s%n",
                    i, event.userLogin(), event.eventDate().format(formatter), event.description());
            i++;
        }
        return true;
    }
}
