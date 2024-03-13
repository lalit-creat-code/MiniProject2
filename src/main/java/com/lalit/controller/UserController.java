package com.lalit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lalit.binding.LoginForm;
import com.lalit.binding.RegisterForm;
import com.lalit.binding.ResetPasswordForm;
import com.lalit.entity.User;
import com.lalit.services.ServiceImpl;
import com.lalit.utils.EmailUtils;
@Controller
public class UserController {
         @Autowired
         EmailUtils util;
		@Autowired
		private ServiceImpl service;
		@GetMapping("/")
		public String login(Model model) {
		model.addAttribute("login",new LoginForm());
			  return "index";
			  }
		@PostMapping("/login")
		public String loginCheck(@ModelAttribute("login")LoginForm object,Model model) {
			User user=service.login(object);
			if(user==null) {
				model.addAttribute("errMsg","Invalid credentials");
				return "index";
			}			if(user.getPwdUpdated().equals("NO")){
				
				
				model.addAttribute("id",user.getUserId());
				model.addAttribute("Reset",new ResetPasswordForm());
				return  "ResetPassword";
			}else
				return "redirect:dashboard";
		}
		@PostMapping("/reset")
		public String  resertPassword(@ModelAttribute("Reset") ResetPasswordForm Object,Model model) {
			if(!Object.getNewPassword().equals(Object.getconfirmPassword())) {
				model.addAttribute("errMsg","Both password should be same");
			}
			  boolean status=service.resetpassword(Object);
			  if(status) {
				 
				   return "redirect:dashboard";
				     
				 }else {
				  model.addAttribute("errmsg","Password updated failed");
		}return "ResetPassword";
		}
		@GetMapping("/register")
		public String registerForm(Model model) {
			model.addAttribute("register",new RegisterForm());
			
			Map<Integer,String> countries=service.getCountries();
			model.addAttribute("countries",countries);
			
			return "registration";			
			}
		@GetMapping("/getStates")
		@ResponseBody
		public Map<Integer,String> getStates(@RequestParam("CountryId")Integer CountryId) {
			
			return service.getStates(CountryId );
			}
		@GetMapping("/getCities")
		@ResponseBody
		public Map<Integer,String> getCities(@RequestParam("StateId")Integer StateId) {
			 
			    return service.getCities(StateId);
		}
		@PostMapping("/register")
		public String registerForm(@ModelAttribute("register") RegisterForm obj,Model model) {
			Map<Integer,String> countries=service.getCountries();
			model.addAttribute("countries",countries);
			
			
			boolean status=service.saveUser(obj);
			if(status) {
				model.addAttribute("succMsg","registerd sucessfully");
			}else {
				model.addAttribute("errMsg","Registeration failed");
				     
				}  return "registration";
		}
}


