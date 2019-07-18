package com.nisuniversity.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.nisuniversity.spring.entity.CollegeEntity;
import com.nisuniversity.spring.entity.StudentEntity;

public interface StudentDAO {
	
	long saveStudent(StudentEntity student);
	
	StudentEntity getStudent(long id);
	
	List<StudentEntity> list();
	
	void updateStudent(long id, StudentEntity student);
	
	void deleteStudent(long id);

	ArrayList<CollegeEntity> getCollegesByStudentId(long id);

	StudentEntity getStudentByJmbg(String jmbg);
	
}
