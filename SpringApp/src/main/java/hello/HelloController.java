package hello;

import org.springframework.web.bind.annotation.RestController;

import github.GitController;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Nécéssaire de spécifier @Controller à la place de @RestController
public class HelloController {

	// Un fichier nommé "application.properties" (situé dans src/main/ressources)
	// est lu. C'est une configuration de Spring
	@RequestMapping("/")
	public String index() {
		return "hello"; // Grâce à "application.property", "return hello" pointe sur
						// src/main/webapp/web-inf/jsp/hello.jsp
	}

	@RequestMapping("/search")
	public String HistoricDisplay(
			@Valid @ModelAttribute("gitcontroller") GitController gitcontroller,
			BindingResult result, ModelMap model) {
		
		/*
		GitController gc = GitController.getInstance("quentinceschin123456", "changelog_viewer", "");

		if (result.hasErrors()) {
			return "error";
		}
		model.addAttribute("gitcontroller", gc);*/

		return "historic";
	}
}
