/**
 * 
 */
package spring.webapp.loginsystem.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.webapp.loginsystem.entity.Datei;
import spring.webapp.loginsystem.entity.Fachbereich;
import spring.webapp.loginsystem.entity.Kurs;
import spring.webapp.loginsystem.entity.Professor;
import spring.webapp.loginsystem.entity.Role;
import spring.webapp.loginsystem.entity.Student;
import spring.webapp.loginsystem.service.DateiService;
import spring.webapp.loginsystem.service.FachbereichService;
import spring.webapp.loginsystem.service.KursService;
import spring.webapp.loginsystem.service.ProfessorService;
import spring.webapp.loginsystem.service.StudentService;

/**
 * Controller for Mapping a Student, Professor or admin page with Informationen.
 * 
 * @author Songhua Cui
 * 
 */
@Controller
@RequestMapping
public class KursController {

	@Autowired
	private KursService kursService;
	@Autowired
	private DateiService dateiService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private ProfessorService professorService;
	@Autowired
	private FachbereichService fachbereichService;

	/*
	 * @RequestMapping(value = "/course") public String
	 * getKurseInfoPage(ModelMap model) { List<Kurs> kurse =
	 * kursService.getKurse(); model.addAttribute("kurse", kurse); return
	 * "coursesInfo";principal }
	 */

	/**
	 * @param model
	 * @param principal
	 * @return 
	 */
	@RequestMapping(value = "/courses")
	public String getKurseInfoPage(ModelMap model, Principal principal) {
		List<Kurs> kurse = new ArrayList<Kurs>();
		/*
		 * List<Fachbereich> fachbereich = new ArrayList<Fachbereich>(); if
		 * (principal == null) { kurse = kursService.getKurse(); fachbereich =
		 * fachbereichService.getFachbereich();
		 * model.addAttribute("fachbereich", fachbereich); } else {
		 */
		kurse = getKurseByUser(principal);

		List<Kurs> verfuegbareKurse = getKurseInFBByUser(principal);
		model.addAttribute("verfuegbareKurse", verfuegbareKurse);
		model.addAttribute("neuerKurs", new Kurs());
		/* } */
		model.addAttribute("kurse", kurse);
		return "coursesInfo";
	}

	/**
	 * @param principal
	 * @return 
	 */
	private List<Kurs> getKurseByUser(Principal principal) {
		List<Kurs> kurse = new ArrayList<Kurs>();
		if (professorCheck(principal)) {
			Professor professor = professorService
					.getProfessorInformationen(principal.getName());
			kurse = professor.getKurse();
		} else {
			Student student = studentService.getStudentInformationen(principal
					.getName());
			kurse = student.getKurse();

		}
		return kurse;
	}

	/**
	 * @param principal
	 * @return 
	 */
	private List<Kurs> getKurseInFBByUser(Principal principal) {
		List<Kurs> kurse = new ArrayList<Kurs>();
		if (!professorCheck(principal)) {
			Student student = studentService.getStudentInformationen(principal
					.getName());
			List<Fachbereich> fachbereichs = student.getFachbereich();
			for (Fachbereich fachbereich : fachbereichs) {
				ArrayList<Kurs> kurseInFB = kursService
						.getKurseInFB(fachbereich.getFachId());
				kurse.addAll(kurseInFB);
			}
		}
		return kurse;
	}

	/**
	 * @param model
	 * @param kursId
	 * @param principal
	 * @return 
	 */
	@RequestMapping(value = "/singleCourse")
	public String getKursInfoPage(ModelMap model,
			@RequestParam(value = "courseId", required = false) String kursId,
			Principal principal) {
		model.addAttribute("kursId", kursId);
		boolean userIsProfessor = false;
		userIsProfessor = professorCheck(principal);
		if (userIsProfessor) {
			List<Student> students = new ArrayList<Student>();

			ArrayList<Long> studentIds = kursService
					.getStudentIdsFromKursStudent(kursId);
			if (studentIds != null && !studentIds.isEmpty()) {
				for (Long studentId : studentIds) {
					Student student = studentService.getStudentById(studentId);
					students.add(student);
				}
			}
			model.addAttribute("students", students);

			Kurs kurs = kursService.getKursById(kursId);
			model.addAttribute("kurs", kurs);

			List<Datei> dateien = dateiService.getDateienByKursId(kursId);
			model.addAttribute("dateien", dateien);
			return "singleCourseInfo";
		} else {
			return "courseAccess";
		}
	}

	/**
	 * @param model
	 * @param kurs
	 * @param principal
	 * @return 
	 */
	@RequestMapping(value = "/newCourse")
	public String addNewCourse(ModelMap model, @ModelAttribute Kurs kurs,
			Principal principal) {
		Professor professor = professorService
				.getProfessorInformationen(principal.getName());
		kursService.addKurs(kurs, professor.getId());
		return "redirect:/courses";
	}

	/**
	 * @param model
	 * @param kursId
	 * @return 
	 */
	@RequestMapping(value = "/deleteCourse")
	public String deleteCourse(ModelMap model,
			@RequestParam("couseId") String kursId) {
		kursService.deleteKurs(kursId);
		return "redirect:/courses";
	}

	/**
	 * @param model
	 * @param kursId
	 * @param kennwort
	 * @param principal
	 * @return 
	 */
	@RequestMapping(value = "/courseAccess")
	public String getKursAccessPage(ModelMap model,
			@RequestParam(value = "courseId", required = false) String kursId,
			@RequestParam("course_password") String kennwort,
			Principal principal) {
		model.addAttribute("kursId", kursId);

		Kurs kurs = kursService.getKursById(kursId);
		/*
		 * PasswordEncoder encoder = new Md5PasswordEncoder(); String
		 * encodePassword = encoder.encodePassword(kennwort, null);
		 */
		if (kennwort.equals(kurs.getKennwort())) {
			Student student = studentService.getStudentInformationen(principal
					.getName());
			kursService.addStudentIntoKursStudent(kursId, student.getId());
			model.addAttribute("kurs", kurs);
			List<Datei> dateien = dateiService.getDateienByKursId(kursId);
			model.addAttribute("dateien", dateien);
			return "singleCourseInfo";
		} else {
			model.addAttribute("message", "Kennwort ist unkorrekt.");
			return "courseAccess";
		}
	}

	/**
	 * @param principal
	 * @return 
	 */
	private boolean professorCheck(Principal principal) {
		boolean userIsProfessor = true;
		UsernamePasswordAuthenticationToken currentUser = (UsernamePasswordAuthenticationToken) principal;
		Collection<? extends GrantedAuthority> authorities = currentUser
				.getAuthorities();
		Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
		while (iterator.hasNext()) {
			SimpleGrantedAuthority autority = (SimpleGrantedAuthority) iterator
					.next();
			if (autority.getAuthority().contains(Role.STUDENT.roleName())) {
				userIsProfessor = false;
				break;
			}
		}
		return userIsProfessor;
	}
}
