package com.myproject.mvc;

import com.myproject.util.DateForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController
{
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String homePage() {
		return "redirect:/backoffice";
	}

	@RequestMapping(value = "/backoffice", method = RequestMethod.GET)
	public String backofficeHome(Model model) {
		model.addAttribute("dateForm", new DateForm());
		return "backoffice";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginBackofficeUser(Model model) {
		return "loginManager";
	}

	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String loginBackofficeFailed(Model model) {
		model.addAttribute("error", "true");

		return "loginManager";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutBackoffice(Model model) {
		return "logoutManager";
	}
}
