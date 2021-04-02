package com.airplane.airLight.Command.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.AdminDAO;

public class AdminReWriteCommand implements Action {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		String log = (String) session.getAttribute("log");
		if (!log.equals("������")) {
			// ��α��� ����
			System.out.println("������ �ƴ�");
		}else {
			AdminDAO dao = new AdminDAO();
			long member_code = (Long)session.getAttribute("CodeMember");
			int bcode = Integer.parseInt(request.getParameter("bcode"));
			String content = request.getParameter("content");
			int group = Integer.parseInt(request.getParameter("group"));
			
			dao.reWrite(bcode, content, group, member_code);
			model.addAttribute("message", "�亯 ��� �Ϸ�");
		}

	}

}
