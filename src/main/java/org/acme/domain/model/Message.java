package org.acme.domain.model;

import org.acme.domain.enums.MessageStatus;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public record Message(
        ObjectId id,
        String content,
        UserAccount sender,
        UserAccount receiver,
        LocalDateTime sentAt,
        MessageStatus messageStatus
) {
}
