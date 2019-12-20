package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Nécéssaire de spécifier @Controller à la place de @RestController
public class HelloController {
	
	//Un fichier nommé "application.properties" (situé dans src/main/ressources) est lu. C'est une configuration de Spring
	@RequestMapping("/")
	public String index() {
		return "hello"; // Grâce à "application.property", "return hello" pointe sur src/main/webapp/web-inf/jsp/hello.jsp
	}
}
