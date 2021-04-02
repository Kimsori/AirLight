package com.airplane.airLight.Command.board;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.MyPageDAO;
import com.airplane.airLight.dto.BoardDTO;

public class BoardInfoCommand implements Action {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();

		// session id 이름으로 코드 ,아이디 값 어느게 들어올지 모름				
		
		int groupNum =Integer.parseInt(request.getParameter("no"));
		MyPageDAO dao = new MyPageDAO();
		long code = (Long) session.getAttribute("CodeMember");
		ArrayList<BoardDTO> list = dao.oneBoard(groupNum);
			
		model.addAttribute("state", 0);
		// 미답변 상태
		if (list.size()==1) {
			model.addAttribute("size", 1);
			model.addAttribute("list", list);

		}
		// 답변 상태
		if (list.size()==2) {
			model.addAttribute("size", 2);
			model.addAttribute("list", list);
		}
		
	}

}
