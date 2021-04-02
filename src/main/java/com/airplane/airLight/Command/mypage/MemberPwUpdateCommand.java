package com.airplane.airLight.Command.mypage;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.MyPageDAO;

public class MemberPwUpdateCommand implements Action {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		MyPageDAO dao = new MyPageDAO();
		long code = (Long) session.getAttribute("CodeMember");
		String password1 = request.getParameter("pw2");
		dao.userPwUpdate(password1, code);

	}

}
