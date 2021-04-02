package com.airplane.airLight.Command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.MyPageDAO;
import com.airplane.airLight.dto.BoardDTO;

public class BoardInsertCommand implements Action{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		// session id �̸����� �ڵ� ,���̵� �� ����� ������ ��				
		MyPageDAO dao = new MyPageDAO();
		long code = (Long) session.getAttribute("CodeMember");
		
		BoardDTO dto = new BoardDTO();
		
		dto.setMember_code(code);
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dao.writeBoard(dto); // ���ۼ�
	}

}
