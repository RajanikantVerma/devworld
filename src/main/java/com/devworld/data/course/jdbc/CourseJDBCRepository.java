package com.devworld.data.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.devworld.data.course.Course;

@Component
public class CourseJDBCRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String INSERT_QUERY_1 = 
			"""
			insert into course (id,name,author)
			values (100,'JPA Start','devworld');
			""";
	private static String DELETE_QUERY = 
			"""
			DELETE FROM course 
			WHERE ID = ?;
			""";
	private static String INSERT_QUERY = 
			"""
			insert into course (id,name,author)
			values (?,?,?);
			""";
	
	private static String SELECT_QUERY = 
			"""
			select * from course 
			where id = ? ;
			""";
			
			
	public void insert() {
		jdbcTemplate.execute(INSERT_QUERY_1);
	}
	
	public void insert(Course course) {
		jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(int id) {
		jdbcTemplate.update(DELETE_QUERY, id);
	}

	public Course selectById(int id) {
		return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
	
}
