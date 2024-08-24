package org.acme.adapter.driven.mongodb.repositories;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.adapter.driven.mongodb.entities.UserAccountEntity;
import org.bson.types.ObjectId;

@ApplicationScoped
public class UserAccountRepository implements PanacheMongoRepository<UserAccountEntity> {
}
