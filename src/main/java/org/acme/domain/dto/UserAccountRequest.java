package org.acme.domain.dto;

import java.time.LocalDateTime;

public record UserAccountRequest(
        String email,
        String username,
        String password,
        String confirmPassword,
        String phoneNumber,
        LocalDateTime updatedAt
) {
}
