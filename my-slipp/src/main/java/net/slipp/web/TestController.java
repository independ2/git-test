package net.slipp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/")
	public String Index(Model model){
		return "index";
	}
	@GetMapping("/form")
	public String Form(){
		return "form";
	}

}
