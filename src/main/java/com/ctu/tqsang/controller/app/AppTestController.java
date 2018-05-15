package com.ctu.tqsang.controller.app;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ctu.tqsang.domain.User;
import com.ctu.tqsang.service.UserService;
import com.ctu.tqsang.validator.UserValidator;


@Controller
public class AppTestController {
	
	
	 @Autowired
	    UserService userService;
	    
	 @Autowired
	    UserValidator userValidator;
	 
	 
	 @GetMapping("/testcode")
	 public String getRegister(Model model) {
	        model.addAttribute("user", new User());
	        return "testcode";
	    }

	 @ResponseBody
	 @PostMapping("/testcode")
	    public String postRegister(@Valid User user, BindingResult result,
	            RedirectAttributes redirect) {
	        userValidator.validate(user, result);
	        if (result.hasErrors()) {
	            return "register";
	        }

	        userService.create(user, "member");
	        redirect.addFlashAttribute("success", "You registered successfully!");
	        return "redirect:/login";
	    }
}
