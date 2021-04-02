package com.airplane.airLight.Command.mypage;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.MyPageDAO;
import com.airplane.airLight.dto.PointDTO;

public class PointCommand implements Action {

	@Override
	public void execute(Model model) {
		
		

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		ArrayList<PointDTO> pdto = new ArrayList<PointDTO>();
		HttpSession session = request.getSession();
		int pageTextNum =0;
				
		MyPageDAO dao = new MyPageDAO();
		long code = (Long) session.getAttribute("CodeMember");
		
		String pageNum = "";
		
		if(request.getParameter("pageNum") != null) {
			pageNum = request.getParameter("pageNum");
		}else {
			pageNum = "1";
		}
		int pageSize = 5;
		int count = 0; //전체 게시글의 갯수 
		int number = 0; // 게시판 최신글 작성 순서로 번호 누적 30,29,28 ~~
		int currentPage = Integer.parseInt(pageNum);// 현재 페이지 번호 
		
		count = dao.memberPointCount(code);// 포인트 테이블 카운트
		number = count - (currentPage - 1)*pageSize;// 해당페이지에 글이 시작하는 번호 jsp에 보여주기위한 값
		int startRow = (currentPage-1) * pageSize ; //
		
		pdto = dao.memberPoint(code,startRow,pageSize); // 포인트 페이징 추출
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
			// 로그인 회원 총포인트 추출
			int totalPonit = dao.memberTotalPoint(code);
			
			
			if (count !=0) {
				pageTextNum = currentPage - startPage;
			} 
			model.addAttribute("total", totalPonit);
		}

		
		model.addAttribute("pdto",pdto);
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
