package com.websystique.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.Student;

@Controller
@RequestMapping("/")
public class HelloWorldController 
{
	@RequestMapping(method = RequestMethod.GET)
	public String newRegistration(ModelMap model)
	{
		Student student = new Student();
		model.addAttribute("student", student);
		return "enroll";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveRegistration(@Valid Student student, BindingResult result, ModelMap model)
	{
		if(result.hasErrors())
		{
			return "enroll";
		}
		
		model.addAttribute("success", "Dear " + student.getFirstName() + ", your registration completed successfully");
		
		return "success";
	}
	
	@ModelAttribute("sections")
	public List<String> Sections()
	{
		List<String> sections = new ArrayList<String>();
        sections.add("Graduate");
        sections.add("Post Graduate");
        sections.add("Research");
        return sections;
	}
	
	
    @ModelAttribute("countries")
    public List<String> initializeCountries() 
    {
        List<String> countries = new ArrayList<String>();
        countries.add("USA");
        countries.add("CANADA");
        countries.add("FRANCE");
        countries.add("GERMANY");
        countries.add("ITALY");
        countries.add("OTHER");
        return countries;
    }
    
    
    @ModelAttribute("subjects")
    public List<String> initializeSubjects() 
    {
        List<String> subjects = new ArrayList<String>();
        subjects.add("Physics");
        subjects.add("Chemistry");
        subjects.add("Life Science");
        subjects.add("Political Science");
        subjects.add("Computer Science");
        subjects.add("Mathmatics");
        return subjects;
    }
}
