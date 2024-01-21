package com.SpringRestApiImpl.SpringRestApiImpl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRestApiImpl.SpringRestApiImpl.Entity.Courses;
import com.SpringRestApiImpl.SpringRestApiImpl.services.CoursesService;

@RestController
public class MyController {
	@Autowired
	private CoursesService courseService;
	
	//GET Courses 
	@GetMapping("/courses")
	public List<Courses>getCourses(){
		return this.courseService.getCourses();
	}
	
	//Get courses by id 
	@GetMapping("/courses/{courseId}")
	public Courses getCourses(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	//Add new Courses
	@PostMapping(path = "/courses", consumes = "application/json")
	public  Courses addCourses(@RequestBody Courses course){
		return this.courseService.addCourse(course);
	}
	
	//Update existing Courses
	@PutMapping(path = "/courses")
	public Courses updateCourses(@RequestBody Courses courses) {
		return this.courseService.updateCourse(courses);
	}
	
	@DeleteMapping(path="/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCouses(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
}
