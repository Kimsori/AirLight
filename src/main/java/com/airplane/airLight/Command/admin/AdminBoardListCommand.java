package com.airplane.airLight.Command.admin;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.AdminDAO;
import com.airplane.airLight.dto.AdminBoardDTO;
import com.airplane.airLight.dto.BoardDTO;

public class AdminBoardListCommand implements Action {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		String log = (String) session.getAttribute("log");
		int state =2; // 기본값 전체
		String startDay =""; 
		String endDay="";
		int pageTextNum =0;
		if (!log.equals("관리자")) {
			// 비로그인 상태
			System.out.println("관리자 아님");
		} else {
			AdminDAO dao = new AdminDAO();
			ArrayList<AdminBoardDTO> boardList = new ArrayList<AdminBoardDTO>();
			String pageNum = "";
			// 인풋값 
			if (request.getParameter("startDay") != null) {
				startDay = request.getParameter("startDay");
			}
			if (request.getParameter("endDay") != null) {
				endDay = request.getParameter("endDay");
			}
			if (request.getParameter("state") != null) {
				state = Integer.parseInt(request.getParameter("state"));
			}
			model.addAttribute("startDay", startDay);
			model.addAttribute("endDay", endDay);
			model.addAttribute("state", state);
			// 페이징 화면
			if(request.getParameter("pageNum") != null) {
				pageNum = request.getParameter("pageNum");
			}else {
				pageNum = "1";
			}
			int pageSize =15;
			int count = 0; //전체 게시글의 갯수 
			int number = 0; // 게시판 최신글 작성 순서로 번호 누적 30,29,28 ~~
			int currentPage = Integer.parseInt(pageNum);// 현재 페이지 번호 
			
			if (startDay.equals("")&&endDay.equals("")&&state==2) {
				//날짜가 없고 전체
				String addsql ="where re_level = 1 ";
				count = dao.boardAllcount(addsql);
				System.out.println("게시글 카운트:"+count);
			}else if (startDay.equals("")&&endDay.equals("")&&state==0) {
				//날짜가 없고 미답변
				String addsql ="where re_level = 1 and re_state = 0";
				count = dao.boardAllcount(addsql);
				System.out.println("게시글 카운트:"+count);
			}else if (startDay.equals("")&&endDay.equals("")&&state==1) {
				//날짜가 없고 답변완료
				String addsql ="where re_level = 1 and re_state = 1";
				count = dao.boardAllcount(addsql);
				System.out.println("게시글 카운트:"+count);
			}else if (!startDay.equals("")&&!endDay.equals("")&&state==2) {
				//날짜가 있고 전체
				String addsql ="where write_date >='"+ startDay+"'and write_date <='"+endDay+"' and re_level = 1";
				count = dao.boardAllcount(addsql);
				System.out.println("게시글 카운트:"+count);
			}else if (!startDay.equals("")&&!endDay.equals("")&&state==0) {
				//날짜가 있고 단변완료
				String addsql ="where write_date >='"+ startDay+"'and write_date <='"+endDay+"' and re_level = 1 and re_state = 0";
				count = dao.boardAllcount(addsql);
				System.out.println("게시글 카운트:"+count);
			}else if (!startDay.equals("")&&!endDay.equals("")&&state==1) {
				//날짜가 있고 미답변
				String addsql ="where write_date >='"+ startDay+"'and write_date <='"+endDay+"' and re_level = 1 and re_state = 1";
				count = dao.boardAllcount(addsql);
				System.out.println("게시글 카운트:"+count);
			}
			
			// 해당페이지에 글이 시작하는 번호 jsp에 보여주기위한 값
				
			number = count - (currentPage - 1) * pageSize;
			System.out.println("계산된 번호"+number);
			int startRow = (currentPage-1) * pageSize ; 

			if (startDay.equals("") && endDay.equals("") && state == 2) {
				// 날짜가 없고 전체
				String addsql ="and re_level = 1 ";
				boardList = dao.boardAllSelect(addsql, startRow, pageSize);
			} else if (startDay.equals("") && endDay.equals("") && state == 0) {
				// 날짜가 없고 미답변
				String addsql ="and re_level = 1 and re_state = 0";
				boardList = dao.boardAllSelect(addsql, startRow, pageSize);
			} else if (startDay.equals("") && endDay.equals("") && state == 1) {
				// 날짜가 없고 답변완료
				String addsql ="and re_level = 1 and re_state = 1";
				boardList = dao.boardAllSelect(addsql, startRow, pageSize);
			} else if (!startDay.equals("") && !endDay.equals("") && state == 2) {
				// 날짜가 있고 전체
				String addsql ="and write_date >='"+ startDay+"'and write_date <='"+endDay+"' and re_level = 1";
				boardList = dao.boardAllSelect(addsql, startRow, pageSize);
			} else if (!startDay.equals("") && !endDay.equals("") && state == 0) {
				// 날짜가 있고 단변완료
				String addsql ="and write_date >='"+ startDay+"'and write_date <='"+endDay+"' and re_level = 1 and re_state = 0";
				boardList = dao.boardAllSelect(addsql, startRow, pageSize);
			} else if (!startDay.equals("") && !endDay.equals("") && state == 1) {
				// 날짜가 있고 미답변
				String addsql ="and write_date >='"+ startDay+"'and write_date <='"+endDay+"' and re_level = 1 and re_state = 1";
				boardList = dao.boardAllSelect(addsql, startRow, pageSize);
			}
			int pageCount = 0; // 전체 페이지 넘버수 현재=>3페이지 , 한 화면에 3개씩 페이징 
			int startPage = 1; // 현재 화면에 1page이면 startPage =1 , 2page => 4 , 3page => 7
			int endPage = 0;
			int result = 0;
			
			if(count > 0) {
				//1 /5 +(1%5) >> 0+1 pagecount =1
				pageCount = count/pageSize+(count % pageSize == 0?0:1);
				result = currentPage /3;
				// 현제페이지 페이지가 포함된 페이징 블럭에서 
				//시작하는 페이지 블럭번호를 구하는 조건문
				if(currentPage % 3 != 0) {
					startPage = result * 3+1;
				}else {
					startPage = (result -1)*3+1;
				}
				//강제로  endPage의 값을 지정하는 코드
				endPage = (startPage+3)-1;
				if(endPage > pageCount) {
					endPage = pageCount;
				}
				if (count !=0) {
					pageTextNum = currentPage - startPage;
				} 
			}
			model.addAttribute("pageTextNum",pageTextNum);
			model.addAttribute("alist",boardList);
			model.addAttribute("pageSize",pageSize);
			model.addAttribute("count",count);
			model.addAttribute("number1",number);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("pageCount",pageCount);
			model.addAttribute("startPage",startPage);
			model.addAttribute("endPage",endPage);
			model.addAttribute("result",result);
		}
	}

}
