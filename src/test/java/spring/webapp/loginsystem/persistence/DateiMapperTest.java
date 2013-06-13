/**
 * 
 */
package spring.webapp.loginsystem.persistence;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import spring.webapp.loginsystem.entity.Datei;
import spring.webapp.loginsystem.persistence.mapper.DateiMapper;

/**
 * @author Songhua Cui
 * 
 */
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class DateiMapperTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private DateiMapper dateiMapper;

	private final static Long ID = 1L;
	private final static String KURS_ID = "IN 542";

	@Test
	public void testSelectDateiByDateiId() {
		Datei datei = dateiMapper.selectDateiByDateiId(ID);
		Assert.assertEquals("datei1.txt", datei.getName());
		Assert.assertEquals("Die erste Datei", datei.getBeschreibung());
		Assert.assertEquals("text/plain", datei.getTyp());
	}

	@Test
	public void testInsertDatei() {
		int count = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM DATEI");
		Datei datei = new Datei();
		datei.setName("test.txt");
		datei.setBeschreibung("This is a unit test.");
		datei.setTyp("text/html");
		dateiMapper.insertDatei(datei);
		int countTmp = count;
		count = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM DATEI");
		Assert.assertTrue(count == countTmp + 1);

		List<Datei> dateien = jdbcTemplate.query("SELECT * FROM DATEI",
				new BeanPropertyRowMapper<Datei>(Datei.class));
		Assert.assertTrue(dateien != null);
		Datei dateiDB = dateien.get(dateien.size() - 1);
		Assert.assertTrue(dateiDB != null);
		Assert.assertEquals("test.txt", dateiDB.getName());
		Assert.assertEquals("This is a unit test.", dateiDB.getBeschreibung());
		Assert.assertEquals("text/html", dateiDB.getTyp());
	}

	@Test
	public void testUpdateDatei() {
		List<Datei> dateien = jdbcTemplate.query("SELECT * FROM DATEI",
				new BeanPropertyRowMapper<Datei>(Datei.class));
		Assert.assertTrue(dateien != null);
		Datei dateiDB = dateien.get(dateien.size() - 1);
		Assert.assertTrue(dateiDB != null);
		Datei datei = new Datei();
		datei.setId(dateiDB.getId());
		datei.setName("test.txt");
		datei.setBeschreibung("This is a unit test.");
		datei.setTyp("text/html");
		dateiMapper.updateDatei(datei);

		dateien = jdbcTemplate.query("SELECT * FROM DATEI",
				new BeanPropertyRowMapper<Datei>(Datei.class));
		Assert.assertTrue(dateien != null);
		dateiDB = dateien.get(dateien.size() - 1);
		Assert.assertTrue(dateiDB != null);
		Assert.assertEquals("test.txt", dateiDB.getName());
		Assert.assertEquals("This is a unit test.", dateiDB.getBeschreibung());
		Assert.assertEquals("text/html", dateiDB.getTyp());
	}

}
