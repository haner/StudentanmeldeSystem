/**
 * 
 */
package spring.webapp.anmeldesystem.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.webapp.anmeldesystem.entity.Fachbereich;
import spring.webapp.anmeldesystem.entity.Kurs;
import spring.webapp.anmeldesystem.service.FachbereichService;
import spring.webapp.anmeldesystem.service.KursService;
import spring.webapp.anmeldesystem.service.StudentService;

/**
 * @author Songhua Cui
 * 
 */

@Controller
@RequestMapping("/")
public class CommonController {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CommonController.class);

	@Autowired
	private StudentService studentLoginService;
	@Autowired
	private KursService kursService;
	@Autowired
	private FachbereichService fachbereichService;

	/**
	 * @param model
	 * @param principal
	 * @return 
	 */
	@RequestMapping
	public String getHomePage(ModelMap model, Principal principal) {
		if (principal == null) {
			List<Kurs> kurse = kursService.getKurse();
			List<Fachbereich> fachbereich = fachbereichService.getFachbereich();
			model.addAttribute("fach", fachbereich);
			model.addAttribute("kurse", kurse);
		}
		return "home";
	}
	
	/**
	 * @return 
	*/
	public String getUserPage() {
		return "user";
	}

	/**
	 * @return 
	 */
	@RequestMapping(value = "/admin")
	public String getAdminPage() {
		return "admin";
	}

	/**
	 * @param model
	 * @param fachId
	 * @return 
	 */
	@RequestMapping(value = "/singleFB")
	public String getFachbereichPage(ModelMap model,
			@RequestParam(value = "fbId", required = false) Long fachId) {
		Fachbereich fachbereich = fachbereichService.getFachbereichById(fachId);
		List<Kurs> kurse = kursService.getKurseInFB(fachId);
		model.addAttribute("fachbereich", fachbereich);
		model.addAttribute("kurse", kurse);
		return "faculty";
	}
}
