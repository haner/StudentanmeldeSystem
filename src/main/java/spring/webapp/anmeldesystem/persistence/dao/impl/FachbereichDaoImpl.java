/**
 * 
 */
package spring.webapp.anmeldesystem.persistence.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.webapp.anmeldesystem.entity.Fachbereich;
import spring.webapp.anmeldesystem.persistence.dao.FachbereichDao;
import spring.webapp.anmeldesystem.persistence.mapper.FachbereichMapper;

/**
 * @author Songhua Cui
 *
 */
@Component
public class FachbereichDaoImpl implements FachbereichDao {

	@Autowired
    private FachbereichMapper fachbereichMapper;
	
	@Override
	public Fachbereich getFachbereichById(Long fbId) {
		return fachbereichMapper.selectFachbereichById(fbId);
	}

	@Override
	public List<Fachbereich> getFachbereich() {
		return fachbereichMapper.selectFachbereich();
	}

	@Override
	public void deleteFachbereich(Long fbId) {
		fachbereichMapper.deleteFachbereich(fbId);
	}

	@Override
	public void addFachbereich(Fachbereich fachbereich) {
		
		Long fbId = fachbereich.getFachId();
		Fachbereich fachbereichDB = fachbereichMapper.selectFachbereichById(fbId);
		if(fachbereichDB==null){
			fachbereichMapper.insertFachbereich(fachbereich);
		}else{
			fachbereichMapper.updateFachbereich(fachbereich);
		}		
	}

}
