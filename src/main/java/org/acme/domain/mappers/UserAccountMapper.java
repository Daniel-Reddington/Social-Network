package org.acme.domain.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.domain.dto.UserAccountRequest;
import org.acme.domain.dto.UserAccountResponse;
import org.acme.domain.model.UserAccount;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserAccountMapper {

    void updateUserAccountFromRequest(UserAccountRequest userAccountRequest, @MappingTarget UserAccount userAccount);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "isActive", ignore = true),
    })
    UserAccount requestToUserAccount(UserAccountRequest userAccountRequest);

    List<UserAccountResponse> userAccountsToUserAccountResponses(List<UserAccount> userAccounts);

    UserAccountResponse userAccountToResponse(UserAccount userAccount);
}
