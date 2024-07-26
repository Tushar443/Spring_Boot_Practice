package com.example.demo.DAOImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.DAO.StudentDAO;
import com.example.demo.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImple implements StudentDAO {
	
	private EntityManager entityM;
	
	@Autowired
	public StudentDAOImple(EntityManager entityM) {
		this.entityM=entityM;
	}


	@Override
	@Transactional
	public void save(Student student) {
		entityM.persist(student);
	}


	@Override
	public Student findById(Integer id) {		
		return entityM.find(Student.class, id);
	}


	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = entityM.createQuery("FROM Student "
				+ "order by firstName",Student.class);
		return theQuery.getResultList();
	}


	@Override
	public List<Student> findAllByLastName(String lastName) {
		TypedQuery<Student> theQuery = entityM.createQuery("FROM Student "
				+ "where lastName=:theLastName",Student.class);
		theQuery.setParameter("theLastName", lastName);
		return theQuery.getResultList();
	}


	@Override
	@Transactional
	public void updateStudent(Student student) {
		entityM.merge(student);
	}


	@Override
	@Transactional
	public void deleteStudent(int id) {
		Student student = entityM.find(Student.class, id);
		
		entityM.remove(student);
	}


	@Override
	@Transactional
	public int deleteAll() {
		int records = entityM.createQuery("DELETE FROM Student",Student.class).executeUpdate();
		return records;
	}

	
}
