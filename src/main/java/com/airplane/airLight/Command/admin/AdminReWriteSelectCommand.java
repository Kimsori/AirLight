package com.airplane.airLight.Command.admin;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.AdminDAO;
import com.airplane.airLight.dto.AdminBoardDTO;

public class AdminReWriteSelectCommand implements Action {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		String log = (String) session.getAttribute("log");
		if (!log.equals("관리자")) {
			// 비로그인 상태
			System.out.println("관리자 아님");
		}else {
			AdminDAO dao = new AdminDAO();
			 
			int bcode =Integer.parseInt(request.getParameter("no"));
			ArrayList<AdminBoardDTO> list = dao.reWriteSelect(bcode);
			
			
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
			
			
		}
		
	}

}
