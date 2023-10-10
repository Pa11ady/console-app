package ru.ylab.wallet.infrastructure.storage.stub;

import ru.ylab.wallet.domain.EventRepository;
import ru.ylab.wallet.domain.model.Event;
import ru.ylab.wallet.domain.model.EventType;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class StubEventRepository implements EventRepository {
    @Override
    public Event createEvent(Event event) {
        return event;
    }

    @Override
    public List<Event> findAll() {
        Event[] events = {
                new Event(
                        UUID.randomUUID(),
                        EventType.CREDIT,
                        UUID.randomUUID(),
                        "Login1",
                        OffsetDateTime.now(),
                        "кредит 1000"
                ),
                new Event(
                        UUID.randomUUID(),
                        EventType.LOGIN,
                        UUID.randomUUID(),
                        "Login2",
                        OffsetDateTime.now(),
                        "логин"),
        };
        return Arrays.asList(events);
    }
}
