package net.slipp.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.domain.User;
import net.slipp.domain.UserRepository;

@Controller
@RequestMapping("/users")
public class UserContorller {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("")
	public String Create(User user, Model model){
		System.out.println(user);
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("")
	public String List(Model model){
		model.addAttribute("users",userRepository.findAll());
		return "list";
	}
	
	@GetMapping("/{Id}/form")
	public String updateForm(@PathVariable Long Id, Model model){
		model.addAttribute("user", userRepository.findOne(Id));
		return "updateForm";
	}
	@GetMapping("/form")
	public String Form(){
		return "form";
	}
	@PostMapping("/{Id}")
	public String Create(@PathVariable Long Id, User newUser){
		User user = userRepository.findOne(Id);
		System.out.println(Id);
		user.update(newUser);
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("/loginForm")
	public String loginForm(){
		return "login";
	}
	@PostMapping("/login")
	public String login(String userId, String userPw, HttpSession session){
		User user = userRepository.findByUserId(userId);
		if(user == null){
			return "redirect:/users/loginForm";
		}
		if(!userPw.equals(user.getUserPw())){
			return "redirect:/users/loginForm";
		}
		
		session.setAttribute("loginUser", user);
		return "redirect:/";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("loginUser");
		return "redirect:/";
	}
}
