package hello.vue;

public class FormRepoSelector {

	public static String FormVue() {
		return "<!DOCTYPE html>\r\n" + 
				"<html lang=\"fr\">\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
				"    <title>Document</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"    <form action=\"\" method=\"get\" class=\"form-repo-select\">\r\n" + 
				"        <div class=\"form-repo-select\">\r\n" + 
				"          <label for=\"nameRepo\">Enter the repo name: </label>\r\n" + 
				"          <input type=\"text\" name=\"name\" id=\"name\" required>\r\n" + 
				"        </div>\r\n" + 
				"        <div class=\"form-repo-select\">\r\n" + 
				"          <label for=\"email\">Enter your email: </label>\r\n" + 
				"          <input type=\"email\" name=\"email\" id=\"email\" required>\r\n" + 
				"        </div>\r\n" + 
				"        <div class=\"form-repo-select\">\r\n" + 
				"          <input type=\"submit\" value=\"Subscribe!\">\r\n" + 
				"        </div>\r\n" + 
				"      </form>\r\n" + 
				"</body>\r\n" + 
				"</html>";
	}
}
