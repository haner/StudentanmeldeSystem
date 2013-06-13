/**
 * 
 */
package spring.webapp.loginsystem.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.webapp.loginsystem.entity.Kurs;
import spring.webapp.loginsystem.persistence.dao.KursDao;
import spring.webapp.loginsystem.persistence.mapper.KursMapper;

/**
 * @author Songhua Cui
 * 
 */
@Component
public class KursDaoImpl implements KursDao {

	@Autowired
	private KursMapper kursMapper;

	/**
	 * @param kursId
	 * @return 
	 */
	@Override
	public Kurs getKursById(String kursId) {
		return kursMapper.selectKursByKursId(kursId);
	}

	/**
	 * @return 
	 */
	@Override
	public List<Kurs> getKurse() {
		return kursMapper.selectKurse();

	}

	/**
	 * @param kursId
	 * @return 
	 */
	@Override
	public ArrayList<Long> getStudentIdFromKursStudent(String kursId) {
		return kursMapper.selectStudentIdsFromKursStudentByKursId(kursId);
	}

	/**
	 * @param kursId
	 * @param studentId
	 */
	@Override
	public void addStudentIntoKursStudent(String kursId, long studentId) {
		kursMapper.insertStudentInKursStudent(kursId, studentId);		
	}

	/**
	 * @param kurs
	 * @param professorId
	 */
	@Override
	public void addKurs(Kurs kurs, long professorId) {
		String kursId = kurs.getKursId();
		Kurs kursDB = kursMapper.selectKursByKursId(kursId);
		if(kursDB==null){
			kursMapper.insertKurs(kurs);
			kursMapper.insertProfessorInKursStudent(kursId, professorId);
		}else{
			kursMapper.updateKurs(kurs);
		}		
	}

	/**
	 * @param kursId
	 */
	@Override
	public void deleteKurs(String kursId) {
		kursMapper.deleteKursProfessor(kursId);
		kursMapper.deleteKurs(kursId);
	}

	/**
	 * @param fachbreichId
	 * @return 
	 */
	@Override
	public ArrayList<Kurs> getKurseInFB(long fachbreichId) {
		return kursMapper.selectKurseInFB(fachbreichId);
	}

}