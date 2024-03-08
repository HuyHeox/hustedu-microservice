package com.hn.userservice.repository;

import com.hn.userservice.model.Student;
import com.hn.userservice.repository.generic.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
