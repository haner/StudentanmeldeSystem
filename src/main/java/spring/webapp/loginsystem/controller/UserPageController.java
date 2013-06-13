/**
 * 
 */
package spring.webapp.loginsystem.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.webapp.loginsystem.entity.Professor;
import spring.webapp.loginsystem.entity.Student;
import spring.webapp.loginsystem.service.ProfessorService;
import spring.webapp.loginsystem.service.StudentService;

/**
 * Controller for Mapping a Student, Professor or admin page with Informationen.
 * 
 * @author Songhua Cui
 * 
 */
@Controller
@RequestMapping("/")
public class UserPageController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private ProfessorService professorService;

	/**
	 * @param model
	 * @param principal
	 * @return 
	 */
	@RequestMapping(value = "/studentHome")
	public String getStudentHomePage(ModelMap model, Principal principal) {
		// User user =
		// (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Student student = studentService.getStudentInformationen(principal
				.getName());
		model.addAttribute("student", student);
		return "studentHome";
	}

	/**
	 * @param model
	 * @param principal
	 * @return 
	 */
	@RequestMapping(value = "/studentInfo")
	public String getStudentInfoPage(ModelMap model, Principal principal) {
		Student student = studentService.getStudentInformationen(principal
				.getName());
		model.addAttribute("student", student);
		return "studentInfo";
	}

	/**
	 * @param model
	 * @param principal
	 * @return 
	 */
	@RequestMapping(value = "/professorHome")
	public String getProfessorHomePage(ModelMap model, Principal principal) {
		Professor professor = professorService
				.getProfessorInformationen(principal.getName());
		model.addAttribute("professor", professor);
		return "professorHome";
	}

	/**
	 * @param model
	 * @param principal
	 * @return 
	 */
	@RequestMapping(value = "/professorInfo")
	public String getProfessorInfoPage(ModelMap model, Principal principal) {
		Professor professor = professorService.getProfessorInformationen(principal
				.getName());
		model.addAttribute("professor", professor);
		return "professorInfo";
	}

	/**
	 * @return 
	 */
	@RequestMapping(value = "/adminHome")
	public String getAdminHomePage() {
		return "adminHome";
	}
}
