package com.nisuniversity.spring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nisuniversity.spring.entity.CollegeEntity;
import com.nisuniversity.spring.entity.StudentEntity;
import com.nisuniversity.spring.service.CollegeService;

@CrossOrigin("*")
@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService;
	
	//List of colleges sorted by name
	@GetMapping("/api/colleges")
	public ResponseEntity<Collection<CollegeEntity>> getAllCollegesList(){
		Collection<CollegeEntity> list = collegeService.getAllCollegesList();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/api/college/{id}")
	public ResponseEntity<CollegeEntity> get(@PathVariable("id") long id){
		CollegeEntity college = collegeService.getById(id);
		return ResponseEntity.ok().body(college);
	}
	
	
	//List of students of a certain college sorted by name and lastname
	@GetMapping("/api/college/{id}/students")
	public ResponseEntity<Collection<StudentEntity>> getCollegesByStudentId(@PathVariable("id") long id){
		Collection<StudentEntity> list = collegeService.getStudentsByCollegeId(id);
		return ResponseEntity.ok().body(list);
	}
	
	//List of students of multiple colleges
	@GetMapping("/api/college/multiplecollegestudents")
	public ResponseEntity<Collection<StudentEntity>> getStudentsOfMultipleColleges(){
		Collection<StudentEntity> list = collegeService.getStudentsOfMultipleColleges();
		System.out.println(list);
		return ResponseEntity.ok().body(list);
	}
	
	
}
