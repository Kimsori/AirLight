package com.airplane.airLight.Command.mypage;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.MyPageDAO;

public class PayCommand implements Action{

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		MyPageDAO pdao = new MyPageDAO();
		
		int way = Integer.parseInt(request.getParameter("way"));
		long memCode = (Long) session.getAttribute("CodeMember");
		int code = Integer.parseInt(request.getParameter("code"));
		int price = Integer.parseInt(request.getParameter("price"));
		String end = request.getParameter("end");
		String splitEnd = end.substring(0, end.length()-2);
		int state = 1;
		
		if(way!=1) { // �պ�
			price = pdao.selectMaxPrice(way); // �պ��϶� �� ���� ã��
			pdao.state2(state, way); // ���� ���� ���� �Ϸ�� �ٲٱ�
			String endTwo = pdao.findEndPoint(way, end); // ������ ã��
			String splitEndTwo = endTwo.substring(0, endTwo.length()-2);
			pdao.point(memCode, (price*0.05), "�պ�(" + splitEnd + ", " + splitEndTwo + ")�� Ƽ�� �߱ǿϷ�"); // ���ϸ��� ����
			pdao.inputDay2(way); // �Ա��� update
		}else { // ��
			pdao.state(state, code); // ���� ���� ���� �Ϸ�� �ٲٱ�
			pdao.point(memCode, (price*0.05), splitEnd + "�� Ƽ�� �߱ǿϷ�"); // ���ϸ��� ����
			pdao.inputDay(code); // �Ա��� update
		}
		pdao.autoMoney(); // 24�ð� �̳��� ���Աݽ� �ڵ� ���
		pdao.autoMoneyToday();// ���Ͽ��� �� ��߽ð�-2�ð� �̳����� ���Աݽ� �ڵ� ���
		pdao.autoRefund(); // ž����-5�ϱ����� ȯ�� ����.
		pdao.autoPlane(); // ������� �Ǹ� ž�¿Ϸ�.
		
	}

}
