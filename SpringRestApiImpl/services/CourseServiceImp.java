package com.SpringRestApiImpl.SpringRestApiImpl.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.SpringRestApiImpl.SpringRestApiImpl.Entity.Courses;

@Service
public class CourseServiceImp implements CoursesService {

	List<Courses> list;
	
	public CourseServiceImp() {
		list = new ArrayList<>();
		list.add(new Courses(1444, "Core Java Courses","This is Contains Basics of java"));
		list.add(new Courses(1412, "Spring Boot Courses","Implementation of REST API Using Spring Boot"));

	}
	
	@Override
	public List<Courses> getCourses() {
		return list;
	}

	@Override
	public Courses getCourse(long courseId) {
		Courses c=null;
		for (Courses course:list) {
			if (course.getId()==courseId) {
				c=course;
				break;
			};
		}
		return c;
	}

	@Override
	public Courses addCourse(Courses course) {
		list.add(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
		list.forEach(e -> {
			if (e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}

	@Override
	public void deleteCourse(Long parseLong) {
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	}
}
