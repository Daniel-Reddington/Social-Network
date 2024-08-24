package org.acme.domain.model;

import org.acme.domain.enums.ReactionType;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public record Reaction(
        ObjectId id,
        ReactionType reactionType,
        UserAccount userAccount,
        Post post,
        LocalDateTime createdAt
) {
}
