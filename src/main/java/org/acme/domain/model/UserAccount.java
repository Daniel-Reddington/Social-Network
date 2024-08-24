package org.acme.domain.model;

import org.acme.domain.enums.Gender;
import org.bson.types.ObjectId;

import java.time.LocalDate;

public record UserAccount(
        ObjectId id,
        String username,
        String email,
        String password,
        String profilePicture,
        String bio,
        LocalDate dateOfBirth,
        Gender gender
) {
}
