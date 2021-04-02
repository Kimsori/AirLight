package com.airplane.airLight.Command.mypage;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.MyPageDAO;

public class RefundCommand implements Action{

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		MyPageDAO pdao = new MyPageDAO();
		
		int way = Integer.parseInt(request.getParameter("way"));
		int code = Integer.parseInt(request.getParameter("code"));
		int state = 3;
		
		if(way!=1) { // 왕복
			pdao.state2(state, way); // 예매상태 환불 신청중으로
		}else { // 편도
			pdao.state(state, code); // 예매상태 환불 신청중으로
		}
		pdao.autoMoney(); // 24시간 이내에 미입금시 자동 취소
		pdao.autoMoneyToday();// 당일예매 시 출발시간-2시간 이내까지 미입금시 자동 취소
		pdao.autoRefund(); // 탑승일-5일까지만 환불 가능.
		pdao.autoPlane(); // 출발일이 되면 탑승완료.
		
	}

}
