/**
 * 
 */
package spring.webapp.anmeldesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.webapp.anmeldesystem.entity.Professor;
import spring.webapp.anmeldesystem.persistence.dao.ProfessorDao;
import spring.webapp.anmeldesystem.service.ProfessorService;

/**
 * @author Songhua Cui
 * 
 */
@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	private ProfessorDao professorDao;

	/**
	 * @param email
	 * @return 
	 */
	@Override
	public Professor getProfessorInformationen(String email) {
		Professor professor = professorDao.getProfessorbyEmail(email);
		return professorDao.getProfessorInfosbyId(professor.getId());
	};
}
