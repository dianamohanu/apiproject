package com.myproject.mvc;

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
		return "backoffice";
	}

}