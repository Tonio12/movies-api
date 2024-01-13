package com.tonilearnsjava.movies.repositories;

import com.tonilearnsjava.movies.models.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users, ObjectId> {
    Users findByUserName(String name);
}
