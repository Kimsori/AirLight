package com.airplane.airLight.Command.mypage;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.MyPageDAO;
import com.airplane.airLight.dto.MemberDTO;

public class MembereInfoCommand implements Action {
// 마이페이지 커맨드
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		long codeMember = (Long) session.getAttribute("CodeMember");
		if (codeMember == 1111111111L) {
			
		}else {
			
			MyPageDAO dao = new MyPageDAO();
			MemberDTO dto = dao.memberInfo(codeMember);
			
			String birt =  Integer.toString(dto.getBirth());
			String birt1=""; //년
			String birt2="";//월
			String birt3=""; //일
			int b1 =0;		
			if (birt.length() ==3) { // 3글자 
				birt1 = "2000";
				birt2 = "0"+birt.substring(0, 1);
				birt3 = birt.substring(1, 3);
			} else if (birt.length() ==4) { // 4글자
				birt1 = "2000";
				birt2 = birt.substring(0, 2);
				birt3 = birt.substring(2, 4);
			} else if (birt.length() ==5) { // 5글자
				birt1 = "200"+Integer.parseInt(birt.substring(0, 1));
				birt2 = birt.substring(1, 3);
				birt3 = birt.substring(3, 5);
			} else { // 6글자
				b1 = Integer.parseInt(birt.substring(0, 2));
				if (b1 >= 30) {
					birt1 = "19" + b1;
				} else {
					birt1 = "20" + b1;
				}
				birt2 = birt.substring(2, 4);
				birt3 = birt.substring(4, 6);
			}
			
			String postCode= "";
			if (dto.getPostCode() <= 9999) {
				postCode ="0"+dto.getPostCode();
			} else {
				postCode = ""+dto.getPostCode();
			}
			model.addAttribute("pageTextNum",0);
			model.addAttribute("birt1", birt1);
			model.addAttribute("birt2", birt2);
			model.addAttribute("birt3", birt3);
			model.addAttribute("dto", dto);
			model.addAttribute("postCode", postCode);
		}
		
		
		

	}

}
