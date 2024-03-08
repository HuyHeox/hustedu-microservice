package com.hn.userservice.repository.impl;

import com.hn.userservice.model.Student;
import com.hn.userservice.model.User;
import com.hn.userservice.repository.StudentRepository;
import com.hn.userservice.repository.UserRepository;
import com.hn.userservice.repository.generic.AbstractRepositoryImpl;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl extends AbstractRepositoryImpl<Student, Long> implements StudentRepository {
    public StudentRepositoryImpl(MongoDatabase db) {
        super(db, "Student", Student.class, Long.class);
    }
}
