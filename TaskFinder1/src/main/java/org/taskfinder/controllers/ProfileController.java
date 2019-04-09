package org.taskfinder.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.taskfinder.entities.User;
import org.taskfinder.services.OfferService;
import org.taskfinder.services.TaskService;
import org.taskfinder.services.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	@Autowired
	private OfferService offerService;
	
//	@GetMapping("/myPostings")
//	public String showProfilePage(Model model, Principal principal) {
//		
//		String email = principal.getName();
//		User user = userService.findOne(email);
//		
//		model.addAttribute("tasks", taskService.findUserTask(user));
//		
//			
//			
//		
//		return "views/myPostings";
//	}
//	
//	
//	@GetMapping("/offerList")
//	public String showofferList(Model model, Principal principal) {
//		
//		String email = principal.getName();
//		User user = userService.findOne(email);
//		
//		
//		model.addAttribute("offers", offerService.findUserOffer(user));
//		
//		
//		return "views/offerList";
//	}
//	
	

}
