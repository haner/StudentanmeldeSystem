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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.webapp.anmeldesystem.entity.Fachbereich;
import spring.webapp.anmeldesystem.entity.Kurs;
import spring.webapp.anmeldesystem.service.FachbereichService;
import spring.webapp.anmeldesystem.service.KursService;

/**
 * @author Songhua Cui
 *
 */
@Controller
@RequestMapping
public class LoginController{

	@Autowired
	private KursService kursService;
	@Autowired
	private FachbereichService fachbereichService;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * @param model
	 * @param message
	 * @return 
	 */
	@RequestMapping("/login")
	public String login(Model model, @RequestParam(required=false) String message, Principal principal) {
		if (principal == null) {
			List<Kurs> kurse = kursService.getKurse();
			List<Fachbereich> fachbereich = fachbereichService.getFachbereich();
			model.addAttribute("fachbereich", fachbereich);
			model.addAttribute("kurse", kurse);
		}
		model.addAttribute("message", message);
		return "access/login";
	}
	
	/**
	 * @return 
	 */
	@RequestMapping(value = "/denied")
 	public String denied() {
		return "access/denied";
	}
	
	/**
	 * @return 
	 */
	@RequestMapping(value = "/login/failure")
 	public String loginFailure() {
		String message = "Login Failure!";
		return "redirect:/login?message="+message;
	}
	
	/**
	 * @return 
	 */
	@RequestMapping(value = "/logout/success")
 	public String logoutSuccess() {
		String message = "Logout Success!";
		return "redirect:/login?message="+message;
	}
}
