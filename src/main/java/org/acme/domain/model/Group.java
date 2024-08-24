package org.acme.domain.model;

import org.bson.types.ObjectId;

import java.util.List;

public record Group(
        ObjectId id,
        String groupName,
        String description,
        List<UserAccount> members,
        List<Post> posts
) {
}
