package com.airplane.airLight.Command.ticketing;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.TicketDAO;
import com.airplane.airLight.dto.TicketDTO;

public class TicketCommand implements Action{

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		TicketDAO tdao = new TicketDAO();
		ArrayList<TicketDTO> countryList = tdao.CountryList();
		ArrayList<TicketDTO> planeList = tdao.planeList();
		tdao.insertInfo();
		
		model.addAttribute("countryList", countryList);
		model.addAttribute("planeList", planeList);
		
	}

}
