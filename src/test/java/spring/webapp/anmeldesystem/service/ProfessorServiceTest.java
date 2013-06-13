/**
 * 
 */
package spring.webapp.anmeldesystem.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.webapp.anmeldesystem.entity.Professor;
import spring.webapp.anmeldesystem.service.ProfessorService;

/**
 * @author Songhua Cui
 *
 */
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ProfessorServiceTest {
	@Autowired
	private ProfessorService professorService;
	
	private final static String EMAIL = "juergen.znotka@w-hs.de";
	private final static String NAME = "Prof. Jürgen Znotka";
	private final static Long ID = 9001L;
	private final static String KENNWORT = "fa246d0262c3925617b0c72bb20eeb1d";

	@Test
	public void testStudentLogin() {
		Professor professor = professorService.getProfessorInformationen(EMAIL);
		Assert.assertEquals(ID.longValue(), professor.getId());
		Assert.assertEquals(NAME, professor.getName());
		Assert.assertEquals(KENNWORT, professor.getKennwort());
	}
}
