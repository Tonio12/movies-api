package com.tonilearnsjava.movies.repositories;

import com.tonilearnsjava.movies.models.Reviews;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Reviews, ObjectId> {
}
