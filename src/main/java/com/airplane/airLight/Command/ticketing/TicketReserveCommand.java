package com.airplane.airLight.Command.ticketing;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.TicketDAO;
import com.airplane.airLight.dto.TicketDTO;

public class TicketReserveCommand implements Action{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		TicketDAO tdao = new TicketDAO();
		TicketDTO tdto = new TicketDTO();
		tdto.setMember_code(Long.parseLong(request.getParameter("member_code")));
		/*tdto.setTime_code(request.getParameter("time_code"));*/
		
	}

}


























