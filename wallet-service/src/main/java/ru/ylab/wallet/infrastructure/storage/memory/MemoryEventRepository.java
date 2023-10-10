package ru.ylab.wallet.infrastructure.storage.memory;

import ru.ylab.wallet.domain.EventRepository;
import ru.ylab.wallet.domain.model.Event;

import java.util.*;

public class MemoryEventRepository implements EventRepository {
   private final Map<UUID, Event> eventMap = new HashMap<>();

    @Override
    public Event createEvent(Event event) {
        Event copy = new Event(
                event.getId(),
                event.getType(),
                event.getUserId(),
                event.getUserLogin(),
                event.getEventDate(),
                event.getDescription()
        );
        eventMap.put(event.getId(), copy);
        return event;
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(eventMap.values());
    }
}
