package com.assignment.EAD8.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.assignment.EAD8.model.commands.StudentCommands;
import com.assignment.EAD8.service.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService studentService;	
	
	
	@Value("${home.message}")
	private String message;
	
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		System.out.println("home");
		model.addAttribute("msg",message);		
		return "Home";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("student",new StudentCommands());		
		return "signup";
	}
	
	@PostMapping("/signup")
	public String doSignup(@Validated @ModelAttribute("student") StudentCommands studentCommands, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {			
			return "signup";
		}else {			
			if(studentCommands.getId() == null) {				
				studentService.addStudent(studentCommands);	
			}else {
				studentService.updateStudent(studentCommands);
			}			
			return "redirect:/students";
		}		
	}	
}
