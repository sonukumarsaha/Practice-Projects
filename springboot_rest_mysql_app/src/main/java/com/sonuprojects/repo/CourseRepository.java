package com.sonuprojects.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonuprojects.binding.Course;

public interface CourseRepository extends JpaRepository<Course, Serializable> {

}
