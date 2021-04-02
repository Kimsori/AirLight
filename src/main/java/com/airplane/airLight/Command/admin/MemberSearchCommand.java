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
		if (!log.equals("������")) {
			// ��α��� ����
			System.out.println("������ �ƴ�");
		}else {
			// �α��� ����
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
			
			int count = 0; //��ü �Խñ��� ���� 
			int number = 0; // �Խ��� �ֽű� �ۼ� ������ ��ȣ ���� 30,29,28 ~~
			int currentPage = Integer.parseInt(pageNum);// ���� ������ ��ȣ 
			
			// ���ǿ� �´� ȸ���� ���
			//��¥ ���� id ���� ��ü ȸ�� ����
			if (startDay.equals("")&&endDay.equals("")&&membar_state == 3&&id.equals("")) {
				String addsql ="where membar_state=0 or membar_state=1";
				count = dao.memberAllcount(addsql);
				//��¥ �ְ�, ��ü ȸ�� ���� , ���̵� ����
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 3&&id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and (membar_state = 0 or membar_state= 1)";
				count = dao.memberAllcount(addsql);
				//��¥ �ְ�, Ż�� ȸ�� , ���̵� ����
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 1&&id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and membar_state= 1";
				count = dao.memberAllcount(addsql);
				//��¥ �ְ�, ���� ȸ�� , ���̵� ����
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 0&&id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and membar_state= 0";
				count = dao.memberAllcount(addsql);
				//��¥ �ְ�, Ż�� ȸ�� , ���̵� �ְ�
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 1&&!id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and membar_state= 1 and id='"+id+"'";
				count = dao.memberAllcount(addsql);
				//��¥ ����, ���� ȸ�� , ���̵� �ְ�
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 0&&!id.equals("")) {
				String addsql ="where membar_state= 0 and id='"+id+"'";
				count = dao.memberAllcount(addsql);
				//��¥ �ְ�, ���� ȸ�� , ���̵� �ְ�
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 0&&!id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and membar_state= 0 and id='"+id+"'";
				count = dao.memberAllcount(addsql);
				//��¥ ����, Ż�� ȸ�� , ���̵� ����
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 1&&id.equals("")) {
				String addsql ="where membar_state= 1 ";
				count = dao.memberAllcount(addsql);
				//��¥ ����, ���� ȸ�� , ���̵� ����
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 0&&id.equals("")) {
				String addsql ="where membar_state= 0 ";
				count = dao.memberAllcount(addsql);
				//��¥ ����, ��ü ȸ�� , ���̵� �ְ�
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 3&&!id.equals("")) {
				String addsql ="where (membar_state = 0 or membar_state= 1) and id='"+id+"'";
				count = dao.memberAllcount(addsql);
				//��¥ ����, Ż��ȸ�� , ���̵� �ְ�
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 1&&!id.equals("")) {
				String addsql ="where membar_state= 1 and id='"+id+"'";
				count = dao.memberAllcount(addsql);
				//��¥ �ְ�, ��üȸ�� , ���̵� �ְ�
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 3&&!id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and (membar_state = 0 or membar_state= 1) and id='"+id+"'";
				count = dao.memberAllcount(addsql);
			}
			
			// �ش��������� ���� �����ϴ� ��ȣ jsp�� �����ֱ����� ��
			number = count - (currentPage - 1) * pageSize;
			int startRow = (currentPage-1) * pageSize ; 
			
			// ���ǿ� �´� ȸ�� ����
			//��¥ ���� id ���� ��ü ȸ�� ����
			if (startDay.equals("")&&endDay.equals("")&&membar_state == 3&&id.equals("")) {
				String addsql="where membar_state = 0 or membar_state= 1";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//��¥ �ְ�, ��ü ȸ�� ���� , ���̵� ����
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 3&&id.equals("")) {
				String addsql="where joindate >= '"+startDay+"' and  joindate <= '"+endDay+"'and (membar_state = 0 or membar_state= 1)";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//��¥ �ְ�, Ż�� ȸ�� , ���̵� ����
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 1&&id.equals("")) {
				String addsql="where joindate >= '"+startDay+"' and  joindate <= '"+endDay+"'and membar_state = 1 ";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//��¥ �ְ�, ���� ȸ�� , ���̵� ����
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 0&&id.equals("")) {
				String addsql="where joindate >= '"+startDay+"' and  joindate <= '"+endDay+"'and membar_state= 0 ";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//��¥ �ְ�, Ż�� ȸ�� , ���̵� �ְ�
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 1&&!id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and membar_state= 1 and id='"+id+"'";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//��¥ ����, ���� ȸ�� , ���̵� �ְ�
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 0&&!id.equals("")) {
				String addsql ="where membar_state= 0 and id='"+id+"'";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//��¥ �ְ�, ���� ȸ�� , ���̵� �ְ�
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 0&&!id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and membar_state= 0 and id='"+id+"'";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//��¥ ����, Ż�� ȸ�� , ���̵� ����
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 1&&id.equals("")) {
				String addsql ="where  membar_state= 1 ";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//��¥ ����, ���� ȸ�� , ���̵� ����
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 0&&id.equals("")) {
				String addsql ="where  membar_state= 0 ";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//��¥ ����, ��ü ȸ�� , ���̵� �ְ�
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 3&&!id.equals("")) {
				String addsql ="where (membar_state = 0 or membar_state= 1) and id='"+id+"'";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//��¥ ����, Ż��ȸ�� , ���̵� �ְ�
			}else if (startDay.equals("") &&endDay.equals("")&&membar_state == 1&&!id.equals("")) {
				String addsql ="where membar_state= 1 and id='"+id+"'";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
				//��¥ �ְ�, ��üȸ�� , ���̵� �ְ�
			}else if (!startDay.equals("") &&!endDay.equals("")&&membar_state == 3&&!id.equals("")) {
				String addsql ="where  joindate >= '"+startDay+"' and  joindate <= '"+endDay+"' and (membar_state = 0 or membar_state= 1) and id='"+id+"'";
				userList = dao.memberAllSelect(addsql, startRow, pageSize);
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


