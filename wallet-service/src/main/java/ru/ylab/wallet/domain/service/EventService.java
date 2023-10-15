package ru.ylab.wallet.domain.service;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.domain.EventRepository;
import ru.ylab.wallet.domain.exception.InvalidIdException;
import ru.ylab.wallet.domain.model.Event;

import java.util.List;

/**
 * Сервис для работы с событиями представляет собой внутреннюю бизнес-логику луковичной модели.
 * Этот сервис обеспечивает функциональность для создания событий и получения списка всех событий.
 */

@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public Event createEvent(Event event) {
        if (event.getId() == null) {
            throw  new InvalidIdException();
        }
        return eventRepository.createEvent(event);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }
}
