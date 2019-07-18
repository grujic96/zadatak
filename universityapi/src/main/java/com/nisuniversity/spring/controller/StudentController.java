package com.nisuniversity.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nisuniversity.spring.entity.CollegeEntity;
import com.nisuniversity.spring.entity.StudentEntity;
import com.nisuniversity.spring.service.StudentService;

@CrossOrigin("*")
@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//get all students
	@GetMapping("/api/students")
	public ResponseEntity<List<StudentEntity>> list(){
		List<StudentEntity> list = studentService.list();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/api/student/{id}/colleges")
	public ResponseEntity<ArrayList<CollegeEntity>> getCollegesByStudentId(@PathVariable("id") long id){
		ArrayList<CollegeEntity> list = studentService.getCollegesByStudentId(id);
		return ResponseEntity.ok().body(list);
	}
	
	//saving student
	@PostMapping("/api/student")
	public ResponseEntity<?> saveStudent(@RequestBody StudentEntity student){
		System.out.println(student.getBirthDate());
		long id = studentService.saveStudent(student);
		return ResponseEntity.ok().body("Student created with id: " + id);
	}
	
	@GetMapping("/api/student/{id}")
	public ResponseEntity<StudentEntity> getStudent(@PathVariable("id") long id){
		StudentEntity student = studentService.getStudent(id);
		return ResponseEntity.ok().body(student);
	}
	
	@PutMapping("/api/student/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable("id") long id, @RequestBody StudentEntity student){
		studentService.updateStudent(id, student);
		return ResponseEntity.ok().body("Student has been updated");
	}
	
	@DeleteMapping("/api/student/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") long id){
		studentService.deleteStudent(id);
		return ResponseEntity.ok().body("Student has been deleted");
	}
	
	//returns student with given jmbg
	@GetMapping("/api/student/jmbg/{jmbg}")
	public ResponseEntity<StudentEntity> getStudentByJmbg(@PathVariable("jmbg") String jmbg){
		StudentEntity student = studentService.getStudentByJmbg(jmbg);
		return ResponseEntity.ok().body(student);
	}
	
}