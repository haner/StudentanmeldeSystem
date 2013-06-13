/**
 * 
 */
package spring.webapp.anmeldesystem.persistence;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.webapp.anmeldesystem.entity.Fachbereich;
import spring.webapp.anmeldesystem.entity.Student;
import spring.webapp.anmeldesystem.persistence.mapper.StudentMapper;

/**
 * @author Songhua Cui
 * 
 */

@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentMapperTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private StudentMapper studentMapper;
	
	private final static String KENNWORT = "b59c67bf196a4758191e42f76670ceba";
	private final static String EMAIL = "songhuacui@wfh.de";
	private final static String NAME = "Songhua Cui";
	private final static Long ID = 200921711L;
	private final static String MALE = "male";
	private final static String FEMALE = "female";

	@Test
	public void testSelectStudentByEmail() {
		Student student = studentMapper.selectStudentByEmail(EMAIL);
		Assert.assertEquals(ID.longValue(), student.getId());
		Assert.assertEquals(NAME, student.getName());
		Assert.assertEquals(KENNWORT, student.getKennwort());
		Assert.assertEquals(6, student.getSemesterNummber());
	}
	
	@Test
	public void testSelectStudentInfosById() {
		Student student = studentMapper.selectStudentInfosById(200921711);
		Assert.assertEquals(NAME, student.getName());
		Assert.assertEquals(EMAIL, student.getEmail());
		Assert.assertEquals(6, student.getSemesterNummber());
		Assert.assertEquals(501, student.getFachrichtung());
		Assert.assertEquals(FEMALE, student.getGeschlecht());
		Assert.assertTrue(!student.getFachbereich().isEmpty());
		Assert.assertTrue(!student.getKurse().isEmpty());
	}
	
	
	@Test
	public void testSelectStudentById() {
		Student student1 = studentMapper.selectStudentById(201300001L);
		Assert.assertFalse(student1==null);		
	}
	

	
	@Test
	@Ignore
	public void testInsertStudent(){
		Student student = new Student();
		student.setEmail("student1@wfh.de");
		student.setName("student1");
		student.setSemesterNummber(1);
		student.setId(201300001L);
		Fachbereich fachbereich = new Fachbereich();
		fachbereich.setFachId(6);
		List<Fachbereich> fbs = new ArrayList<Fachbereich>();
		fbs.add(fachbereich);
		student.setFachbereich(fbs);
		student.setFachrichtung(501);
		student.setGeschlecht(MALE);
		student.setKennwort("22222");
		studentMapper.insertStudent(student);
	}
}
