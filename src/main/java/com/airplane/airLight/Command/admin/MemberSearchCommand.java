package com.airplane.airLight.Command.admin;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.AdminDAO;
import com.airplane.airLight.dto.MemberDTO;

public class MemberSearchCommand implements Action {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		String log = (String) session.getAttribute("log");
		int pageTextNum =0;
		int membar_state =3;
		String startDay ="";
		String endDay="";
		String id="";
		if (!log.equals("관리자")) {
			// 비로그인 상태
			System.out.println("관리자 아님");
		}else {
			// 로그인 상태
			AdminDAO dao = new AdminDAO();
			ArrayList<MemberDTO> userList = new ArrayList<MemberDTO>();
			String pageNum = "";
			
			if (request.getParameter("startDay") != null) {
				startDay = request.getParameter("startDay");
			}
			if (request.getParameter("endDay") != null) {
				endDay = request.getParameter("endDay");
			}
			if (request.getParameter("id") != null) {
				id = request.getParameter("id");
			}
			if (request.getParameter("membar_state") != null) {
				membar_state = Integer.parseInt(request.getParameter("membar_state"));
			}
			model.addAttribute("startDay", startDay);
			model.addAttribute("endDay", endDay);
			model.addAttribute("state", membar_state);
			
			if(request.getParameter("pageNum") != null) {
				pageNum = request.getParameter("pageNum");
			}else {
				pageNum = "1";
			}
			
			int pageSize =15;
			
			int count = 0; //전체 게시글의 갯수 
			int number = 0; // 게시판 최신글 작성 순서로 번호 누적 30,29,28 ~~
			int currentPage = Integer.parseInt(pageNum);// 현재 페이지 번호 
			
			// 조건에 맞는 회원수 출력
			//날짜 없고 id 없고 전체 회원 상태
			if (startDay.equals("")&&endDay.equals("")&&membar_state == 3&&id.equals("")) {
				String addsql ="where membar_state=0 or membar_state=1";
				count = dao.memberAllcount(addsql);
				//날짜 있고, 전체 회원 상태 , 아이디 없고
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 3&&id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and (membar_state = 0 or membar_state= 1)";
				count = dao.memberAllcount(addsql);
				//날짜 있고, 탈퇴 회원 , 아이디 없고
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 1&&id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and membar_state= 1";
				count = dao.memberAllcount(addsql);
				//날짜 있고, 정상 회원 , 아이디 없고
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 0&&id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and membar_state= 0";
				count = dao.memberAllcount(addsql);
				//날짜 있고, 탈퇴 회원 , 아이디 있고
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 1&&!id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and membar_state= 1 and id='"+id+"'";
				count = dao.memberAllcount(addsql);
				//날짜 없고, 정상 회원 , 아이디 있고
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 0&&!id.equals("")) {
				String addsql ="where membar_state= 0 and id='"+id+"'";
				count = dao.memberAllcount(addsql);
				//날짜 있고, 정상 회원 , 아이디 있고
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 0&&!id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and membar_state= 0 and id='"+id+"'";
				count = dao.memberAllcount(addsql);
				//날짜 없고, 탈퇴 회원 , 아이디 없고
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 1&&id.equals("")) {
				String addsql ="where membar_state= 1 ";
				count = dao.memberAllcount(addsql);
				//날짜 없고, 정상 회원 , 아이디 없고
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 0&&id.equals("")) {
				String addsql ="where membar_state= 0 ";
				count = dao.memberAllcount(addsql);
				//날짜 없고, 전체 회원 , 아이디 있고
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 3&&!id.equals("")) {
				String addsql ="where (membar_state = 0 or membar_state= 1) and id='"+id+"'";
				count = dao.memberAllcount(addsql);
				//날짜 없고, 탈퇴회원 , 아이디 있고
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 1&&!id.equals("")) {
				String addsql ="where membar_state= 1 and id='"+id+"'";
				count = dao.memberAllcount(addsql);
				//날짜 있고, 전체회원 , 아이디 있고
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 3&&!id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and (membar_state = 0 or membar_state= 1) and id='"+id+"'";
				count = dao.memberAllcount(addsql);
			}
			
			// 해당페이지에 글이 시작하는 번호 jsp에 보여주기위한 값
			number = count - (currentPage - 1) * pageSize;
			int startRow = (currentPage-1) * pageSize ; 
			
			// 조건에 맞는 회원 추출
			//날짜 없고 id 없고 전체 회원 상태
			if (startDay.equals("")&&endDay.equals("")&&membar_state == 3&&id.equals("")) {
				String addsql="where membar_state = 0 or membar_state= 1";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//날짜 있고, 전체 회원 상태 , 아이디 없고
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 3&&id.equals("")) {
				String addsql="where joindate >= '"+startDay+"' and  joindate <= '"+endDay+"'and (membar_state = 0 or membar_state= 1)";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//날짜 있고, 탈퇴 회원 , 아이디 없고
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 1&&id.equals("")) {
				String addsql="where joindate >= '"+startDay+"' and  joindate <= '"+endDay+"'and membar_state = 1 ";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//날짜 있고, 정상 회원 , 아이디 없고
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 0&&id.equals("")) {
				String addsql="where joindate >= '"+startDay+"' and  joindate <= '"+endDay+"'and membar_state= 0 ";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//날짜 있고, 탈퇴 회원 , 아이디 있고
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 1&&!id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and membar_state= 1 and id='"+id+"'";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//날짜 없고, 정상 회원 , 아이디 있고
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 0&&!id.equals("")) {
				String addsql ="where membar_state= 0 and id='"+id+"'";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//날짜 있고, 정상 회원 , 아이디 있고
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 0&&!id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and membar_state= 0 and id='"+id+"'";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//날짜 없고, 탈퇴 회원 , 아이디 없고
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 1&&id.equals("")) {
				String addsql ="where  membar_state= 1 ";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//날짜 없고, 정상 회원 , 아이디 없고
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 0&&id.equals("")) {
				String addsql ="where  membar_state= 0 ";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//날짜 없고, 전체 회원 , 아이디 있고
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 3&&!id.equals("")) {
				String addsql ="where (membar_state = 0 or membar_state= 1) and id='"+id+"'";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//날짜 없고, 탈퇴회원 , 아이디 있고
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 1&&!id.equals("")) {
				String addsql ="where membar_state= 1 and id='"+id+"'";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//날짜 있고, 전체회원 , 아이디 있고
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 3&&!id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and (membar_state = 0 or membar_state= 1) and id='"+id+"'";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
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
			model.addAttribute("list",userList);
			model.addAttribute("pageSize",pageSize);
			model.addAttribute("count",count);
			model.addAttribute("number",number);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("pageCount",pageCount);
			model.addAttribute("startPage",startPage);
			model.addAttribute("endPage",endPage);
			model.addAttribute("result",result);
			model.addAttribute("pageTextNum",pageTextNum);
			
		}
	}
	}


