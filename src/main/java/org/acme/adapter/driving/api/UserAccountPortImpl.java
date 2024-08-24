package org.acme.adapter.driving.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.adapter.driven.mongodb.entities.UserAccountEntity;
import org.acme.adapter.driven.mongodb.repositories.UserAccountRepository;
import org.acme.adapter.mappers.UserAccountMapper;
import org.acme.application.port.driven.UserAccountPort;
import org.acme.domain.model.UserAccount;
import org.bson.types.ObjectId;

import java.util.List;

@ApplicationScoped
public class UserAccountPortImpl implements UserAccountPort {

    @Inject
    UserAccountRepository userAccountRepository;
    @Inject
    UserAccountMapper userAccountMapper;

    @Override
    public UserAccount save(UserAccount userAccount) {

        UserAccountEntity userAccountEntity = userAccountMapper.userAccountToEntity(userAccount);
        userAccountRepository.persist(userAccountEntity);
        System.out.println(userAccount);
        return userAccountMapper.entityToUserAccount(userAccountEntity);

    }

    @Override
    public UserAccount update(UserAccount userAccount) {

        UserAccountEntity userAccountEntity = userAccountMapper.userAccountToEntity(userAccount);
        userAccountRepository.update(userAccountEntity);
        return userAccountMapper.entityToUserAccount(userAccountEntity);

    }

    @Override
    public UserAccount findByUserId(ObjectId userId) {

        UserAccountEntity accountEntity = userAccountRepository.findById(userId);
        return userAccountMapper.entityToUserAccount(accountEntity);

    }

    @Override
    public List<UserAccount> findAll() {

        List<UserAccountEntity> userAccountEntities = userAccountRepository.findAll().stream().toList();
        return userAccountMapper.entitiesToUserAccounts(userAccountEntities);

    }

    @Override
    public UserAccount findByEmail(String email) {

        UserAccountEntity userAccountEntity = userAccountRepository.find("email", email).firstResult();
        return userAccountMapper.entityToUserAccount(userAccountEntity);

    }

    @Override
    public UserAccount findByUsername(String username) {
        return null;
    }

    @Override
    public boolean delete(ObjectId userId) {
        return userAccountRepository.deleteById(userId);
    }
}
