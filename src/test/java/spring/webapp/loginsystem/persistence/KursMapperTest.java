/**
 * 
 */
package spring.webapp.loginsystem.persistence;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.webapp.loginsystem.entity.Kurs;
import spring.webapp.loginsystem.persistence.mapper.KursMapper;

/**
 * @author Songhua Cui
 * 
 */

@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class KursMapperTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private KursMapper kursMapper;

	private final static String ID = "IN 542";
	private final static Long STUDENT_ID_1 = 200921711L;

	@Test
	public void testSelectKursByKursId() {
		Kurs kurs = kursMapper.selectKursByKursId(ID);
		Assert.assertEquals("Softwaretechnik A", kurs.getTitle());
		Assert.assertEquals("SWTA", kurs.getAbkuerzung());
		Assert.assertEquals("5", kurs.getLeistungspunkte());
		Assert.assertEquals("V2 + P2", kurs.getVeranstaltungsform());
		Assert.assertEquals("Wintersemester, jährlich", kurs.getTurnus());
		Assert.assertEquals("IN542", kurs.getKennwort());
	}

	@Test
	public void testSelectProfessorFromKursProfessor() {
		Long professorId = kursMapper.selectProfessorFromKursProfessor(ID);
		Assert.assertEquals(9001, professorId.intValue());
	}

	@Test
	public void testSelectStudentIdsFromKursStudentByKursId() {
		ArrayList<Long> studentIds = kursMapper
				.selectStudentIdsFromKursStudentByKursId(ID);
		Assert.assertFalse(studentIds.isEmpty());
		Assert.assertTrue(studentIds.size() > 1);
	}

	@Test
	public void testSelectKursStudentByKursAndStudentId() {
		long count = kursMapper.selectKursStudentByKursAndStudentId(ID,
				STUDENT_ID_1);
		Assert.assertTrue(count >= 1);
	}

}
