/**
 * 
 */
package spring.webapp.loginsystem.persistence.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.webapp.loginsystem.entity.Role;
import spring.webapp.loginsystem.entity.User;
import spring.webapp.loginsystem.persistence.dao.UserDao;
import spring.webapp.loginsystem.persistence.mapper.ProfessorMapper;
import spring.webapp.loginsystem.persistence.mapper.StudentMapper;

/**
 * @author Songhua Cui
 * 
 */
@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private ProfessorMapper professorMapper;

	/**
	 * @param email
	 * @return 
	 */
	@Override
	public User searchUserByEmail(String email) {
		// Retrieve all users from the database
		User user = studentMapper.selectStudentByEmail(email);
		if(user !=null){
			user.setRole(Role.USER);
			user.setRole(Role.STUDENT);
		}else{
			user = professorMapper.selectProfessorByEmail(email);
			if(user != null){
				user.setRole(Role.USER);
				user.setRole(Role.PROFESSOR);
			}
			/*else{
				user = adminMapper.selectAdminByEmail(email);
				if(user != null){
					user.setRole(Role.USER);
					user.setRole(Role.ADMIN);
				}
			}*/
		}
		
		if(user == null){
			throw new RuntimeException("User does not exist!");
		}
		
		return user;
	}

}