package pl.altkom.hibernatejpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessagesController {
	
	@GetMapping("/international")
    public String getInternationalPage() {
        return "international";
    }

}
