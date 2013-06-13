/**
 * 
 */
package spring.webapp.anmeldesystem.persistence;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import spring.webapp.anmeldesystem.entity.DateiKursProfessor;
import spring.webapp.anmeldesystem.persistence.mapper.DateiKursProfessorMapper;

/**
 * @author Songhua Cui
 * 
 */
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class DateiKursProfessorMapperTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private DateiKursProfessorMapper dateiKursProfessorMapper;
	
	private final static String KURS_ID_1 = "IN 542";
	private final static String KURS_ID_2 = "IN 543";

	@Test
	public void testSelectByKursId() {
		DateiKursProfessor dkp = dateiKursProfessorMapper.selectByKursId(KURS_ID_1);
		Assert.assertTrue(dkp != null);
	}
	
	@Test
	public void testInsertDateiKursProfessor() {
		List<DateiKursProfessor>  dkps = jdbcTemplate.query("SELECT * FROM DATAI_KURS_PROFESSOR",
				new BeanPropertyRowMapper<DateiKursProfessor>(DateiKursProfessor.class));
		Assert.assertTrue(dkps != null);
		DateiKursProfessor dkp = dkps.get(dkps.size() - 1);
		Assert.assertTrue(dkp != null);
		dateiKursProfessorMapper.insertDateiKursProfessor(dkp.getDateiId()+1, KURS_ID_2, 9001L);
	}
}
