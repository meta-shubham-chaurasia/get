package com.assignment.EAD8.dao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.assignment.EAD8.model.commands.StudentCommands;

@Repository
public class StudentDAO {
	
	static List<StudentCommands> students = new ArrayList<StudentCommands>();
	static int counter = 1;

	public int addStudent(StudentCommands studentCommands) {
		studentCommands.setId(counter);
		students.add(studentCommands);
		counter++;
		return 0;
	}

	public StudentCommands getStudent(int id) {
		StudentCommands studentCommands = null;
		for (StudentCommands student : students) {
			if (student.getId() == id) {
				studentCommands = student;
				break;
			}
		}
		return studentCommands;
	}

	public boolean deleteStudent(int id) {
		return false;
	}

	public boolean updateStudent(StudentCommands studentCommands) {
		StudentCommands oldStudent = getStudent(studentCommands.getId());
		int index =  students.indexOf(oldStudent);
		students.remove(index);
		students.add(studentCommands); 
		return true;
	}

	public List<StudentCommands> getAllStudents() {
		return students;
	}
}
