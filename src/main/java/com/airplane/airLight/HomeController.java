package com.airplane.airLight;

import java.lang.annotation.Repeatable;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airplane.airLight.Command.ticketing.TicketCommand;
import com.airplane.airLight.dao.TicketDAO;


@Controller
public class HomeController {
	
	@Autowired
	TicketDAO tdao;
	
	private Action command;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpSession Session) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Session.setAttribute("CodeMember", 1111111111111L);
		Session.setAttribute("log", "¼Õ´Ô");
		command = new TicketCommand();
		command.execute(model);
		
		model.addAttribute("center", "main/ticketing.jsp");
		
		return "index";
	}
	

}




















