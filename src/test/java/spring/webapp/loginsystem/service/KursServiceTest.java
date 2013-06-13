/**
 * 
 */
package spring.webapp.loginsystem.service;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.webapp.loginsystem.entity.Kurs;

/**
 * @author Songhua Cui
 *
 */
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class KursServiceTest {
	@Autowired
	private KursService kursService;

	private final static String ID = "IN 542";

	@Test
	public void testGetKursById() {
		Kurs kurs = kursService.getKursById(ID);
		Assert.assertEquals("Softwaretechnik A", kurs.getTitle());
		Assert.assertEquals("SWTA", kurs.getAbkuerzung());
		Assert.assertEquals("5", kurs.getLeistungspunkte());
		Assert.assertEquals("V2 + P2", kurs.getVeranstaltungsform());
		Assert.assertEquals("Wintersemester, jährlich", kurs.getTurnus());
		Assert.assertEquals("IN542", kurs.getKennwort());
	}
	
	@Test
	public void testGetStudentIdsFromKursStudent() {
		ArrayList<Long> studentIds = kursService.getStudentIdsFromKursStudent(ID);
		Assert.assertFalse(studentIds.isEmpty());
		Assert.assertTrue(studentIds.size() > 1);
	}
}
