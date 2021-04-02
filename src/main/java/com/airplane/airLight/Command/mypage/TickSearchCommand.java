package com.airplane.airLight.Command.mypage;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.MyPageDAO;
import com.airplane.airLight.dto.TicketDTO;

public class TickSearchCommand implements Action {

	@Override
	public void execute(Model model) {
		
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		int pageTextNum =0;
		MyPageDAO pdao = new MyPageDAO();
		
		pdao.autoMoney(); // 24시간 이내에 미입금시 자동 취소
		pdao.autoMoneyToday();// 당일예매 시 출발시간-2시간 이내까지 미입금시 자동 취소
		pdao.autoRefund(); // 탑승일-5일까지만 환불 가능.
		pdao.autoPlane(); // 출발일이 되면 탑승완료.
	
		ArrayList<TicketDTO> ticketList = new ArrayList<TicketDTO>();
		
		long memCode = (Long) session.getAttribute("CodeMember");
		
		
		String pageNum = "";
		
		if(request.getParameter("pageNum") != null) {
			pageNum = request.getParameter("pageNum");
		}else {
			pageNum = "1";
		}
		int pageSize = 5;
		int count = 0; //전체 게시글의 갯수 
		int number = 0; 
		int currentPage = Integer.parseInt(pageNum);// 현재 페이지 번호 
		
		// 카운트
		count = pdao.ticketListCount(memCode);
		number = count - (currentPage - 1)*pageSize;// 해당페이지에 글이 시작하는 번호 jsp에 보여주기위한 값
		int startRow = (currentPage-1) * pageSize ; //
		
		ticketList = pdao.ticketList(memCode, startRow, pageSize); // 리미트 걸어주고 
		
		String [] first = new String[ticketList.size()];
		String [] end = new String[ticketList.size()];
		
		for(int i = 0; i<first.length; i++) {
			first[i] = pdao.country(ticketList.get(i).getStart_point());
		}
		for(int i = 0; i<first.length; i++) {
			end[i] = pdao.country(ticketList.get(i).getEnd_point());
		}
		int pageCount = 0; // 전체 페이지 넘버수 현재=>3페이지 , 한 화면에 3개씩 페이징 
		int startPage = 1; // 현재 화면에 1page이면 startPage =1 , 2page => 4 , 3page => 7
		int endPage = 0;
		int result = 0;
		
		if(count > 0) {
			//1 /5 +(1%5) >> 0+1 pagecount =1
			pageCount = count/pageSize+(count % pageSize == 0?0:1);
			result = currentPage /5;
			
			// 현제페이지 페이지가 포함된 페이징 블럭에서 
			//시작하는 페이지 블럭번호를 구하는 조건문
			if(currentPage % 5 != 0) {
				startPage = result * 5+1;
			}else {
				startPage = (result -1)*5+1;
			}
			
			//강제로  endPage의 값을 지정하는 코드
			endPage = (startPage+5)-1;
			if(endPage > pageCount) {
				endPage = pageCount;
			}
			
			
			if (count !=0) {
				pageTextNum = currentPage - startPage;
			}
		
			
			model.addAttribute("pageSize",pageSize);
			model.addAttribute("count",count);
			model.addAttribute("number",number);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("pageCount",pageCount);
			model.addAttribute("startPage",startPage);
			model.addAttribute("endPage",endPage);
			model.addAttribute("result",result);
			model.addAttribute("ticketList", ticketList);
			model.addAttribute("first", first);
			model.addAttribute("end", end);
		}
		
		model.addAttribute("pageTextNum",pageTextNum);
	}

}
