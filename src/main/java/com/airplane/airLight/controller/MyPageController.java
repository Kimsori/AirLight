package com.airplane.airLight.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airplane.airLight.Action;
import com.airplane.airLight.Command.board.BoardInfoCommand;
import com.airplane.airLight.Command.board.BoardInsertCommand;
import com.airplane.airLight.Command.mypage.MemberPwUpdateCommand;
import com.airplane.airLight.Command.mypage.MemberUpdataCommand;
import com.airplane.airLight.Command.mypage.MembereInfoCommand;
import com.airplane.airLight.Command.mypage.PayCommand;
import com.airplane.airLight.Command.mypage.PointCommand;
import com.airplane.airLight.Command.mypage.QnABoardCommand;
import com.airplane.airLight.Command.mypage.RefundCommand;
import com.airplane.airLight.Command.mypage.TickSearchCommand;
import com.airplane.airLight.dao.MyPageDAO;
import com.airplane.airLight.dto.BoardDTO;

@Controller
public class MyPageController {

	@Autowired
	MyPageDAO pdao;

	private Action command;

	@RequestMapping(value = "MyPage")
	public String test(Model model, HttpServletRequest request, HttpSession session) {

		String num = request.getParameter("num");
		model.addAttribute("request", request);
		
		/*
		 * String test_code ="202010280001"; long code = Long.parseLong(test_code);
		 */
		if (num.equals("0")) {
			// ���� ����
			command = new MembereInfoCommand();
			command.execute(model);

			model.addAttribute("center", "mypage/MyPageInfo.jsp");
			model.addAttribute("num", num);

		} else if (num.equals("1")) {
			// =============================�Ҹ�========================
			// ���� ����
			pdao.autoMoney(); // 24�ð� �̳��� ���Աݽ� �ڵ� ���
			pdao.autoMoneyToday();// ���Ͽ��� �� ��߽ð�-2�ð� �̳����� ���Աݽ� �ڵ� ���
			pdao.autoRefund(); // ž����-5�ϱ����� ȯ�� ����.
			pdao.autoPlane(); // ������� �Ǹ� ž�¿Ϸ�.
			
			// ���� ����
			int chk = 0;
			if (request.getParameter("chk") != null) {
				chk = Integer.parseInt(request.getParameter("chk"));
			}
			
			if (chk == 1) { // �����ϱ�
				command = new PayCommand();
				command.execute(model);
			} else if (chk == 2) { // ȯ�ҽ�û�ϱ�
				command = new RefundCommand();
				command.execute(model);
			}

			command = new TickSearchCommand();
			command.execute(model);

			model.addAttribute("center", "mypage/MyPageInfo.jsp");
			model.addAttribute("num", num);


			// =============================�Ҹ�========================
		} else if (num.equals("2")) {
			// ���ϸ��� ����
			command = new PointCommand();
			command.execute(model);
			model.addAttribute("center", "mypage/MyPageInfo.jsp");
			model.addAttribute("num", num);
		} else if (num.equals("3")) {
			// QnA����
			command = new QnABoardCommand();
			command.execute(model);
			model.addAttribute("center", "mypage/MyPageInfo.jsp");
			model.addAttribute("num", num);
		} 

		return "index";
	}
	// �� ���� ��
		@RequestMapping(value = "board" ,method = RequestMethod.GET)
		public String board(Model model, HttpServletRequest request, HttpSession session) {
			model.addAttribute("request", request);	
			model.addAttribute("center", "board/BoardWrite.jsp");
			return "index";
		}
		//�� ����
		@RequestMapping(value = "boardWrite" ,method = RequestMethod.POST)
		public String boardWrite(Model model, HttpServletRequest request, HttpSession session) {
			model.addAttribute("request", request);	
			command = new BoardInsertCommand();
			command.execute(model);
			return "redirect:MyPage?num=3";
		}
		//�� ����
		@RequestMapping(value = "boardDelete" ,method = RequestMethod.GET)
		public String boardDelete(Model model, HttpServletRequest request, HttpSession session) {
			int board_code = Integer.parseInt(request.getParameter("no"));
			
			pdao.boardDelete(board_code);
			model.addAttribute("message", "������ ���� �Ǿ����ϴ�.");
			
			return "board/msgPage";
		}
		//�� ���� ������
		@RequestMapping(value = "boardUpdate" ,method = RequestMethod.GET)
		public String boardUpdate(Model model, HttpServletRequest request, HttpSession session) {
			int board_code = Integer.parseInt(request.getParameter("no"));
			BoardDTO dto = pdao.boardSelectUpdate(board_code);
			model.addAttribute("dto", dto);
			model.addAttribute("center", "board/BoardUpdate.jsp");
			return "index";
		}
		// �ۼ���
		@RequestMapping(value = "updateBoard" ,method = RequestMethod.POST)
		public String updateBoard(Model model, HttpServletRequest request, HttpSession session) {
			int board_code = Integer.parseInt(request.getParameter("board_code")) ;
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			pdao.boardUpdate(board_code, title, content);
			model.addAttribute("message", "�ۼ��� �Ϸ� �Ǿ����ϴ�.");
			return "board/msgPage";
		}
		//�� �� ���� ����
		@RequestMapping(value = "boardInfo" ,method = RequestMethod.GET)
		public String boardinfo(Model model, HttpServletRequest request, HttpSession session) {
			model.addAttribute("request", request);	
			command = new BoardInfoCommand();
			command.execute(model);
			model.addAttribute("center", "board/boardInfo.jsp");
			return "index";
		}
		// ȸ������ ����
		@RequestMapping(value = "userUpdate" ,method = RequestMethod.POST)
		public String userUpdate(Model model, HttpServletRequest request, HttpSession session) {
			model.addAttribute("request", request);	
			command = new MemberUpdataCommand();
			command.execute(model);		
			return "redirect:MyPage?num=0";
		}
		//��й�ȣ ����
		@RequestMapping(value = "updatePw" ,method = RequestMethod.POST)
		public String pwUpdate(Model model, HttpServletRequest request, HttpSession session) {
			model.addAttribute("request", request);	
			command = new MemberPwUpdateCommand();	
			command.execute(model);
			System.out.println("��й�ȣ ����Ϸ�");
			
			
			return "redirect:MyPage?num=0";
		}
		// ȸ�� Ż��
		@RequestMapping(value = "Memberdelete" ,method = RequestMethod.POST)
		public String deleteUpdate(Model model, HttpServletRequest request, HttpSession session) {
			model.addAttribute("request", request);	
			long code = (Long) session.getAttribute("CodeMember");
			pdao = new MyPageDAO();
			pdao.userDelete(code);
			session.setAttribute("log", "�մ�");
			session.setAttribute("msg", "ȸ�� Ż�� �Ǿ����ϴ�");
			session.removeAttribute("id");
			session.setAttribute("CodeMember", 1111111111111L);
			model.addAttribute("center", "member/loginfail.jsp");
			return "index";
		}

}
