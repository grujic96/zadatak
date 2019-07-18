package com.nisuniversity.spring.dao;

import java.util.Collection;
import java.util.List;

import com.nisuniversity.spring.entity.CollegeEntity;
import com.nisuniversity.spring.entity.StudentEntity;

public interface CollegeDAO {

	List<CollegeEntity> getAllCollegesList();

	CollegeEntity getById(long id);

	Collection<StudentEntity> getStudentsByCollegeId(long id);
	
	Collection<StudentEntity> getStudentsOfMultipleColleges();


}
