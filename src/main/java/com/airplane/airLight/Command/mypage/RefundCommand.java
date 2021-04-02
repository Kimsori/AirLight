package com.airplane.airLight.Command.mypage;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.MyPageDAO;

public class RefundCommand implements Action{

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		MyPageDAO pdao = new MyPageDAO();
		
		int way = Integer.parseInt(request.getParameter("way"));
		int code = Integer.parseInt(request.getParameter("code"));
		int state = 3;
		
		if(way!=1) { // �պ�
			pdao.state2(state, way); // ���Ż��� ȯ�� ��û������
		}else { // ��
			pdao.state(state, code); // ���Ż��� ȯ�� ��û������
		}
		pdao.autoMoney(); // 24�ð� �̳��� ���Աݽ� �ڵ� ���
		pdao.autoMoneyToday();// ���Ͽ��� �� ��߽ð�-2�ð� �̳����� ���Աݽ� �ڵ� ���
		pdao.autoRefund(); // ž����-5�ϱ����� ȯ�� ����.
		pdao.autoPlane(); // ������� �Ǹ� ž�¿Ϸ�.
		
	}

}
