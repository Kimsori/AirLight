package com.airplane.airLight.Command.mypage;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.MyPageDAO;

public class PayCommand implements Action{

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		MyPageDAO pdao = new MyPageDAO();
		
		int way = Integer.parseInt(request.getParameter("way"));
		long memCode = (Long) session.getAttribute("CodeMember");
		int code = Integer.parseInt(request.getParameter("code"));
		int price = Integer.parseInt(request.getParameter("price"));
		String end = request.getParameter("end");
		String splitEnd = end.substring(0, end.length()-2);
		int state = 1;
		
		if(way!=1) { // 왕복
			price = pdao.selectMaxPrice(way); // 왕복일때 총 가격 찾기
			pdao.state2(state, way); // 예매 상태 결제 완료로 바꾸기
			String endTwo = pdao.findEndPoint(way, end); // 도착지 찾기
			String splitEndTwo = endTwo.substring(0, endTwo.length()-2);
			pdao.point(memCode, (price*0.05), "왕복(" + splitEnd + ", " + splitEndTwo + ")행 티켓 발권완료"); // 마일리지 적립
			pdao.inputDay2(way); // 입금일 update
		}else { // 편도
			pdao.state(state, code); // 예매 상태 결제 완료로 바꾸기
			pdao.point(memCode, (price*0.05), splitEnd + "행 티켓 발권완료"); // 마일리지 적립
			pdao.inputDay(code); // 입금일 update
		}
		pdao.autoMoney(); // 24시간 이내에 미입금시 자동 취소
		pdao.autoMoneyToday();// 당일예매 시 출발시간-2시간 이내까지 미입금시 자동 취소
		pdao.autoRefund(); // 탑승일-5일까지만 환불 가능.
		pdao.autoPlane(); // 출발일이 되면 탑승완료.
		
	}

}
