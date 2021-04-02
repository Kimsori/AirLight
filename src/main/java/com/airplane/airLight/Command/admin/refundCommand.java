package com.airplane.airLight.Command.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.AdminDAO;
import com.airplane.airLight.dao.MyPageDAO;
import com.airplane.airLight.dto.TicketDTO;

public class refundCommand implements Action{

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		MyPageDAO pdao = new MyPageDAO();
		AdminDAO adao = new AdminDAO();
		ArrayList<TicketDTO> ticketList = new ArrayList<TicketDTO>();
		
		//==================추가===============
				int pageTextNum =0;
				String pageNum = "";
				if(request.getParameter("pageNum") != null) {
					pageNum = request.getParameter("pageNum");
				}else {
					pageNum = "1";
				}
				
				int pageSize = 15;
				int count = 0; //전체 게시글의 갯수 
				int number = 0; 
				int currentPage = Integer.parseInt(pageNum);
				//=====================================
		
		int code = Integer.parseInt(request.getParameter("code"));
		int time = Integer.parseInt(request.getParameter("time"));
		Long member = Long.parseLong((request.getParameter("member")));
		int way = Integer.parseInt(request.getParameter("way"));
		int price = Integer.parseInt(request.getParameter("price"));
		String seat = request.getParameter("seat");
		String[] mySeat = seat.split(", ");
		String end = request.getParameter("end");
		String splitEnd = end.substring(0, end.length()-2);
		int state = 4;
		
		if(way!=1) { // 왕복이면
			pdao.state2(state, way);
			price = pdao.selectMaxPrice(way);
			String endTwo = pdao.findEndPoint(way, end);
			String splitEndTwo = endTwo.substring(0, endTwo.length()-2);
			pdao.point(member, -(price*0.05), "왕복(" + splitEnd + ", " + splitEndTwo + ")행 티켓 환불");
			
			// 왕복 가는날
			ArrayList<TicketDTO> b = new ArrayList<TicketDTO>();
			b = adao.Seat(way);
			String[] mySeat1 = b.get(0).getSeat().split(", ");
			String[] mySeat2 = b.get(1).getSeat().split(", ");
			ArrayList<TicketDTO> a = new ArrayList<TicketDTO>();
			a = pdao.findCode(way);
			adao.remainSeatUpdate(mySeat1.length, a.get(0).getTime_code()); // 비행기 남은 좌석 플러스 시키는 DAO
			for(int i=0; i<mySeat1.length; i++) {
				adao.seatUpdate(a.get(0).getTime_code(), mySeat1[i]); // 좌석 비예매 상태로 돌리기
				System.out.println(i + "번째: " + mySeat1[i]);
			}
			
			// 왕복 오는날
			adao.remainSeatUpdate(mySeat2.length, a.get(1).getTime_code()); // 비행기 남은 좌석 플러스 시키는 DAO
			for(int i=0; i<mySeat2.length; i++) {
				adao.seatUpdate(a.get(1).getTime_code(), mySeat2[i]); // 좌석 비예매 상태로 돌리기
				System.out.println(i + "번째: " + mySeat2[i]);
			}
		}else { // 편도면
			pdao.state(state, code);
			pdao.point(member, -(price*0.05), splitEnd + "행 티켓 환불");
			adao.remainSeatUpdate(mySeat.length, time); // 비행기 남은 좌석 플러스 시키는 DAO
			for(int i=0; i<mySeat.length; i++) {
				adao.seatUpdate(time, mySeat[i]); // 좌석 비예매 상태로 돌리기
				System.out.println(i + "번째: " + mySeat[i]);
			}
			adao.seatUpdate(time, seat);
		}
		
		int chkk = 0;
		
		String startDay = "";
		if(request.getParameter("startDay")!=null && request.getParameter("startDay")!="") {
			startDay = request.getParameter("startDay");
			chkk = 1;
		}
		String endDay = "";
		if(request.getParameter("endDay")!=null && request.getParameter("endDay")!="") {
			endDay = request.getParameter("endDay");
			if(chkk==1) {
				chkk = 2;
			}
		}
		int mystate = 7;
		if(request.getParameter("state")!="7" && request.getParameter("state")!=null && request.getParameter("state")!="") {
			mystate = Integer.parseInt(request.getParameter("state"));
		}
		Long mymember = 11111111111111L;
		if(request.getParameter("memberCodeIn")!=null && request.getParameter("memberCodeIn")!="") {
			mymember = Long.parseLong(request.getParameter("memberCodeIn"));
		}
		System.out.println(mymember);
		if(chkk==2) {
			if(mystate==7 && mymember==11111111111111L) {
				//===================추가======================
				count =adao.adminSearch1Count(startDay, endDay);
				number = count - (currentPage - 1)*pageSize;
				int startRow = (currentPage-1) * pageSize ;
				//============================================
				ticketList = adao.adminSearch1(startDay, endDay,startRow,pageSize);
				model.addAttribute("state", 7);
				model.addAttribute("memberIn", "11111111111111");
			}else if(mymember==11111111111111L) {
				//===================추가======================
				count =adao.adminSearch2Count(startDay, endDay, state);
				number = count - (currentPage - 1)*pageSize;
				int startRow = (currentPage-1) * pageSize ;
				//============================================
				ticketList = adao.adminSearch2(startDay, endDay, state,startRow,pageSize);
				model.addAttribute("state", state);
				model.addAttribute("memberIn", "11111111111111");
			}else if(mystate==7) {
				//===================추가======================
				count =adao.adminSearch4Count(startDay, endDay, member);
				number = count - (currentPage - 1)*pageSize;
				int startRow = (currentPage-1) * pageSize ;
				//============================================
				ticketList = adao.adminSearch4(startDay, endDay, member,startRow,pageSize);
				model.addAttribute("state", 7);
				System.out.println("memberCode: " + String.valueOf(member));
				model.addAttribute("memberIn", ""+member);
			}else {
				//===================추가======================
				count =adao.adminSearch3Count(startDay, endDay, state, member);
				number = count - (currentPage - 1)*pageSize;
				int startRow = (currentPage-1) * pageSize ;
				//============================================
				ticketList = adao.adminSearch3(startDay, endDay, state, member,startRow,pageSize);
				model.addAttribute("state", state);
				model.addAttribute("memberIn", ""+member);
			}
			model.addAttribute("startDay", startDay);
			model.addAttribute("endDay", endDay);
			
		}else {
			//===================추가======================
			count =adao.ticketAllListCount();
			number = count - (currentPage - 1)*pageSize;
			int startRow = (currentPage-1) * pageSize ;
			//============================================
			ticketList = adao.ticketAllList(startRow,pageSize);
			model.addAttribute("startDay", "");
			model.addAttribute("endDay", "");
			model.addAttribute("state", 7);
			model.addAttribute("memberIn", "11111111111111");
		}
		
		String [] first = new String[ticketList.size()];
		String [] myend = new String[ticketList.size()];
		
		for(int i = 0; i<first.length; i++) {
			first[i] = pdao.country(ticketList.get(i).getStart_point());
		}
		for(int i = 0; i<first.length; i++) {
			myend[i] = pdao.country(ticketList.get(i).getEnd_point());
		}
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		int pageCount = 0; 
		int startPage = 1;
		int endPage = 0;
		int result = 0;
		if(count > 0) {
			pageCount = count/pageSize+(count % pageSize == 0?0:1);
			result = currentPage /3;
			if(currentPage % 3 != 0) {
				startPage = result * 3+1;
			}else {
				startPage = (result -1)*3+1;
			}
			endPage = (startPage+3)-1;
			if(endPage > pageCount) {
				endPage = pageCount;
			}			
			
			if (count !=0) {
				pageTextNum = currentPage - startPage;
			}			
			
		}
		//model.addAttribute("adminNum",2);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("count",count);
		model.addAttribute("number",number);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("pageCount",pageCount);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("result",result);
		model.addAttribute("todays", sf.format(cal.getTime()));
		model.addAttribute("ticketList", ticketList);
		model.addAttribute("first", first);
		model.addAttribute("end", myend);
		model.addAttribute("pageTextNum",pageTextNum);
		
	}

}























