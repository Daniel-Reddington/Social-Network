package org.acme.adapter.driven.mongodb.entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@MongoEntity
public class UserAccountEntity extends PanacheMongoEntity {

    public String email;
    public String username;
    public String password;
    public String phoneNumber;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public Boolean isActive;

}
