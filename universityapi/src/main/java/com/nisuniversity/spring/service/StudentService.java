package com.nisuniversity.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.nisuniversity.spring.entity.CollegeEntity;
import com.nisuniversity.spring.entity.StudentEntity;

public interface StudentService {
	
	long saveStudent(StudentEntity student);
	
	StudentEntity getStudent(long id);
	
	
	@Secured ({"ROLE_ADMIN"})
	List<StudentEntity> list();
	
	void updateStudent(long id, StudentEntity student);
	
	void deleteStudent(long id);
	
	@Secured ({"ROLE_ADMIN"})
	ArrayList<CollegeEntity> getCollegesByStudentId(long id);
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	StudentEntity getStudentByJmbg(String jmbg);
	
}
