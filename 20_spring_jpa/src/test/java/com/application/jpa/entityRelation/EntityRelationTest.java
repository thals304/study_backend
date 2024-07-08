package com.application.jpa.entityRelation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.jpa.chapter04_entityRelation.manyToMany.Course;
import com.application.jpa.chapter04_entityRelation.manyToMany.CourseRepository;
import com.application.jpa.chapter04_entityRelation.manyToMany.Student;
import com.application.jpa.chapter04_entityRelation.manyToMany.StudentRepository;
import com.application.jpa.chapter04_entityRelation.manyToOne.Post;
import com.application.jpa.chapter04_entityRelation.manyToOne.PostRepository;
import com.application.jpa.chapter04_entityRelation.manyToOne.Reply;
import com.application.jpa.chapter04_entityRelation.manyToOne.ReplyRepository;
import com.application.jpa.chapter04_entityRelation.oneToMany.Employee;
import com.application.jpa.chapter04_entityRelation.oneToMany.EmployeeRepository;
import com.application.jpa.chapter04_entityRelation.oneToMany.Salary;
import com.application.jpa.chapter04_entityRelation.oneToMany.SalaryRepository;
import com.application.jpa.chapter04_entityRelation.oneToOne.Applicant;
import com.application.jpa.chapter04_entityRelation.oneToOne.ApplicantRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class EntityRelationTest {

	/* many to one */
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Order(1)
	@Transactional
	@DisplayName("manyToOneTest")
	@Test
	public void manyToOneTest() {
		System.out.println("\n - manyToOne -\n");
		/*
		// 단방향 Test
		for (Reply reply : replyRepository.findAll()) {
			System.out.println(reply.toStringCustom()); // Reply만 조회
			//System.out.println(reply.getPost().toStringCustom()); // Post까지 조회
			System.out.println("\n===========\n");
		}
		*/
		
		// 양방향 Test
		for (Post post : postRepository.findAll()) {
			System.out.println(post.toStringCustom()); // Post만 조회
			for(Reply reply : post.getReplies()) {
				System.out.println(reply.toStringCustom());
			}
			System.out.println("\n===========\n");
		}
		
	}
	
	/* One to Many */
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private SalaryRepository salaryRepository;
	
	@Order(2)
	@Transactional
	@DisplayName("oneToManyTest")
	@Test
	public void OneToManyTest() {
		System.out.println("\n - oneToMany -\n");
		
		for(Employee employee : employeeRepository.findAll()) {
			System.out.println(employee.toStringCustom());
			for (Salary salary : employee.getSalaries()) {
				System.out.println(salary.toStringCustom());
			}
		}
		
	}
	
	/* One to One */
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Order(3)
	@Transactional
	@DisplayName("oneToOneTest")
	@Test
	public void oneToOneTest() {
		
		System.out.println("\n - oneToOneTest - \n");
		for (Applicant applicant : applicantRepository.findAll()) {
			System.out.println(applicant);
			//System.out.println(applicant.getProfile().toStringCustom());
			System.out.println("\n===========================\n");
		}
		
	}
	
	/* Many to Many */
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Order(4)
	@Transactional
	@DisplayName("manyToManyTest")
	@Test
	public void manyToManyTest() {
		
		System.out.println("\n - manyToManyTest - \n");
		for (Student student : studentRepository.findAll()) {
			System.out.println(student.toStringCustom());
			for (Course course : student.getCourses()) {
				System.out.println(course.toStringCustom());
			}
			System.out.println("\n===========================\n");
		}

}
}