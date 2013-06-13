/**
 * 
 */
package spring.webapp.loginsystem.persistence;

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

import spring.webapp.loginsystem.entity.Fachbereich;
import spring.webapp.loginsystem.entity.Professor;
import spring.webapp.loginsystem.persistence.mapper.ProfessorMapper;

/**
 * @author Songhua Cui
 * 
 */

@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ProfessorMapperTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private ProfessorMapper professorMapper;
	
	private final static String KENNWORT = "fa246d0262c3925617b0c72bb20eeb1d";
	private final static String EMAIL = "juergen.znotka@w-hs.de";
	private final static String NAME = "Prof. Jürgen Znotka";
	private final static Long ID = 9001L;
	private final static String MALE = "male";
	private final static String FEMALE = "female";



	@Test
	public void testSelectProfessorByEmail() {
		Professor professor = professorMapper.selectProfessorByEmail(EMAIL);
		Assert.assertEquals(ID.longValue(), professor.getId());
		Assert.assertEquals(NAME, professor.getName());
		Assert.assertEquals(KENNWORT, professor.getKennwort());
	}
	
	@Test
	public void testSelectProfessorById() {
		Professor professor = professorMapper.selectProfessorById(ID);
		Assert.assertEquals(NAME, professor.getName());
		Assert.assertEquals(EMAIL, professor.getEmail());
		Assert.assertEquals(MALE, professor.getGeschlecht());
		Assert.assertTrue(!professor.getFachbereich().isEmpty());
		Assert.assertTrue(!professor.getKurse().isEmpty());
	}
	
	@Test
	@Ignore
	public void testInsertProfessor(){
		Professor professor = new Professor();
		professor.setEmail("professor1@wfh.de");
		professor.setName("professor1");
		professor.setId(9002L);
		Fachbereich fachbereich = new Fachbereich();
		fachbereich.setFachId(6);
		List<Fachbereich> fbs = new ArrayList<Fachbereich>();
		fbs.add(fachbereich);
		professor.setFachbereich(fbs);
		professor.setGeschlecht(FEMALE);
		professor.setKennwort("44444");
		professorMapper.insertProfessor(professor);
	}
}
