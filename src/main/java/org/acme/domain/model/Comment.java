package org.acme.domain.model;

import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public record Comment(
        ObjectId id,
        String content,
        LocalDateTime creationDate,
        UserAccount author,
        Post post
) {
}
