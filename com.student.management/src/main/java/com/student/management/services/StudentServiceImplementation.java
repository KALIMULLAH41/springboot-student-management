package com.student.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.student.management.entities.Student;
import com.student.management.repositories.StudentRepository;

@Service
public class StudentServiceImplementation
              implements StudentService {

	@Autowired
	StudentRepository repo;
	
	public String addStudnet(Student st) {
		repo.save(st);
		return "student added";
	}
	
	public Student searchStudent(int roll) {
	return repo.findById(roll).get();
	
	}

	public String  updateStudent(Student st) {
		repo.save(st);
		return "student update";
	}
	
	public String deleteStudent(int roll) {
		repo.deleteById(roll);
		return "student deleted";
		
	}

	
	public List<Student> fetchAllStudents() {
		
		return repo.findAll();
	}
	
	
	
    public String deleteAllStudents() {		
		 repo.deleteAll();
		   return "All students deleted!";
	}
	
	
}
