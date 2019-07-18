package com.nisuniversity.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.nisuniversity.spring.entity.CollegeEntity;
import com.nisuniversity.spring.entity.StudentEntity;

public interface CollegeService {

	Collection<CollegeEntity> getAllCollegesList();

	CollegeEntity getById(long id);

	Collection<StudentEntity> getStudentsByCollegeId(long id);
	
	Collection<StudentEntity> sortStudentsByNameLastname(ArrayList<StudentEntity> students);
	
	Collection<StudentEntity> getStudentsOfMultipleColleges();

}
