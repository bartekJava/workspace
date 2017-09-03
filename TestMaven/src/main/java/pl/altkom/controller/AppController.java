package pl.altkom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	private Environment environment; //thanks to PropertySourcesPlaceholderConfigurer, this Environment will get access to all the properties declared in specified .properties file
	
	
	
	@Value("${application.name:default_name}")
	private String applicationName;
	
	@Value("${application.version:default_version}")
	private String applicationVersion;
	
	@Value("${filter.value:default_value}")
	private String filterValue;

	
	
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("applicationName", applicationName);
		model.addAttribute("applicationVersion", applicationVersion);
		model.addAttribute("filterValue", filterValue);
		
		return "index";
	}

}
