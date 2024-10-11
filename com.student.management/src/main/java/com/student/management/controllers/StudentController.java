package com.student.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.entities.Student;
import com.student.management.services.StudentService;

//@RestController
@Controller
public class StudentController {
	
	@Autowired
	StudentService service;
	
//	@PostMapping("/addStudent")
//	public String addStudent(@RequestBody Student st) {
//		
//		service.addStudnet(st);
//		
//		//System.out.println(st);
//		return "Studnet successfully!";
//	}
	
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute Student st) {
		service.addStudnet(st);
		return "index";
	}
	
	
//	@GetMapping("/searchStudent")
//	public Student searchStudent(@RequestParam int roll) {
//		 return service.searchStudent(roll);
//		
//	}
//	using postman way
//	
	
	//org.springframework.ui.Model;
	@GetMapping("/searchStudent")
	public String searchStudent(@RequestParam int roll,Model model) {
		 Student st= service.searchStudent(roll);
		 model.addAttribute("student",st);
		 return "displayStudent";
		
	}
	
	
	
//	@PutMapping("/updateStudent")
//	public String updateStudent(@RequestBody Student st) {
//		service.updateStudent(st);
//		return "Studnet successfully!";
//	}
//	another postman using
	
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute Student st) {
		service.updateStudent(st);
		return "index";
	}
	
	
//	@DeleteMapping("/deleteStudent")
//	public String deleteStudent(@RequestParam int roll) {
//		
//		service.deleteStudent(roll);
//		return "Studnet  delete successfully!";
//	}
//	using this method postman request
//	
	
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam int roll) {
		
		service.deleteStudent(roll);
		return "index";
	}
	
	
//	@GetMapping("/fetchAllStudents")
//public List<Student> fetchAllStudents() {
//		
//		return service.fetchAllStudents();
//	}
//	
// using postam way	
	
	
	@GetMapping("/fetchAllStudents")
     public String fetchAllStudents(Model model) {
    	 List<Student>stList = service.fetchAllStudents();
    	 model.addAttribute("studentList",stList);
    	 return "displayAllStudents";
     }
	
	
//	@DeleteMapping("/deleteAllStudents")
//      public String deleteAllStudents() {		
//		 service.deleteAllStudents();
//		   return "All students deleted!";
//	}
//	This method using the postman whay
//	

	
	@GetMapping("/deleteAllStudents")
    public String deleteAllStudents() {		
		 service.deleteAllStudents();
		   return "index";
	}
	
	
	
	
}
