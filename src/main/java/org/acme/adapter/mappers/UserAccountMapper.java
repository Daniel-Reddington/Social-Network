package org.acme.adapter.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.adapter.driven.mongodb.entities.UserAccountEntity;
import org.acme.domain.model.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserAccountMapper {

    UserAccountEntity userAccountToEntity(UserAccount userAccount);

    UserAccount entityToUserAccount(UserAccountEntity userAccountEntity);

    List<UserAccount> entitiesToUserAccounts(List<UserAccountEntity> userAccountEntities);
}
