package com.nisuniversity.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nisuniversity.spring.entity.CollegeEntity;
import com.nisuniversity.spring.entity.StudentEntity;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public long saveStudent(StudentEntity student) {
		sessionFactory.getCurrentSession().save(student);
		return student.getId();
		}

	@Override
	public StudentEntity getStudent(long id) {
		return sessionFactory.getCurrentSession().get(StudentEntity.class, id);
		
	}

	@Override
	public List<StudentEntity> list() {
		List<StudentEntity> list =  sessionFactory.getCurrentSession().createQuery("FROM StudentEntity").list();
		return list;
	}

	@Override
	public void updateStudent(long id, StudentEntity student) {
		Session session = sessionFactory.getCurrentSession();
		StudentEntity oldStudent = session.byId(StudentEntity.class).load(id);
		oldStudent.setName(student.getName());
		oldStudent.setLastname(student.getLastname());
		oldStudent.setJmbg(student.getJmbg());
		oldStudent.setAddress(student.getAddress());
		oldStudent.setEmail(student.getEmail());
		oldStudent.setBirthDate(student.getBirthDate());
		oldStudent.setPhoneNumber(student.getPhoneNumber());
		session.flush();
	}

	@Override
	public void deleteStudent(long id) {
		Session session = sessionFactory.getCurrentSession();
		StudentEntity student = session.byId(StudentEntity.class).load(id);
		session.delete(student);
	}

	@Override
	public ArrayList<CollegeEntity> getCollegesByStudentId(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select distinct college from CollegeEntity college " +
                "join college.students student " +
                "where student.id = " + id);  
		
		ArrayList<CollegeEntity> colleges = (ArrayList<CollegeEntity>) query.list();
		return colleges;
	}
	
	@Override
	public StudentEntity getStudentByJmbg(String jmbg) {
		return (StudentEntity) sessionFactory.getCurrentSession().createQuery("select student from StudentEntity student where student.jmbg = " + jmbg).getSingleResult();
	
	}

}
