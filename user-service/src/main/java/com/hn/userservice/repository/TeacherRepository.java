package com.hn.userservice.repository;

import com.hn.userservice.model.Teacher;
import com.hn.userservice.model.User;
import com.hn.userservice.repository.generic.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
