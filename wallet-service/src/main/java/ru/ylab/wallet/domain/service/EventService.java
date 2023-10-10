package ru.ylab.wallet.domain.service;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.domain.EventRepository;
import ru.ylab.wallet.domain.model.Event;

import java.util.List;

@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.createEvent(event);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }
}
