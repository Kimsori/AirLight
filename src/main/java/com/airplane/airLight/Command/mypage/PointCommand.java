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
		int count = 0; //��ü �Խñ��� ���� 
		int number = 0; // �Խ��� �ֽű� �ۼ� ������ ��ȣ ���� 30,29,28 ~~
		int currentPage = Integer.parseInt(pageNum);// ���� ������ ��ȣ 
		
		count = dao.memberPointCount(code);// ����Ʈ ���̺� ī��Ʈ
		number = count - (currentPage - 1)*pageSize;// �ش��������� ���� �����ϴ� ��ȣ jsp�� �����ֱ����� ��
		int startRow = (currentPage-1) * pageSize ; //
		
		pdto = dao.memberPoint(code,startRow,pageSize); // ����Ʈ ����¡ ����
		int pageCount = 0; // ��ü ������ �ѹ��� ����=>3������ , �� ȭ�鿡 3���� ����¡ 
		int startPage = 1; // ���� ȭ�鿡 1page�̸� startPage =1 , 2page => 4 , 3page => 7
		int endPage = 0;
		int result = 0;
		
		if(count > 0) {
			//1 /5 +(1%5) >> 0+1 pagecount =1
			pageCount = count/pageSize+(count % pageSize == 0?0:1);
			result = currentPage /5;
			
			// ���������� �������� ���Ե� ����¡ ������ 
			//�����ϴ� ������ ����ȣ�� ���ϴ� ���ǹ�
			if(currentPage % 5 != 0) {
				startPage = result * 5+1;
			}else {
				startPage = (result -1)*5+1;
			}
			
			//������  endPage�� ���� �����ϴ� �ڵ�
			endPage = (startPage+5)-1;
			if(endPage > pageCount) {
				endPage = pageCount;
			}
			// �α��� ȸ�� ������Ʈ ����
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
