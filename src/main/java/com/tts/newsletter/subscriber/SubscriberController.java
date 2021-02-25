package com.tts.newsletter.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SubscriberController {
    
	@Autowired
	  private SubscriberRepository subscriberRepository;
	  
	@GetMapping(value= "/")
	public String index(Subscriber subscriber) {
    	return "subscriber/index";
    }
	
	@GetMapping(value= "/rocky")
	public String rocky() {
    	return "subscriber/rocky";
    }
	
	@GetMapping(value= "/about")
	public String about() {
    	return "subscriber/about";
    }
	
	private Subscriber subscriber;
	@PostMapping(value = "/")
	public String addNewSubscriber(Subscriber subscriber, Model model) {
		subscriberRepository.save(new Subscriber(subscriber.getFirstName(), 
	    subscriber.getLastName(), subscriber.getEmailAddress(), subscriber.getSignedUp()));
		model.addAttribute("firstName", subscriber.getFirstName());
		model.addAttribute("lastName", subscriber.getLastName());
		model.addAttribute("emailAddress", subscriber.getEmailAddress());
		return "subscriber/result";
	}

}
