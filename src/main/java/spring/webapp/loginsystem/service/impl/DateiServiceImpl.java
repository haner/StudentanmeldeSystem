/**
 * 
 */
package spring.webapp.loginsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.webapp.loginsystem.entity.Datei;
import spring.webapp.loginsystem.persistence.dao.DateiDao;
import spring.webapp.loginsystem.service.DateiService;

/**
 * @author Songhua Cui
 * 
 */
@Service
@Transactional
public class DateiServiceImpl implements DateiService {

	@Autowired
	private DateiDao dateiDao;

	/**
	 * @param kursId
	 * @return 
	 */
	@Override
	public List<Datei> getDateienByKursId(String kursId) {
		return dateiDao.getDateienByKursId(kursId);
	}

	/**
	 * @param dateiId
	 * @return 
	 */
	@Override
	public Datei getDateiByDateiId(long dateiId) {
		return dateiDao.getDateiByDateiId(dateiId);
	}

	/**
	 * @param dateiId
	 */
	@Override
	public void deleteDateiByDateiId(long dateiId) {
		dateiDao.deleteDateiByDateiId(dateiId);
	}

	/**
	 * @param datei
	 * @param kursId
	 */
	@Transactional
	@Override
	public void saveDatei(Datei datei, String kursId) {
		try {
			synchronized (this) {
				dateiDao.saveDatei(datei, kursId);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
