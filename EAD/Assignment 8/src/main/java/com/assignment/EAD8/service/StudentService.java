package com.assignment.EAD8.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment.EAD8.dao.StudentDAO;
import com.assignment.EAD8.model.commands.StudentCommands;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public int addStudent(StudentCommands studentCommands) {
		studentDAO.addStudent(studentCommands);			
		return 0;
	}

	public StudentCommands getEmpolyee(int id) {
		return studentDAO.getStudent(id);
	}

	public boolean deleteStudent(int id) {
		return false;
	}

	public boolean updateStudent(StudentCommands studentCommands) {			
		return studentDAO.updateStudent(studentCommands);
	}

	public List<StudentCommands> getAllStudents() {			
		return studentDAO.getAllStudents();
	}
}


