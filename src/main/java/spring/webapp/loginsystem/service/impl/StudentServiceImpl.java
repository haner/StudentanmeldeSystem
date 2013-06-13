/**
 * 
 */
package spring.webapp.loginsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.webapp.loginsystem.entity.Student;
import spring.webapp.loginsystem.persistence.dao.StudentDao;
import spring.webapp.loginsystem.service.StudentService;

/**
 * @author Songhua Cui
 * 
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;

	/**
	 * @param email
	 * @return 
	 */
	@Override
	public Student getStudentInformationen(String email) {
		Student student = studentDao.getStudentbyEmail(email);
		return studentDao.getStudentInfosById(student.getId());
	}
	

	/**
	 * @param studentId
	 * @return 
	 */
	@Override
	public Student getStudentById(long studentId) {
		return studentDao.getStudentById(studentId);
	}

	/**
	 * @param studentId
	 * @return 
	 */
	@Override
	public Student getStudentInfosById(long studentId) {
		return studentDao.getStudentInfosById(studentId);
	}
}
