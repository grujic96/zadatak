package com.nisuniversity.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisuniversity.spring.dao.StudentDAO;
import com.nisuniversity.spring.entity.CollegeEntity;
import com.nisuniversity.spring.entity.StudentEntity;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO studentDAO;
	
	
	@Override
	@Transactional
	public long saveStudent(StudentEntity student) {
		return studentDAO.saveStudent(student);
	}

	@Override
	@Transactional
	public StudentEntity getStudent(long id) {
		return studentDAO.getStudent(id);
	}

	@Override
	@Transactional
	public List<StudentEntity> list() {
		return studentDAO.list();
	}

	@Override
	@Transactional
	public void updateStudent(long id, StudentEntity student) {
		studentDAO.updateStudent(id, student);
	}

	@Override
	@Transactional
	public void deleteStudent(long id) {
		studentDAO.deleteStudent(id);
	}

	@Override
	@Transactional
	public ArrayList<CollegeEntity> getCollegesByStudentId(long id) {
		return studentDAO.getCollegesByStudentId(id);
	}

	@Override
	@Transactional
	public StudentEntity getStudentByJmbg(String jmbg) {
		return studentDAO.getStudentByJmbg(jmbg);
	}

}
