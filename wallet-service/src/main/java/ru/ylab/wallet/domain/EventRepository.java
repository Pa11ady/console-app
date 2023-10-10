package ru.ylab.wallet.domain;

import ru.ylab.wallet.domain.model.Event;

import java.util.List;

public interface EventRepository {
    Event createEvent(Event event);

    List<Event> findAll();
}
