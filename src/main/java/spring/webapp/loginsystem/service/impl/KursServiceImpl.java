/**
 * 
 */
package spring.webapp.loginsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.webapp.loginsystem.entity.Kurs;
import spring.webapp.loginsystem.persistence.dao.KursDao;
import spring.webapp.loginsystem.service.KursService;

/**
 * @author Songhua Cui
 * 
 */
@Service
@Transactional
public class KursServiceImpl implements KursService {

	@Autowired
	private KursDao kursDao;

	/**
	 * @param kursId
	 * @return 
	 */
	@Override
	public Kurs getKursById(String kursId) {
		return kursDao.getKursById(kursId);
	}

	/**
	 * @return 
	 */
	@Override
	public List<Kurs> getKurse() {
		return kursDao.getKurse();
	}

	/**
	 * @param kursId
	 * @param studentId
	 */
	@Override
	public void addStudentIntoKursStudent(String kursId, long studentId) {
		ArrayList<Long> studentIds = kursDao.getStudentIdFromKursStudent(kursId);
		if(studentIds == null || studentIds.isEmpty() ){
			kursDao.addStudentIntoKursStudent(kursId, studentId);
		}
	}

	/**
	 * @param kursId
	 * @return 
	 */
	@Override
	public ArrayList<Long> getStudentIdsFromKursStudent(String kursId) {
		return kursDao.getStudentIdFromKursStudent(kursId);
	}

	/**
	 * @param kurs
	 * @param professorId
	 */
	@Override
	public void addKurs(Kurs kurs, long professorId) {
		kursDao.addKurs(kurs, professorId);
	}

	/**
	 * @param kursId
	 */
	@Override
	public void deleteKurs(String kursId) {
		kursDao.deleteKurs(kursId);	
	}

	/**
	 * @param fachbreichId
	 * @return 
	 */
	@Override
	public ArrayList<Kurs> getKurseInFB(long fachbreichId) {
		return kursDao.getKurseInFB(fachbreichId);
	}
}
