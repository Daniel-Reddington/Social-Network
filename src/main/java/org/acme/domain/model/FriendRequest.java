package org.acme.domain.model;

import org.acme.domain.enums.FriendRequestStatus;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public record FriendRequest(
        ObjectId id,
        UserAccount sender,
        UserAccount receiver,
        FriendRequestStatus status,
        LocalDateTime sentAt
) {
}
