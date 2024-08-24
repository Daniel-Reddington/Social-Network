package org.acme.domain.model;

import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public record Post(
        ObjectId id,
        String content,
        String mediaUrl,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        UserAccount author
) {
}
