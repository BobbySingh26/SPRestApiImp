package com.SpringRestApiImpl.SpringRestApiImpl.services;

import java.util.List;

import com.SpringRestApiImpl.SpringRestApiImpl.Entity.Courses;

public interface CoursesService {
	
	public List<Courses> getCourses();
	
	public Courses getCourse(long courseId);
	
	public Courses addCourse(Courses course);
	
	public Courses updateCourse(Courses course);
	
	public void deleteCourse(Long parseLong);
	
}
