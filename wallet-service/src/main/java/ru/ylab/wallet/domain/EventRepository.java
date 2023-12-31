package ru.ylab.wallet.domain;

import ru.ylab.wallet.domain.model.Event;

import java.util.List;

/**
 * Интерфейс для репозитория событий.
 * Этот интерфейс определяет методы для создания
 * событий и получения списка всех событий.
 * По канонам луковичной модели должен находится в ядре (домене).
 */

public interface EventRepository {
    /**
     * Сохраняет его в репозитории событий.
     *
     * @param event Объект события для создания.
     * @return Созданное событие, включая уникальный идентификатор, присвоенный репозиторием.
     */
    Event createEvent(Event event);

    /**
     * Возвращает список всех событий, доступных в репозитории.
     *
     * @return Список всех событий.
     */
    List<Event> findAll();
}
