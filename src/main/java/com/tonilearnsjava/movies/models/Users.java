package com.tonilearnsjava.movies.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "users")
@Data
public class Users {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    @CreatedDate
    private LocalDate createdDate;
}
