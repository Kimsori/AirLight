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

public class searchCommand implements Action{

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		MyPageDAO pdao = new MyPageDAO();
		AdminDAO adao = new AdminDAO();
		
		pdao.autoMoney(); // 24시간 이내에 미입금시 자동 취소
		pdao.autoRefund(); // 탑승일-5일까지만 환불 가능.
		pdao.autoPlane(); // 출발일이 되면 탑승완료.
		pdao.autoMoneyToday();// 당일예매 시 출빌시간-2시간 이내까지 미입금시 자동 취소
		
		String startDay = request.getParameter("startDay");
		String endDay = request.getParameter("endDay");
		int state = Integer.parseInt(request.getParameter("state"));
		Long member = 11111111111111L;
		if(request.getParameter("memberCodeIn")!=null && request.getParameter("memberCodeIn")!="") {
			member = Long.parseLong(request.getParameter("memberCodeIn"));
		}
		
		ArrayList<TicketDTO> ticketList = new ArrayList<TicketDTO>();
		//==================추가===============
		String pageNum = "";
		 int pageTextNum =0;
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
		if(state==7 && member==11111111111111L) {
			
			//===================추가======================
			count =adao.adminSearch1Count(startDay, endDay);
			number = count - (currentPage - 1)*pageSize;
			int startRow = (currentPage-1) * pageSize ;
			//============================================
			ticketList = adao.adminSearch1(startDay, endDay,startRow,pageSize);
			model.addAttribute("state", 7);
			model.addAttribute("memberIn", "11111111111111");
		}else if(member==11111111111111L) {
			//===================추가======================
			count =adao.adminSearch2Count(startDay, endDay, state);
			number = count - (currentPage - 1)*pageSize;
			int startRow = (currentPage-1) * pageSize ;
			//============================================
			ticketList = adao.adminSearch2(startDay, endDay, state,startRow,pageSize);
			model.addAttribute("state", state);
			model.addAttribute("memberIn", "11111111111111");
		}else if(state==7) {
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
		
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String [] first = new String[ticketList.size()];
		String [] end = new String[ticketList.size()];
		
		for(int i = 0; i<first.length; i++) {
			first[i] = pdao.country(ticketList.get(i).getStart_point());
		}
		for(int i = 0; i<first.length; i++) {
			end[i] = pdao.country(ticketList.get(i).getEnd_point());
		}
		//==============================추가====================
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
		//===============================================================
		model.addAttribute("adminNum",2);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("count",count);
		model.addAttribute("number",number);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("pageCount",pageCount);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("result",result);		
		model.addAttribute("ticketList", ticketList);
		model.addAttribute("todays", sf.format(cal.getTime()));
		model.addAttribute("first", first);
		model.addAttribute("end", end);
		model.addAttribute("pageTextNum",pageTextNum);
		
		
	}

}
