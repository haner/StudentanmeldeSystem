/**
 * 
 */
package spring.webapp.anmeldesystem.persistence.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.webapp.anmeldesystem.entity.Role;
import spring.webapp.anmeldesystem.entity.User;
import spring.webapp.anmeldesystem.persistence.dao.UserDao;
import spring.webapp.anmeldesystem.persistence.mapper.ProfessorMapper;
import spring.webapp.anmeldesystem.persistence.mapper.StudentMapper;

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