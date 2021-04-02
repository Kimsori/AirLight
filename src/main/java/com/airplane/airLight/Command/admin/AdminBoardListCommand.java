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
		int state =2; // �⺻�� ��ü
		String startDay =""; 
		String endDay="";
		int pageTextNum =0;
		if (!log.equals("������")) {
			// ��α��� ����
			System.out.println("������ �ƴ�");
		} else {
			AdminDAO dao = new AdminDAO();
			ArrayList<AdminBoardDTO> boardList = new ArrayList<AdminBoardDTO>();
			String pageNum = "";
			// ��ǲ�� 
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
			// ����¡ ȭ��
			if(request.getParameter("pageNum") != null) {
				pageNum = request.getParameter("pageNum");
			}else {
				pageNum = "1";
			}
			int pageSize =15;
			int count = 0; //��ü �Խñ��� ���� 
			int number = 0; // �Խ��� �ֽű� �ۼ� ������ ��ȣ ���� 30,29,28 ~~
			int currentPage = Integer.parseInt(pageNum);// ���� ������ ��ȣ 
			
			if (startDay.equals("")&&endDay.equals("")&&state==2) {
				//��¥�� ���� ��ü
				String addsql ="where re_level = 1 ";
				count = dao.boardAllcount(addsql);
				System.out.println("�Խñ� ī��Ʈ:"+count);
			}else if (startDay.equals("")&&endDay.equals("")&&state==0) {
				//��¥�� ���� �̴亯
				String addsql ="where re_level = 1 and re_state = 0";
				count = dao.boardAllcount(addsql);
				System.out.println("�Խñ� ī��Ʈ:"+count);
			}else if (startDay.equals("")&&endDay.equals("")&&state==1) {
				//��¥�� ���� �亯�Ϸ�
				String addsql ="where re_level = 1 and re_state = 1";
				count = dao.boardAllcount(addsql);
				System.out.println("�Խñ� ī��Ʈ:"+count);
			}else if (!startDay.equals("")&&!endDay.equals("")&&state==2) {
				//��¥�� �ְ� ��ü
				String addsql ="where write_date >='"+ startDay+"'and write_date <='"+endDay+"' and re_level = 1";
				count = dao.boardAllcount(addsql);
				System.out.println("�Խñ� ī��Ʈ:"+count);
			}else if (!startDay.equals("")&&!endDay.equals("")&&state==0) {
				//��¥�� �ְ� �ܺ��Ϸ�
				String addsql ="where write_date >='"+ startDay+"'and write_date <='"+endDay+"' and re_level = 1 and re_state = 0";
				count = dao.boardAllcount(addsql);
				System.out.println("�Խñ� ī��Ʈ:"+count);
			}else if (!startDay.equals("")&&!endDay.equals("")&&state==1) {
				//��¥�� �ְ� �̴亯
				String addsql ="where write_date >='"+ startDay+"'and write_date <='"+endDay+"' and re_level = 1 and re_state = 1";
				count = dao.boardAllcount(addsql);
				System.out.println("�Խñ� ī��Ʈ:"+count);
			}
			
			// �ش��������� ���� �����ϴ� ��ȣ jsp�� �����ֱ����� ��
				
			number = count - (currentPage - 1) * pageSize;
			System.out.println("���� ��ȣ"+number);
			int startRow = (currentPage-1) * pageSize ; 

			if (startDay.equals("") && endDay.equals("") && state == 2) {
				// ��¥�� ���� ��ü
				String addsql ="and re_level = 1 ";
				boardList = dao.boardAllSelect(addsql, startRow, pageSize);
			} else if (startDay.equals("") && endDay.equals("") && state == 0) {
				// ��¥�� ���� �̴亯
				String addsql ="and re_level = 1 and re_state = 0";
				boardList = dao.boardAllSelect(addsql, startRow, pageSize);
			} else if (startDay.equals("") && endDay.equals("") && state == 1) {
				// ��¥�� ���� �亯�Ϸ�
				String addsql ="and re_level = 1 and re_state = 1";
				boardList = dao.boardAllSelect(addsql, startRow, pageSize);
			} else if (!startDay.equals("") && !endDay.equals("") && state == 2) {
				// ��¥�� �ְ� ��ü
				String addsql ="and write_date >='"+ startDay+"'and write_date <='"+endDay+"' and re_level = 1";
				boardList = dao.boardAllSelect(addsql, startRow, pageSize);
			} else if (!startDay.equals("") && !endDay.equals("") && state == 0) {
				// ��¥�� �ְ� �ܺ��Ϸ�
				String addsql ="and write_date >='"+ startDay+"'and write_date <='"+endDay+"' and re_level = 1 and re_state = 0";
				boardList = dao.boardAllSelect(addsql, startRow, pageSize);
			} else if (!startDay.equals("") && !endDay.equals("") && state == 1) {
				// ��¥�� �ְ� �̴亯
				String addsql ="and write_date >='"+ startDay+"'and write_date <='"+endDay+"' and re_level = 1 and re_state = 1";
				boardList = dao.boardAllSelect(addsql, startRow, pageSize);
			}
			int pageCount = 0; // ��ü ������ �ѹ��� ����=>3������ , �� ȭ�鿡 3���� ����¡ 
			int startPage = 1; // ���� ȭ�鿡 1page�̸� startPage =1 , 2page => 4 , 3page => 7
			int endPage = 0;
			int result = 0;
			
			if(count > 0) {
				//1 /5 +(1%5) >> 0+1 pagecount =1
				pageCount = count/pageSize+(count % pageSize == 0?0:1);
				result = currentPage /3;
				// ���������� �������� ���Ե� ����¡ ������ 
				//�����ϴ� ������ ����ȣ�� ���ϴ� ���ǹ�
				if(currentPage % 3 != 0) {
					startPage = result * 3+1;
				}else {
					startPage = (result -1)*3+1;
				}
				//������  endPage�� ���� �����ϴ� �ڵ�
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
