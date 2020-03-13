package com.assignment.EAD8.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.assignment.EAD8.model.commands.StudentCommands;
import com.assignment.EAD8.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ModelAndView students() {
		List<StudentCommands> students =  studentService.getAllStudents();
		return new ModelAndView("students","students",students);
	}

	@GetMapping("/students/{id}")
	public ModelAndView students(@PathVariable("id") int id) {
		return new ModelAndView("signup","student",studentService.getEmpolyee(id));
	}
}
