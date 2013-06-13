/**
 * 
 */
package spring.webapp.loginsystem.persistence.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.webapp.loginsystem.entity.Professor;
import spring.webapp.loginsystem.persistence.dao.ProfessorDao;
import spring.webapp.loginsystem.persistence.mapper.ProfessorMapper;

/**
 * @author Songhua Cui
 * 
 */
@Component
public class ProfessorDaoImpl implements ProfessorDao {

	@Autowired
	private ProfessorMapper professorMapper;

	/**
	 * @param email
	 * @return 
	 */
	@Override
	public Professor getProfessorbyEmail(String email) {
		return professorMapper.selectProfessorByEmail(email);
	}

	/**
	 * @param id
	 * @return 
	 */
	@Override
	public Professor getProfessorInfosbyId(long id) {
		return professorMapper.selectProfessorById(id);
	}

}