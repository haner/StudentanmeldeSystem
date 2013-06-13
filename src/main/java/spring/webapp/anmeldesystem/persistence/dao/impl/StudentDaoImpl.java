/**
 * 
 */
package spring.webapp.anmeldesystem.persistence.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.webapp.anmeldesystem.entity.Student;
import spring.webapp.anmeldesystem.persistence.dao.StudentDao;
import spring.webapp.anmeldesystem.persistence.mapper.StudentMapper;

/**
 * @author Songhua Cui
 * 
 */
@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private StudentMapper studentMapper;

	/**
	 * @param email
	 * @return 
	 */
	@Override
	public Student getStudentbyEmail(String email) {
		return studentMapper.selectStudentByEmail(email);
	}
	
	/**
	 * @param id
	 * @return 
	 */
	@Override
	public Student getStudentById(long id) {
		return  studentMapper.selectStudentById(id);
	}

	/**
	 * @param id
	 * @return 
	 */
	@Override
	public Student getStudentInfosById(long id) {
		return studentMapper.selectStudentInfosById(id);
	}

}