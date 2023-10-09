package ru.ylab.wallet.application.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record EventResponse(
        String userLogin,
        OffsetDateTime eventDate,
        String description
) {
}
