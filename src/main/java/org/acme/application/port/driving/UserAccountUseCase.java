package org.acme.application.port.driving;

import org.acme.domain.dto.UserAccountRequest;
import org.acme.domain.dto.UserAccountResponse;
import org.acme.domain.model.UserAccount;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserAccountUseCase {
    UserAccount createAccount(UserAccountRequest userAccountRequest);
    UserAccount updateAccount(ObjectId userId, UserAccountRequest userAccountRequest);
    List<UserAccountResponse> findAll();
    UserAccountResponse findByEmail(String email);
    UserAccountResponse findByUsername(String username);
    boolean delete(ObjectId userId);
}
