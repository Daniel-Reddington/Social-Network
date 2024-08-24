package org.acme.domain.model;

import org.bson.types.ObjectId;

import java.util.List;

public record Page(
        ObjectId id,
        String pageName,
        String description,
        UserAccount owner,
        List<Post> posts
) {
}
