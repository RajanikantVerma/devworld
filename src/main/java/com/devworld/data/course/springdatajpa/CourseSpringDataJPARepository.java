package com.devworld.data.course.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devworld.data.course.Course;

public interface CourseSpringDataJPARepository extends JpaRepository<Course, Integer> {
	
	Course findByName(String name);
	
	Course findByAuthor(String author);

	@Query("select c from Course c where c.name = ?1 and c.author = ?2")
	Course findByNameAndAuthor(String name, String author);
}
