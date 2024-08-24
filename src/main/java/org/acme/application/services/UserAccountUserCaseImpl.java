package org.acme.application.services;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.application.port.driven.UserAccountPort;
import org.acme.application.port.driving.UserAccountUseCase;
import org.acme.domain.dto.UserAccountRequest;
import org.acme.domain.dto.UserAccountResponse;
import org.acme.domain.mappers.UserAccountMapper;
import org.acme.domain.model.UserAccount;
import org.acme.infrastructure.exceptions.ConfirmPasswordNotCorrespond;
import org.bson.types.ObjectId;

import java.util.List;

@ApplicationScoped
public class UserAccountUserCaseImpl implements UserAccountUseCase {

    @Inject
    UserAccountPort userAccountPort;
    @Inject
    UserAccountMapper userAccountMapper;

    @Override
    public UserAccount createAccount(UserAccountRequest userAccountRequest) {

        if(!userAccountRequest.password().equals(userAccountRequest.confirmPassword())){
            throw new ConfirmPasswordNotCorrespond("password and the confirm password doesn't correspond");
        }

        UserAccount userAccount = userAccountMapper.requestToUserAccount(userAccountRequest);
        return userAccountPort.save(userAccount);

    }

    @Override
    public UserAccount updateAccount(ObjectId userId, UserAccountRequest userAccountRequest) {

        UserAccount userAccount = userAccountPort.findByUserId(userId);
        userAccountMapper.updateUserAccountFromRequest(userAccountRequest, userAccount);
        return userAccountPort.update(userAccount);

    }

    @Override
    public List<UserAccountResponse> findAll() {
        List<UserAccount> userAccounts = userAccountPort.findAll();
        return userAccountMapper.userAccountsToUserAccountResponses(userAccounts);
    }

    @Override
    public UserAccountResponse findByEmail(String email) {
        UserAccount userAccount = userAccountPort.findByEmail(email);
        return userAccountMapper.userAccountToResponse(userAccount);
    }

    @Override
    public UserAccountResponse findByUsername(String username) {
        UserAccount userAccount = userAccountPort.findByUsername(username);
        return userAccountMapper.userAccountToResponse(userAccount);
    }

    @Override
    public boolean delete(ObjectId userId) {
        return userAccountPort.delete(userId);
    }
}
