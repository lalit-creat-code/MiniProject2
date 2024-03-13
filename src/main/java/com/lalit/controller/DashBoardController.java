package com.lalit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lalit.services.DashBoardImpl;
@Controller
public class DashBoardController {
	@Autowired
	private DashBoardImpl service;
	@GetMapping("/dashboard")
	public String getDashBoard(Model model) {
		String quote=service.getQoute();
		model.addAttribute("Quote",quote);
		return"dashBoard";
	}

}
