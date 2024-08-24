package org.acme.application.port.driven;

import org.acme.domain.model.UserAccount;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserAccountPort {
    UserAccount save(UserAccount userAccount);
    UserAccount update(UserAccount userAccount);
    UserAccount findByUserId(ObjectId userId);
    List<UserAccount> findAll();
    UserAccount findByEmail(String email);
    UserAccount findByUsername(String username);
    boolean delete(ObjectId userId);
}
