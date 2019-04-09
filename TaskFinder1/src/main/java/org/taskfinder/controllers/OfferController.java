package org.taskfinder.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.taskfinder.entities.Offer;
import org.taskfinder.entities.Task;
import org.taskfinder.services.MailService;
import org.taskfinder.services.OfferService;
import org.taskfinder.services.TaskService;
import org.taskfinder.services.UserService;


@Controller
public class OfferController {
	
	
	
@Autowired
private OfferService offerService;

@Autowired
private TaskService taskService;

@Autowired
private UserService userService;

@Autowired
private MailService mailService;






@GetMapping("/makeOffer")
public String offerForm(@RequestParam(name = "id") Long id, Model model, Task task, HttpSession session) {
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     String email = auth.getName();
     
     
     session.setAttribute("id", id);
     
     session.setAttribute("email", email);
     
     model.addAttribute("offer", new Offer());
     
	
	 
	
	 return "views/offerPage";
	 
}

@PostMapping("/makeOffer")
public String addOffer(@Valid Offer offer,BindingResult bindingResult, HttpSession session, Model model) {
	 if(bindingResult.hasErrors()) { 
		 return "views/offerPage";
	 }
	 
	 
     String email = (String) session.getAttribute("email");
     Long id = (Long) session.getAttribute("id");
     
   
    
    try {
    	 
    	
    	offerService.addOffer(offer, userService.findOne(email), taskService.findById(id));
    	mailService.sendMail(session);
    	
    	// return  "views/offerSuccess";
    	 
    	 
    	 
    	}
    	catch(Exception ex) {
    	   // Your exception handling code goes between these 
    	   // curly braces, similar to the exception clause 
    	   // in a PL/SQL block.
    		return "views/duplicateOffer";
    	}
    	
    	
  
   
	 
	return  "views/offerSuccess";
	
}


@GetMapping("/acceptedOffer")
public String acceptOffer( Model model, @RequestParam(value = "id") String id, HttpSession session, Task task){
	Long offer_id = Long.parseLong(id);
	Offer offer = offerService.findOne(offer_id);
	offer.setAccepted(1);
	offerService.save(offer);
	
	//System.out.println(task.getId());
	task.setCompleted(1);
	taskService.save(task);
	
	
	
	
	
	//Task task = offerService.findTaskOffer(offer_id);
	
	
	
	
	return "views/acceptedOffer";
	
}

@PostMapping("/acceptedOffer")
public String acceptOffer(@Valid Offer offer,BindingResult bindingResult, HttpSession session, Model model) {
	
	
	
	return "views/acceptedOffer";
	
}


@GetMapping("/offerPage1")
public String acceptOffer1() {

	
	return "views/offerPage1";


}

}







