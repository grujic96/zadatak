package com.nisuniversity.spring.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisuniversity.spring.dao.CollegeDAO;
import com.nisuniversity.spring.entity.CollegeEntity;
import com.nisuniversity.spring.entity.StudentEntity;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeDAO collegeDAO;
	
	
	@Override
	@Transactional
	public Collection<CollegeEntity> getAllCollegesList() {
		ArrayList<CollegeEntity> colleges = (ArrayList<CollegeEntity>) collegeDAO.getAllCollegesList();
		return sortCollegesByName(colleges);
	}


	@Override
	@Transactional
	public CollegeEntity getById(long id) {
		return collegeDAO.getById(id);
	}


	@Override
	@Transactional
	public Collection<StudentEntity> getStudentsByCollegeId(long id) {
		ArrayList<StudentEntity> students = (ArrayList<StudentEntity>) collegeDAO.getStudentsByCollegeId(id);
		return sortStudentsByNameLastname(students);
	}
	
	@Override
	@Transactional
	public Collection<StudentEntity> getStudentsOfMultipleColleges() {
		return collegeDAO.getStudentsOfMultipleColleges();
	}
	
	public Collection<StudentEntity> sortStudentsByNameLastname(ArrayList<StudentEntity> students){
		int n = students.size();  
		StudentEntity tempStudent = null;  
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
		    	if(students.get(j-1).getName().compareTo(students.get(j).getName()) > 0){  
			    	//swap elements  
			    	tempStudent = students.get(j-1);  
			    	students.set((j-1), students.get(j));
			    	students.set(j, tempStudent);
		    	} else if (students.get(j-1).getName().compareTo(students.get(j).getName()) == 0) {
	            	if(students.get(j-1).getLastname().compareTo(students.get(j).getLastname()) > 0) {
	                	tempStudent = students.get(j-1);  
	                	students.set((j-1), students.get(j));
	                	students.set(j, tempStudent);
	            	}
		        }  
			}  
		}  
		return students;
	}
	
	public Collection<CollegeEntity> sortCollegesByName(ArrayList<CollegeEntity> colleges){
        int n = colleges.size();  
        CollegeEntity tempCollege = null;  
        for(int i=0; i < n; i++){  
	        for(int j=1; j < (n-i); j++){  
	        	if(colleges.get(j-1).getName().compareTo(colleges.get(j).getName()) > 0){  
		        	//swap elements  
	        		tempCollege = colleges.get(j-1);  
		        	colleges.set((j-1), colleges.get(j));
		        	colleges.set(j, tempCollege);
                }  
	        }  
        }
        return colleges;
	}
}
	

