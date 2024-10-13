package com.luv2code.cruddemo;

import java.beans.BeanProperty;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			
			//to create
			// createStudent(studentDAO);  
			createMultipleStudent(studentDAO);

			//to read
			//readStudent(studentDAO);

			//to find students
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);

			//to update
			//updateStudent(studentDAO);

			//to delete
			//deleteStudent(studentDAO);

			//to delete all
			//deleteAllStudents(studentDAO);
			
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println("Deleting all students");
		int numRowsDeleted= studentDAO.deleteAll();
		System.out.println("Deleted row  count: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int studentId = 5;

		System.out.println("Deleting student id: "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		

		//retreive students basse on id primary key
		int studentId= 1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);
		
		//change name to  "Jay"
		System.out.println("updating Student");
		myStudent.setFirstName("Jay");

		//update student
		studentDAO.update(myStudent);

		//display updated student
		System.out.println("Updated Student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		

		//get a list of students
		List<Student> thStudents = studentDAO.findByLastName("Pawar");
		for(Student tempStudent: thStudents){
			System.out.println(tempStudent);
		}

		//display a list of students
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		

		//get a list of students

		List<Student> theStudents = studentDAO.findAll();

		//display list off stuents
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		//create student object 
		System.out.println("Creating a new student object");
		Student tempStudent = new Student("Prem","kadam", "prem.kad@tcs.com");


		//save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);


		//display id of saved student
		int theId = tempStudent.getId();
		System.out.println("Saved Student. Generated ID: "+theId);


		//retreive student based on id
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent = studentDAO.findById(theId);


		//display student
		System.out.println("Found the student: "+myStudent);


	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		//create multiple students
		System.out.println("Creating new student object");
		Student tempStudent1 = new Student("harsh", "panchu", "panchu.harsh@tcs.com");
		Student tempStudent2 = new Student("om", "pawar", "pawar.om@tcs.com");
		Student tempStudent3 = new Student("Diraj", "balu", "balu.di@tcs.com");

		//save studdent objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO){
		//create student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Pranay", "Shinde", "shinde.pranay@tcs.com");
	
		//save student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of savedd student
		System.out.println("Saved student. Generate id: "+tempStudent.getId()
		);
	}

}