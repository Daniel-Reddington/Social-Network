package org.acme.domain.dto;

import org.acme.domain.enums.Gender;
import org.bson.types.ObjectId;

import java.time.LocalDate;

public record UserAccountResponse(
        ObjectId id,
        String username,
        String email,
        String profilePicture,
        String bio,
        LocalDate dateOfBirth,
        Gender gender
) {
}
