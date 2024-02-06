package com.devworld.data.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.devworld.data.course.jdbc.CourseJDBCRepository;
import com.devworld.data.course.jpa.CourseJPARepository;
import com.devworld.data.course.springdatajpa.CourseSpringDataJPARepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private CourseJDBCRepository courseJDBCRepository;
	
	@Autowired
	private CourseJPARepository courseJPARepository;
	
	@Autowired
	private CourseSpringDataJPARepository courseSpringDataJPARepository;

	@Override
	public void run(String... args) throws Exception {
		courseJDBCRepository.insert();
		courseJDBCRepository.insert(new Course(1,"JDBC WORLD", "dev world"));
		courseJDBCRepository.insert(new Course(2,"JDBC WORLD 2", "dev world 2"));
		courseJDBCRepository.insert(new Course(3,"JDBC WORLD 3", "dev world 3"));
		courseJDBCRepository.deleteById(1);
		
		courseJPARepository.insert(new Course(11,"JPA WORLD", "dev world"));
		courseJPARepository.insert(new Course(12,"JPA WORLD 2", "dev world"));
		courseJPARepository.insert(new Course(13,"JPA WORLD 3", "dev world"));
		courseJPARepository.delete(12);
		
		courseSpringDataJPARepository.saveAndFlush(new Course(112,"Spring JPA WORLD", "dev world spring data"));
		courseSpringDataJPARepository.saveAndFlush(new Course(111,"Spring JPA WORLD 2", "dev world"));
		courseSpringDataJPARepository.saveAndFlush(new Course(113,"Spring JPA WORLD 3", "dev world"));
		System.out.println(courseSpringDataJPARepository.findByAuthor("dev world spring data"));
		System.out.println(courseSpringDataJPARepository.findByName("Spring JPA WORLD 3"));
		System.out.println(courseSpringDataJPARepository.findById(111));

		System.out.println("findByNameAndAuthor : " + courseSpringDataJPARepository.findByNameAndAuthor("Spring JPA WORLD 3","dev world"));
		courseSpringDataJPARepository.deleteById(112);





		
		System.out.println(courseJDBCRepository.selectById(2));
		System.out.println(courseJDBCRepository.selectById(3));
		System.out.println(courseJPARepository.findById(11));
		System.out.println(courseJPARepository.findById(13));
	}
}
