package com.devworld.data.course.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devworld.data.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class CourseJPARepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void insert(Course course) {
		entityManager.merge(course);
	}

	public Course findById(int id) {
		return entityManager.find(Course.class, id);
	}
	
	public void delete(int id) {
		Course course = findById(id);
		if(course!=null)
		entityManager.remove(course);
	}
}
