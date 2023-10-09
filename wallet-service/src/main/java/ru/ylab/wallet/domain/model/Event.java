package ru.ylab.wallet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {
        private UUID id;
        private EventType type;
        private UUID userId;
        private String userLogin;
        private OffsetDateTime eventDate;
        private String description;
}
