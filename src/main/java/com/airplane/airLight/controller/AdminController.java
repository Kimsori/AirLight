package com.airplane.airLight.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airplane.airLight.Action;
import com.airplane.airLight.Command.admin.AdminBoardListCommand;
import com.airplane.airLight.Command.admin.AdminReWriteCommand;
import com.airplane.airLight.Command.admin.AdminReWriteSelectCommand;
import com.airplane.airLight.Command.admin.AllTicketCommand;
import com.airplane.airLight.Command.admin.MemberSearchCommand;
import com.airplane.airLight.Command.admin.refundCommand;
import com.airplane.airLight.Command.admin.searchCommand;
import com.airplane.airLight.dao.AdminDAO;
import com.airplane.airLight.dao.MyPageDAO;
import com.airplane.airLight.dto.TicketDTO;

@Controller
public class AdminController {
	
	@Autowired
	MyPageDAO pdao;
	
	@Autowired
	AdminDAO adao;
	
	private Action command;
	
	@RequestMapping(value = "AdminPage", method = {RequestMethod.GET,RequestMethod.POST})
	public String admin(Model model, HttpServletRequest request, HttpSession session) {

		String num = request.getParameter("num");
		model.addAttribute("request", request);

		if (num.equals("0")) {
			
			// ======================소리 시작 ==========================
			
			pdao.autoMoney(); // 24시간 이내에 미입금시 자동 취소
			pdao.autoRefund(); // 탑승일-5일까지만 환불 가능.
			pdao.autoPlane(); // 출발일이 되면 탑승완료.
			pdao.autoMoneyToday();// 당일예매 시 출빌시간-2시간 이내까지 미입금시 자동 취소
			
			int chk = 0;
			if(request.getParameter("chk")!=null) {
				chk = Integer.parseInt(request.getParameter("chk"));
			}
			
			int adminNum = 0;
			if(request.getParameter("adminNum")!=null) {
				adminNum = Integer.parseInt(request.getParameter("adminNum"));
			}
			
			if(adminNum==0) { // 검색을 하지 않았을때
				if(chk==1) { // 환불 버튼 클릭
					command = new refundCommand();
					command.execute(model);
				}else {
					command = new AllTicketCommand();
					command.execute(model);
				}
			}else { // 검색을 했을때
				command = new searchCommand();
				command.execute(model);
			}
			
			model.addAttribute("center", "admin/adminPage.jsp");
			model.addAttribute("num", num);
			// ======================소리 끝 ==========================
		} else if (num.equals("1")) {
			command = new MemberSearchCommand();
			command.execute(model);			
			model.addAttribute("center", "admin/adminPage.jsp");
			model.addAttribute("num", num);
		} else if (num.equals("2")) {
			command = new AdminBoardListCommand();
			command.execute(model);
			model.addAttribute("center", "admin/adminPage.jsp");
			model.addAttribute("num", num);
		}

		return "index";
	}
	
	@RequestMapping(value = "ReWriteForm", method = RequestMethod.GET)
	public String adminReWrite(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("request", request);
		command = new AdminReWriteSelectCommand();
		command.execute(model);
		model.addAttribute("center", "board/ReWriteForm.jsp");
		return "index";
	}
	@RequestMapping(value = "ReWrite", method = RequestMethod.POST)
	public String ReWrite(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("request", request);
		command = new AdminReWriteCommand();
		command.execute(model);
		return "board/adminMsgPage";
	}
	//202010280001 
	@RequestMapping(value = "updateMember", method = RequestMethod.GET)
	public String UpdateMember(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("request", request);
		long code = Long.parseLong(request.getParameter("code"));
		adao.adminUpdateMember(code);
		model.addAttribute("UpdateMemberMsg", "정상회원으로 변경완료");
		return "admin/memberUpdateMsg";
	}

}
