package com.airplane.airLight.Command.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.AdminDAO;
import com.airplane.airLight.dao.MyPageDAO;
import com.airplane.airLight.dto.TicketDTO;

public class AllTicketCommand implements Action {

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
		// int pageTextNum =0;
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
		
		int chk = 0;
		
		String startDay = "";
		if(request.getParameter("startDay")!=null && request.getParameter("startDay")!="") {
			startDay = request.getParameter("startDay");
			chk = 1;
		}
		String endDay = "";
		if(request.getParameter("endDay")!=null && request.getParameter("endDay")!="") {
			endDay = request.getParameter("endDay");
			if(chk==1) {
				chk = 2;
			}
		}
		int state = 7;
		if(request.getParameter("state")!="7" && request.getParameter("state")!=null && request.getParameter("state")!="") {
			state = Integer.parseInt(request.getParameter("state"));
		}
		Long member = 11111111111111L;
		if(request.getParameter("memberCodeIn")!=null && request.getParameter("memberCodeIn")!="") {
			member = Long.parseLong(request.getParameter("memberCodeIn"));
		}
		System.out.println(member);
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
		
		String [] first = new String[ticketList.size()];
		String [] end = new String[ticketList.size()];
		
		for(int i = 0; i<first.length; i++) {
			first[i] = pdao.country(ticketList.get(i).getStart_point());
		}
		for(int i = 0; i<first.length; i++) {
			end[i] = pdao.country(ticketList.get(i).getEnd_point());
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
		model.addAttribute("adminNum",0);
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
		model.addAttribute("end", end);
		model.addAttribute("pageTextNum",pageTextNum);
		
		
	}

}
