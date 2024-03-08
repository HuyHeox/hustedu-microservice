package com.hn.userservice.repository.impl;

import com.hn.userservice.model.Teacher;
import com.hn.userservice.repository.TeacherRepository;
import com.hn.userservice.repository.generic.AbstractRepositoryImpl;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherRepositoryImpl extends AbstractRepositoryImpl<Teacher, Long> implements TeacherRepository {
    public TeacherRepositoryImpl(MongoDatabase db) {
        super(db, "Teacher", Teacher.class, Long.class);
    }
}
