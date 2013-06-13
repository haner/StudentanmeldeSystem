package spring.webapp.loginsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.webapp.loginsystem.entity.Fachbereich;
import spring.webapp.loginsystem.persistence.dao.FachbereichDao;
import spring.webapp.loginsystem.service.FachbereichService;

/**
 * @author Songhua Cui
 * 
 */
@Service
@Transactional
public class FachbereichServiceImpl implements FachbereichService {

	@Autowired
	private FachbereichDao fachbereichDao;
	
	@Override
	public Fachbereich getFachbereichById(Long fbId) {
		return fachbereichDao.getFachbereichById(fbId);
	}

	@Override
	public List<Fachbereich> getFachbereich() {
		return fachbereichDao.getFachbereich();
	}

	@Override
	public void deleteFachbereich(Long fbId) {
		fachbereichDao.deleteFachbereich(fbId);
	}

	@Override
	public void addFachbereich(Fachbereich fachbereich) {
		fachbereichDao.addFachbereich(fachbereich);
	}

}
