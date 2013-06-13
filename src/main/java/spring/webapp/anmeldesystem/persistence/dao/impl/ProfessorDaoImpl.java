/**
 * 
 */
package spring.webapp.anmeldesystem.persistence.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.webapp.anmeldesystem.entity.Professor;
import spring.webapp.anmeldesystem.persistence.dao.ProfessorDao;
import spring.webapp.anmeldesystem.persistence.mapper.ProfessorMapper;

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