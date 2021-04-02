package com.airplane.airLight.Command.mypage;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.MyPageDAO;
import com.airplane.airLight.dto.MemberDTO;

public class MemberUpdataCommand implements Action {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();	
		MyPageDAO dao = new MyPageDAO();
		long code = (Long) session.getAttribute("CodeMember");
		
		MemberDTO dto = new MemberDTO();		
		String birth = request.getParameter("birth1").substring(2,4)+ request.getParameter("birth2")
		+ request.getParameter("birth3");
		dto.setMember_code(code);
		dto.setFirst_name(request.getParameter("krname"));
		dto.setLast_name(request.getParameter("krname2"));
		dto.setEn_first_name(request.getParameter("engname"));
		dto.setEn_last_name(request.getParameter("engname2"));
		dto.setBirth(Integer.parseInt(birth));
		dto.setEmail(request.getParameter("email"));
		dto.setPhone(request.getParameter("phone"));
		dto.setPostCode(Integer.parseInt(request.getParameter("postCode")));
		dto.setAddr(request.getParameter("addr"));
		dto.setDetail_addr(request.getParameter("detail_addr"));
		dto.setTel(request.getParameter("tel"));
		dao.memberUpdata(dto);
		
		System.out.println("회원정보 수정 완료");
	}

}
