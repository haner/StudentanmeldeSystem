/**
 * 
 */
package spring.webapp.loginsystem.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.webapp.loginsystem.entity.Student;

/**
 * @author Songhua Cui
 *
 */
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceTest {
	@Autowired
	private StudentService studentService;
	
	private final static String STUDENT_EMAIL = "songhuacui@wfh.de";
	private final static String STUDENT_NAME = "Songhua Cui";
	private final static Long STUDENT_ID = 200921711L;
	private final static Long STUDENT_ID_1 = 201300001L;
	private final static String STUDENT_EMAIL_1 = "student1@wfh.de";

	@Test
	public void testGetStudentInformationen() {
		Student student = studentService.getStudentInformationen(STUDENT_EMAIL);
		Assert.assertEquals(STUDENT_ID.longValue(), student.getId());
		Assert.assertEquals(STUDENT_NAME, student.getName());
		Assert.assertEquals(6, student.getSemesterNummber());
	}
	
	@Test
	public void testGetStudentById() {
		Student student1 = studentService.getStudentById(STUDENT_ID_1);
		Assert.assertFalse(student1==null);
		Assert.assertEquals(STUDENT_ID_1.longValue(), student1.getId());
		Assert.assertEquals(STUDENT_EMAIL_1, student1.getEmail());
	}
}

