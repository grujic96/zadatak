package com.nisuniversity.spring.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nisuniversity.spring.entity.CollegeEntity;
import com.nisuniversity.spring.entity.StudentEntity;

@Repository
public class CollegeDAOImpl implements CollegeDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public List<CollegeEntity> getAllCollegesList() {
		List<CollegeEntity> list =  sessionFactory.getCurrentSession().createQuery("FROM CollegeEntity").list();
		return list;
	}


	@Override
	public CollegeEntity getById(long id) {
		return sessionFactory.getCurrentSession().get(CollegeEntity.class, id);
	}


	@Override
	public Collection<StudentEntity> getStudentsByCollegeId(long id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select distinct student from StudentEntity student " +
                "join student.colleges college " +
                "where college.id = " + id;
		Query<StudentEntity> query = session.createQuery(hql);
		Collection<StudentEntity> students = query.list();
		return students;
    }

	@Override
	public Collection<StudentEntity> getStudentsOfMultipleColleges() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select distinct student from StudentEntity student " +
			    "join student.colleges college " +
			    "where student.colleges.size > 1";
		Query<StudentEntity> query = session.createQuery(hql);
		Collection<StudentEntity> students = query.list();
		return students;
    }

}
