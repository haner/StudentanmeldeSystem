/**
 * 
 */
package spring.webapp.anmeldesystem.persistence.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.webapp.anmeldesystem.entity.Datei;
import spring.webapp.anmeldesystem.persistence.dao.DateiDao;
import spring.webapp.anmeldesystem.persistence.mapper.DateiKursProfessorMapper;
import spring.webapp.anmeldesystem.persistence.mapper.DateiMapper;
import spring.webapp.anmeldesystem.persistence.mapper.KursMapper;

/**
 * @author Songhua Cui
 * 
 */
@Component
public class DateiDaoImpl implements DateiDao {

	@Autowired
	private DateiMapper dateiMapper;
	@Autowired
	private DateiKursProfessorMapper dateiKursProfessorMapper;
	@Autowired
	private KursMapper kursMapper;

	/**
	 * @param kursId
	 * @return 
	 */
	@Override
	public List<Datei> getDateienByKursId(String kursId) {
		return dateiMapper.selectDateienByKursId(kursId);
	}

	/**
	 * @param dateiId
	 * @return 
	 */
	@Override
	public Datei getDateiByDateiId(long dateiId) {
		return dateiMapper.selectDateiByDateiId(dateiId);
	}

	/**
	 * @param dateiId
	 */
	@Override
	public void deleteDateiByDateiId(long dateiId) {
		dateiMapper.deleteDatei(dateiId);
	}

	/**
	 * @param datei
	 * @param kursId
	 */
	@Override
	public void saveDatei(Datei datei, String kursId) {
		Datei dateiDB = dateiMapper.selectDateiByDateinameAndTyp(datei.getName(), datei.getTyp());
		if (dateiDB == null) {
			dateiMapper.insertDatei(datei);
			//Hinzufügen die Datei in die Tabelle "Datei-Kurs-Professor"
			Long professorId = kursMapper.selectProfessorFromKursProfessor(kursId);
			addDateiInKursProfessor(dateiMapper.selectDateiByDateinameAndTyp(datei.getName(), datei.getTyp()).getId(), kursId, professorId);
		} else {
			Long dateiId = dateiDB.getId();
			datei.setId(dateiId);
			dateiMapper.updateDatei(datei);
			Long professorId = kursMapper.selectProfessorFromKursProfessor(kursId);
			if(dateiKursProfessorMapper.selectByDateiKursProfessor(dateiId, kursId, professorId) == null){
				addDateiInKursProfessor(dateiId, kursId, professorId);
			}
		}
	}
	
	/**
	 * @param dateiId
	 * @param kursId
	 * @param professorId
	 */
	private void addDateiInKursProfessor(long dateiId, String kursId, Long professorId){
		dateiKursProfessorMapper.insertDateiKursProfessor(dateiId, kursId, professorId);
	}

}
