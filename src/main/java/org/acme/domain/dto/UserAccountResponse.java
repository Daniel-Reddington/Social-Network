package org.acme.domain.dto;

import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public record UserAccountResponse(
        ObjectId id,
        String email,
        String username,
        String phoneNumber,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Boolean isActive
) {
}
