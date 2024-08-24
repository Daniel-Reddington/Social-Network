package org.acme.domain.dto;

import org.acme.domain.enums.Gender;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserAccountRequest(
        String username,
        String email,
        String password,
        String confirmPassword,
        String profilePicture,
        String bio,
        LocalDate dateOfBirth,
        Gender gender
) {
}
