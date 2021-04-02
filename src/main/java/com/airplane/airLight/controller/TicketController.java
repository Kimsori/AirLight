package com.airplane.airLight.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airplane.airLight.Action;
import com.airplane.airLight.dao.MyPageDAO;
import com.airplane.airLight.dao.TicketDAO;
import com.airplane.airLight.dto.MemberDTO;
import com.airplane.airLight.dto.TicketDTO;
import com.airplane.airLight.dto.TicketInfoDTO;

@Controller
public class TicketController {

	@Autowired
	TicketDAO tdao;
	
	@Autowired
	MyPageDAO pdao;
	
	private Action command;
	
	@RequestMapping(value="ticketReserve", method={RequestMethod.GET, RequestMethod.POST})
	public String goReserve(TicketInfoDTO tidto, TicketDTO tdto, Model model, HttpSession session) {

		// ���ϸ����� ������ �� �ݾ�
		String[] total = tidto.getTotal().split(",");
		String totalPrice = "";
		for(int i=0; i<total.length; i++) {
			totalPrice = totalPrice + total[i];
			System.out.println("total[0]"+total[i]);
		}
		int readTotalPrice = Integer.parseInt(totalPrice);
		
		// �� �ݾ�
		String[] Rtotal = tidto.getRealTotal().split(",");
		String RtotalPrice = "";
		for(int i=0; i<Rtotal.length; i++) {
			RtotalPrice = RtotalPrice + Rtotal[i];
			System.out.println("Rtotal[0]"+Rtotal[i]);
		}
		int RTotalPrice = Integer.parseInt(RtotalPrice);
		
		long memCode = (Long) session.getAttribute("CodeMember");
		
		int useMileage = tidto.getUseMileage();
		
		if(useMileage+readTotalPrice!=RTotalPrice) {
			session.setAttribute("msg", "���ϸ��� ��� ��ư�� Ŭ�����ּ���.");
			model.addAttribute("center", "ticketing/listfail.jsp");
			return "ticketing/listfail";
		}else {
			
			String goCon = tidto.getGoCon();
			String backCon = "";
			String [] splitGoCon = goCon.split(", ");
			String [] splitBackCon;
			int goConNum = splitGoCon.length;
			int backConNum = 0;
			System.out.println(tidto.getGoway());
			for(int i=0; i<splitGoCon.length; i++) {
				tdao.insertSeat(Integer.parseInt(tidto.getGoTimeCode()), splitGoCon[i]);
			}
			
			if(useMileage>0 && useMileage+readTotalPrice==RTotalPrice) {
				pdao.point(memCode, -useMileage, "���ϸ��� ���");
			}
			
			// ��
			MemberDTO mdto = new MemberDTO();
			mdto = tdao.enMember(memCode);
			tdto.setMember_code(memCode);
			tdto.setTime_code(Integer.parseInt(tidto.getGoTimeCode()));
			tdto.setEndTime(tidto.getPlusHour() + ":" + tidto.getPlusMin());
			tdto.setWayTime(tidto.getHour() + "�ð� " + tidto.getMin() + "��");
			tdto.setAdult(Integer.parseInt(tidto.getAdult()));
			tdto.setChild(Integer.parseInt(tidto.getChild()));
			tdto.setBaby(Integer.parseInt(tidto.getBaby()));
			tdto.setPrice(readTotalPrice);
			tdto.setSeat(goCon);
			int maxway = tdao.maxWayType();
			if(tidto.getGoway().equals("�պ�") || tidto.getGoway()=="�պ�") {
				tdto.setWayType(maxway+1);
			}else {
				tdto.setWayType(1);
			}
			tdao.memberInsertTicketing(tdto);
			tdao.minusSeat(goConNum, Integer.parseInt(tidto.getGoTimeCode()));
			
			// �պ�
			if(tidto.getGoway().equals("�պ�") || tidto.getGoway()=="�պ�") {
				backCon = tidto.getBackCon();
				splitBackCon = backCon.split(", ");
				for(int i=0; i<splitBackCon.length; i++) {
					tdao.insertSeat(Integer.parseInt(tidto.getEndTimeCode()), splitBackCon[i]);
				}
				backConNum = splitBackCon.length;
				tdto.setMember_code(memCode);
				tdto.setTime_code(Integer.parseInt(tidto.getEndTimeCode()));
				tdto.setEndTime(tidto.getTwoplusHour() + ":" + tidto.getTwoplusMin());
				tdto.setWayTime(tidto.getTwohour() + "�ð� " + tidto.getTwomin() + "��");
				tdto.setAdult(Integer.parseInt(tidto.getAdult()));
				tdto.setChild(Integer.parseInt(tidto.getChild()));
				tdto.setBaby(Integer.parseInt(tidto.getBaby()));
				tdto.setPrice(0);
				tdto.setSeat(backCon);
				tdto.setWayType(maxway+1);
				tdao.memberInsertTicketing(tdto);
				tdao.minusSeat(backConNum, Integer.parseInt(tidto.getEndTimeCode()));
			}
			model.addAttribute("en", mdto);
			model.addAttribute("center", "ticketing/reserve.jsp");
			model.addAttribute("rank", tidto.getRank());
			model.addAttribute("goTimeCode", tidto.getGoTimeCode()); // ��߰����� �ð� �ڵ�
			model.addAttribute("endTimeCode", tidto.getEndTimeCode()); // ���� ������ �ð� �ڵ�
			model.addAttribute("startPoint", tidto.getStartPoint());
			model.addAttribute("endPoint", tidto.getEndPoint());
			model.addAttribute("goDay", tidto.getGoDay());
			model.addAttribute("goTime", tidto.getGoTime());
			model.addAttribute("plusHour", tidto.getPlusHour());
			model.addAttribute("plusMin", tidto.getPlusMin());
			model.addAttribute("hour", tidto.getHour());
			model.addAttribute("min", tidto.getMin());
			model.addAttribute("planeName", tidto.getPlaneName());
			model.addAttribute("twostartPoint", tidto.getTwostartPoint());
			model.addAttribute("twoendPoint", tidto.getTwoendPoint());
			model.addAttribute("twogoDay", tidto.getTwogoDay());
			model.addAttribute("twogoTime", tidto.getTwogoTime());
			model.addAttribute("twoplusHour", tidto.getTwoplusHour());
			model.addAttribute("twoplusMin", tidto.getTwoplusMin());
			model.addAttribute("twoplaneName", tidto.getTwoplaneName());
			model.addAttribute("twohour", tidto.getTwohour());
			model.addAttribute("twomin", tidto.getTwomin());
			model.addAttribute("goway", tidto.getGoway());
			model.addAttribute("day01", tidto.getDay01());
			model.addAttribute("day02", tidto.getDay02());
			model.addAttribute("ticketPrice", tidto.getTicketPrice());
			model.addAttribute("tex", tidto.getTex());
			model.addAttribute("total", tidto.getTotal());
			model.addAttribute("adult", Integer.parseInt(tidto.getAdult()));
			model.addAttribute("child", Integer.parseInt(tidto.getChild()));
			model.addAttribute("baby", Integer.parseInt(tidto.getBaby()));
			model.addAttribute("goCon", tidto.getGoCon());
			model.addAttribute("backCon", tidto.getBackCon());
			
			return "index";
		}
	}
	
	// �¼� ���� ������
	@RequestMapping(value="seat", method={RequestMethod.GET, RequestMethod.POST})
	public String goSeat(TicketInfoDTO tidto, Model model, ArrayList<TicketDTO> seatList, TicketDTO seatSize, 
			ArrayList<TicketDTO> twoseatList, TicketDTO twoseatSize, HttpSession session) {
		
		long memCode = (Long) session.getAttribute("CodeMember");
		int mile = tdao.TotalMile(memCode);
		int goTimeCode = Integer.parseInt(tidto.getGoTimeCode());
		int endTimeCode = 0;
		if(tidto.getEndTimeCode()!=null && tidto.getEndTimeCode()!="" && !tidto.getEndTimeCode().equals("")) {
			endTimeCode = Integer.parseInt(tidto.getEndTimeCode());
			twoseatList = tdao.seatState(endTimeCode);
			twoseatSize = tdao.seatXY(endTimeCode);
		}
		
		seatList = tdao.seatState(goTimeCode);
		seatSize = tdao.seatXY(goTimeCode);
		
		model.addAttribute("center", "ticketing/seat.jsp");
		model.addAttribute("mile", mile);
		model.addAttribute("seatList", seatList);
		model.addAttribute("seatSize", seatSize);
		model.addAttribute("twoseatList", twoseatList);
		model.addAttribute("twoseatSize", twoseatSize);
		model.addAttribute("rank", tidto.getRank());
		model.addAttribute("goTimeCode", tidto.getGoTimeCode()); // ��߰����� �ð� �ڵ�
		model.addAttribute("endTimeCode", tidto.getEndTimeCode()); // ���� ������ �ð� �ڵ�
		model.addAttribute("startPoint", tidto.getStartPoint());
		model.addAttribute("endPoint", tidto.getEndPoint());
		model.addAttribute("goDay", tidto.getGoDay());
		model.addAttribute("goTime", tidto.getGoTime());
		model.addAttribute("plusHour", tidto.getPlusHour());
		model.addAttribute("plusMin", tidto.getPlusMin());
		model.addAttribute("hour", tidto.getHour());
		model.addAttribute("min", tidto.getMin());
		model.addAttribute("planeName", tidto.getPlaneName());
		model.addAttribute("twostartPoint", tidto.getTwostartPoint());
		model.addAttribute("twoendPoint", tidto.getTwoendPoint());
		model.addAttribute("twogoDay", tidto.getTwogoDay());
		model.addAttribute("twogoTime", tidto.getTwogoTime());
		model.addAttribute("twoplusHour", tidto.getTwoplusHour());
		model.addAttribute("twoplusMin", tidto.getTwoplusMin());
		model.addAttribute("twoplaneName", tidto.getTwoplaneName());
		model.addAttribute("twohour", tidto.getTwohour());
		model.addAttribute("twomin", tidto.getTwomin());
		model.addAttribute("goway", tidto.getGoway());
		model.addAttribute("day01", tidto.getDay01());
		model.addAttribute("day02", tidto.getDay02());
		model.addAttribute("ticketPrice", tidto.getTicketPrice());
		model.addAttribute("tex", tidto.getTex());
		model.addAttribute("total", tidto.getTotal());
		model.addAttribute("adult", Integer.parseInt(tidto.getAdult()));
		model.addAttribute("child", Integer.parseInt(tidto.getChild()));
		model.addAttribute("baby", Integer.parseInt(tidto.getBaby()));
		
		return "index";
	}
	
	// ���ӱ��� ������
	@RequestMapping(value="rule", method={RequestMethod.GET, RequestMethod.POST})
	public String seeRule(TicketInfoDTO tidto, Model model) {
		model.addAttribute("center", "ticketing/rule.jsp");
		model.addAttribute("rank", tidto.getRank());
		model.addAttribute("goTimeCode", tidto.getGoTimeCode());
		model.addAttribute("endTimeCode", tidto.getEndTimeCode());
		model.addAttribute("startPoint", tidto.getStartPoint());
		model.addAttribute("endPoint", tidto.getEndPoint());
		model.addAttribute("goDay", tidto.getGoDay());
		model.addAttribute("goTime", tidto.getGoTime());
		model.addAttribute("plusHour", tidto.getPlusHour());
		model.addAttribute("plusMin", tidto.getPlusMin());
		model.addAttribute("hour", tidto.getHour());
		model.addAttribute("min", tidto.getMin());
		model.addAttribute("planeName", tidto.getPlaneName());
		model.addAttribute("twostartPoint", tidto.getTwostartPoint());
		model.addAttribute("twoendPoint", tidto.getTwoendPoint());
		model.addAttribute("twogoDay", tidto.getTwogoDay());
		model.addAttribute("twogoTime", tidto.getTwogoTime());
		model.addAttribute("twoplusHour", tidto.getTwoplusHour());
		model.addAttribute("twoplusMin", tidto.getTwoplusMin());
		model.addAttribute("twoplaneName", tidto.getTwoplaneName());
		model.addAttribute("twohour", tidto.getTwohour());
		model.addAttribute("twomin", tidto.getTwomin());
		model.addAttribute("goway", tidto.getGoway());
		model.addAttribute("day01", tidto.getDay01());
		model.addAttribute("day02", tidto.getDay02());
		model.addAttribute("ticketPrice", tidto.getTicketPrice());
		model.addAttribute("tex", tidto.getTex());
		model.addAttribute("total", tidto.getTotal());
		model.addAttribute("adult", tidto.getAdult());
		model.addAttribute("child", tidto.getChild());
		model.addAttribute("baby", tidto.getBaby());
		
		return "index";
	}
	
	// ���� ������ ����� ����Ʈ
		@RequestMapping(value="ticketList", method={RequestMethod.GET, RequestMethod.POST})
		public String goTicketList(Model model, TicketInfoDTO tidto, HttpServletRequest request, HttpSession session) throws ParseException {
			
			long memCode = (Long) session.getAttribute("CodeMember");
			
			if(memCode==1111111111111L || memCode==202010280003L) {
				model.addAttribute("center", "ticketing/listfail.jsp");
				model.addAttribute("msg", "ȸ���� ���� �����մϴ�.");
				return "index";
			}else {
				String first = "";
				String last = "";
				String startPoint = tidto.getStartPoint();
				String endPoint = tidto.getEndPoint();
				String startGo = tidto.getStartGo();
				int adultnum = Integer.parseInt(tidto.getAdult());
				int childnum = Integer.parseInt(tidto.getChild());
				int babynum = Integer.parseInt(tidto.getBaby());
				String rank = tidto.getRank();
				int goway = Integer.parseInt(tidto.getGoway());
				
				if(startPoint.length()>7) { // ��߰����� ���̰� 7���� ũ�� �����̸��� ���� ��.
					first = startPoint.substring(startPoint.length()-7, startPoint.length()); // , ��� ���� ����
				}
				if(endPoint.length()>7) { // ���������� ���̰� 7���� ũ�� �����̸��� ���� ��.
					last = endPoint.substring(endPoint.length()-7, endPoint.length()); // , ��� ���� ����
				}
				
				int ck = 0; // 1: ��߰����� ����, 2: ���� ������ ����, 3: �Ѵ� ����
				
				if(first.equals(", ��� ����")) { // ��߰��׿� ���� �̸��� ��������
					startPoint = startPoint.substring(0, startPoint.length()-7); // ����� �����̸� ����
					ck = 1;
				}
				if(last.equals(", ��� ����")) { // �������׿� ���� �̸��� ��������
					endPoint = endPoint.substring(0, endPoint.length()-7); // ������ �����̸� ����
					if(ck==1) {
						ck = 3;
					}else {
						ck = 2;
					}
				}
				
				ArrayList<TicketDTO> everyList = new ArrayList<TicketDTO>();
				ArrayList<TicketDTO> everyList2 = new ArrayList<TicketDTO>();
				String start = "";
				String start2 = "";
				String end = "";
				String end2 = "";
				int chk = 0; // ���³� �� ����Ʈ ���� ��� üũ
				int chk2 = 0; // ���³� �� ����Ʈ ���� ��� üũ
				
				Calendar cal = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				Calendar cal3 = Calendar.getInstance();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sf1 = new SimpleDateFormat("HH");
				SimpleDateFormat sf2 = new SimpleDateFormat("mm");
				model.addAttribute("mycal", sf.format(cal3.getTime())); // ���� ��¥
				cal3.add(Calendar.HOUR, 2);
				model.addAttribute("mycalHour", Integer.parseInt(sf1.format(cal3.getTime()))); // ���� �ð�
				model.addAttribute("mycalMin", Integer.parseInt(sf2.format(cal3.getTime()))); // ���� ��
				
				String day01 = "";
				String day02 = "";
				
				if(goway==1) { // ���϶�
					Date date = sf.parse(startGo);
					cal.setTime(date);
					int day = cal.get(Calendar.DAY_OF_WEEK);
					if(day==1) {
						day01 = "��";
					}else if(day==2) {
						day01 = "��";
					}else if(day==3) {
						day01 = "ȭ";
					}else if(day==4) {
						day01 = "��";
					}else if(day==5) {
						day01 = "��";
					}else if(day==6) {
						day01 = "��";
					}else if(day==7) {
						day01 = "��";
					}
					
					if(ck==0) { // ��
						everyList = tdao.allPortList(startPoint, startGo, endPoint); // ���� ����Ʈ
						start = tdao.findEndCountry(startPoint); // ����� ������ �����̸�
						end = tdao.findEndCountry(endPoint); // ������ ������ �����̸�
						chk = tdao.countList(startPoint, startGo, endPoint); // ����Ʈ �� ����
					}else if(ck==1) {// 1: ��߰����� ����
						ArrayList<TicketDTO> findPortList = tdao.findPort(startPoint); // ����� ���� �ִ� ��� ���� �˻�
						for(int i = 0; i<findPortList.size(); i++) { 
							TicketDTO a = findPortList.get(i); // �ϳ��� ���� DTO�� ����
							// �� ������ �װ��� ����Ʈ 
							ArrayList<TicketDTO> allPortList = tdao.allPortList(a.getPort_name(), startGo, endPoint); 
							chk = chk+tdao.countList(a.getPort_name(), startGo, endPoint); // ����Ʈ �� ����
							everyList.addAll(allPortList); // �� ���� ArrayList�� �ϳ��� ArrayList�� ��� �� ȭ�鿡 �����ֱ�
						}
						start = startPoint; // ����� ������ �����̸�
						end = tdao.findEndCountry(endPoint); // ������ ������ �����̸�
					}else if(ck==2) { // 2: ���� ������ ����
						ArrayList<TicketDTO> findPortList = tdao.findPort(endPoint); // ������ ���� �ִ� ��� ���� �˻�
						for(int i = 0; i<findPortList.size(); i++) {
							TicketDTO a = findPortList.get(i); // �ϳ��� ���� DTO�� ����
							// �� ������ �װ��� ����Ʈ 
							ArrayList<TicketDTO> allPortList = tdao.allPortList(startPoint, startGo, a.getPort_name());
							chk = chk+tdao.countList(startPoint, startGo, a.getPort_name()); // ����Ʈ �� ����
							everyList.addAll(allPortList); // �� ���� ArrayList�� �ϳ��� ArrayList�� ��� �� ȭ�鿡 �����ֱ�
						}
						start = tdao.findEndCountry(startPoint); // ����� ������ �����̸�
						end = endPoint; // ������ ������ �����̸�
					}else if(ck==3) { // 3: �Ѵ� ����
						ArrayList<TicketDTO> findPortList1 = tdao.findPort(startPoint); // ����� ���� �ִ� ��� ���� �˻�
						ArrayList<TicketDTO> findPortList2 = tdao.findPort(endPoint); // ������ ���� �ִ� ��� ���� �˻�
						for(int i = 0; i<findPortList1.size(); i++) {
							TicketDTO a = findPortList1.get(i); // ����� �ϳ��� ���� DTO�� ����
							for(int j = 0; j<findPortList2.size(); j++) {
								TicketDTO b = findPortList2.get(j); // ������ �ϳ��� ���� DTO�� ����
								// 2�� for�� ����� ���� ������ �װ��� ����Ʈ ����
								ArrayList<TicketDTO> allPortList = tdao.allPortList(a.getPort_name(), startGo, b.getPort_name());
								chk = chk+tdao.countList(a.getPort_name(), startGo, b.getPort_name()); // ����Ʈ �� ����
								everyList.addAll(allPortList); // �� ���� ArrayList�� �ϳ��� ArrayList�� ��� �� ȭ�鿡 �����ֱ�
							}
						}
						start = startPoint; // ����� ������ �����̸�
						end = endPoint; // ������ ������ �����̸�
					}
					
				}else if(goway==2) { // �պ��϶�
					String[] go = startGo.split("/");
					Date date = sf.parse(go[0]);
					Date date2 = sf.parse(go[1]);
					cal.setTime(date);
					cal2.setTime(date2);
					int day = cal.get(Calendar.DAY_OF_WEEK);
					int day2 = cal2.get(Calendar.DAY_OF_WEEK);
					if(day==1) {
						day01 = "��";
					}else if(day==2) {
						day01 = "��";
					}else if(day==3) {
						day01 = "ȭ";
					}else if(day==4) {
						day01 = "��";
					}else if(day==5) {
						day01 = "��";
					}else if(day==6) {
						day01 = "��";
					}else if(day==7) {
						day01 = "��";
					}
					if(day2==1) {
						day02 = "��";
					}else if(day2==2) {
						day02 = "��";
					}else if(day2==3) {
						day02 = "ȭ";
					}else if(day2==4) {
						day02 = "��";
					}else if(day2==5) {
						day02 = "��";
					}else if(day2==6) {
						day02 = "��";
					}else if(day2==7) {
						day02 = "��";
					}
					System.out.println("day2"+day2);
					System.out.println("day02"+day02);
					if(ck==0) { // �պ�
						everyList = tdao.allPortList(startPoint, go[0], endPoint); // ���³� ��� ����Ʈ
						everyList2 = tdao.allPortList(endPoint, go[1], startPoint); // ���³� ��� ����Ʈ
						start = tdao.findEndCountry(startPoint); // ���³� ����� ����
						start2 = tdao.findEndCountry(endPoint); // ���³� ������ ����
						end = tdao.findEndCountry(endPoint); // ���³� ����� ����
						end2 = tdao.findEndCountry(startPoint); // ���³� ������ ����
						chk = tdao.countList(startPoint, go[0], endPoint);
						chk2 = tdao.countList(endPoint, go[1], startPoint);
					}else if(ck==1) {// 1: ��߰����� ����
						ArrayList<TicketDTO> findPortList = tdao.findPort(startPoint); // ���³� �� ���� �ִ� ��� ���� �˻�
						for(int i = 0; i<findPortList.size(); i++) {
							TicketDTO a = findPortList.get(i);
							ArrayList<TicketDTO> allPortList = tdao.allPortList(a.getPort_name(), go[0], endPoint);
							chk = chk + tdao.countList(a.getPort_name(), go[0], endPoint);
							everyList.addAll(allPortList); // �� ���� ArrayList�� �ϳ��� ArrayList�� ���
						}
						ArrayList<TicketDTO> findPortList2 = tdao.findPort(startPoint); // ���³� �� ���� �ִ� ��� ���� �˻�
						System.out.println("a2.getPort_name()"+findPortList2.get(0).getPort_name());
						for(int i = 0; i<findPortList2.size(); i++) {
							TicketDTO a2 = findPortList2.get(i);
							System.out.println("a2.getPort_name()"+a2.getPort_name());
							System.out.println("go[1]"+go[1]);
							ArrayList<TicketDTO> allPortList2 = tdao.allPortList(endPoint, go[1], a2.getPort_name());
							chk2 = chk2 + tdao.countList(endPoint, go[1], a2.getPort_name());
							everyList2.addAll(allPortList2); // �� ���� ArrayList�� �ϳ��� ArrayList�� ���
						}
						start = startPoint;
						start2 = tdao.findEndCountry(endPoint);
						end = tdao.findEndCountry(endPoint);
						end2 = startPoint;
					}else if(ck==2) { // 2: ���� ������ ����
						ArrayList<TicketDTO> findPortList = tdao.findPort(endPoint);
						for(int i = 0; i<findPortList.size(); i++) {
							TicketDTO a2 = findPortList.get(i);
							ArrayList<TicketDTO> allPortList = tdao.allPortList(startPoint, go[0], a2.getPort_name());
							chk = chk + tdao.countList(startPoint, go[0], a2.getPort_name());
							everyList.addAll(allPortList);
						}
						ArrayList<TicketDTO> findPortList2 = tdao.findPort(endPoint);
						for(int i = 0; i<findPortList2.size(); i++) {
							TicketDTO a2 = findPortList2.get(i);
							ArrayList<TicketDTO> allPortList2 = tdao.allPortList(a2.getPort_name(), go[1], startPoint);
							chk2 = chk2 + tdao.countList(a2.getPort_name(), go[1], startPoint);
							everyList2.addAll(allPortList2);
						}
						start = tdao.findEndCountry(startPoint);
						start2 = endPoint;
						end = endPoint;
						end2 = tdao.findEndCountry(startPoint);
					}else if(ck==3) { // 3: �Ѵ� ����
						ArrayList<TicketDTO> findPortList1 = tdao.findPort(startPoint);
						ArrayList<TicketDTO> findPortList2 = tdao.findPort(endPoint);
						for(int i = 0; i<findPortList1.size(); i++) {
							TicketDTO a2 = findPortList1.get(i);
							for(int j = 0; j<findPortList2.size(); j++) {
								TicketDTO b2 = findPortList2.get(j);
								ArrayList<TicketDTO> allPortList = tdao.allPortList(a2.getPort_name(), go[0], b2.getPort_name());
								chk = chk + tdao.countList(a2.getPort_name(), go[0], b2.getPort_name());
								everyList.addAll(allPortList);
								System.out.println("findPortList1.size(): "+findPortList1.size());
								System.out.println("findPortList2.size(): "+findPortList2.size());
							}
						}
						ArrayList<TicketDTO> findPortList3 = tdao.findPort(startPoint);
						ArrayList<TicketDTO> findPortList4 = tdao.findPort(endPoint);
						for(int i = 0; i<findPortList3.size(); i++) {
							TicketDTO a = findPortList3.get(i);
							for(int j = 0; j<findPortList4.size(); j++) {
								TicketDTO b = findPortList4.get(j);
								ArrayList<TicketDTO> allPortList2 = tdao.allPortList(b.getPort_name(), go[1], a.getPort_name());
								chk2 = chk2 + tdao.countList(b.getPort_name(), go[1], a.getPort_name());
								everyList2.addAll(allPortList2);
							}
						}
						start = startPoint;
						start2 = endPoint;
						end = endPoint;
						end2 = startPoint;
					}
				}
				
				// ���� �浵�� �̿��� �Ÿ����
				double [] distanceKiloMeter = new double[everyList.size()]; // ų�ι���
				double [] distanceKiloMeter2 = new double[everyList.size()]; // ų�ι���
				int [] hour = new int[everyList.size()]; 
				int [] min = new int[everyList.size()]; 
				int [] hour2 = new int[everyList.size()]; 
				int [] min2 = new int[everyList.size()]; 
				int [] plusHour = new int[everyList.size()]; 
				int [] plusMin = new int[everyList.size()]; 
				int [] plusHour2 = new int[everyList.size()]; 
				int [] plusMin2 = new int[everyList.size()]; 
				
				TicketDTO c = new TicketDTO();
				TicketDTO d = new TicketDTO();
				
				for(int z = 0; z<everyList.size(); z++) {
					c = tdao.portDistance(everyList.get(z).getStart_point());
					d = tdao.portDistance(everyList.get(z).getEnd_point());
					// ���� �浵�� �̿��� �Ÿ� ���
					distanceKiloMeter[z] = tdao.distance(c.getLatitude(), c.getLongitude(), d.getLatitude(), d.getLongitude(), "kilometer");
					// 1000km�� 1�ð����� ���
					int myTime = (int)Math.ceil(distanceKiloMeter[z]/500);
					hour[z] = myTime/2;
					if(hour[z]*2!=myTime) {
						min[z] = 30;
					}else {
						min[z] = 0;
					}
					String[] i = everyList.get(z).getGo_time().split(":");
					plusHour[z] = hour[z] + Integer.parseInt(i[0]);
					plusMin[z] = min[z] + Integer.parseInt(i[1]);
					if(plusMin[z]>=60) {
						plusHour[z] = plusHour[z]+1;
						plusMin[z] = plusMin[z]-60;
					}
					if(plusHour[z]>=24) {
						plusHour[z] = plusHour[z]-24;
					}
				}
				
				// ���� ����Ʈ �ð����� ���
				// ���� -> ����, Ȥ�� ���� -> ����� �� ��� �� ���׺��� ��� �ð��� ���� ������� ���ĵ�
				// ��ü�� �������� ��߽ð��� ���� ������� �����ϱ� ���� ����Ʈ�� ��� ������ŭ for���� ������
				// ������ �������� ���Ͽ� �ڿ� ��� ������ �տ� ��� �������� ��߽ð��� ������ �� ������ ��ġ �ٲ��ֱ�
				for(int i = 0; i<everyList.size(); i++) {
					for(int j = 0; j<everyList.size()-1; j++) {
						String[] split1 = everyList.get(j).getGo_time().split(":");
						int one = Integer.parseInt(split1[0]);
						int two = Integer.parseInt(split1[1]);
						String[] split2 = everyList.get(j+1).getGo_time().split(":");
						int there = Integer.parseInt(split2[0]);
						int four = Integer.parseInt(split2[1]);
						if(one==there && two>four || one>there || one==there && two==four && plusHour[j]==plusHour[j+1] 
								&& plusMin[j]>plusMin[j+1] || one==there && two==four && plusHour[j]>plusHour[j+1]) {
							TicketDTO a = everyList.get(j);
							everyList.remove(j);
							everyList.add(j+1, a);
							int myplushour = plusHour[j];
							plusHour[j] = plusHour[j+1];
							plusHour[j+1] = myplushour;
							int myplusmin = plusMin[j];
							plusMin[j] = plusMin[j+1];
							plusMin[j+1] = myplusmin;
							int myhour = hour[j];
							hour[j] = hour[j+1];
							hour[j+1] = myhour;
							int mymin = min[j];
							min[j] = min[j+1];
							min[j+1] = mymin;
						}
					}
				}
				
				int [] inHour = new int[everyList.size()];
				int [] inMin = new int[everyList.size()];
				
				for(int i = 0; i<everyList.size(); i++) {
					String[] z = everyList.get(i).getGo_time().split(":");
					System.out.println(z[0]);
					System.out.println(z[1]);
					inHour[i] = Integer.parseInt(z[0]);
					inMin[i] = Integer.parseInt(z[1]);
				}
				
				model.addAttribute("inHour", inHour);
				model.addAttribute("inMin", inMin);
				
				// �պ� �ð� ���
				for(int z = 0; z<everyList2.size(); z++) {
					c = tdao.portDistance(everyList2.get(z).getStart_point());
					d = tdao.portDistance(everyList2.get(z).getEnd_point());
					distanceKiloMeter2[z] = tdao.distance(c.getLatitude(), c.getLongitude(), d.getLatitude(), d.getLongitude(), "kilometer");
					int myTime = (int)Math.ceil(distanceKiloMeter2[z]/500);
					hour2[z] = myTime/2;
					if(hour2[z]*2!=myTime) {
						min2[z] = 30;
					}else {
						min2[z] = 0;
					}
					String[] i = everyList2.get(z).getGo_time().split(":");
					plusHour2[z] = hour2[z] + Integer.parseInt(i[0]);
					plusMin2[z] = min2[z] + Integer.parseInt(i[1]);
					if(plusMin2[z]>=60) {
						plusHour2[z] = plusHour2[z]+1;
						plusMin2[z] = plusMin2[z]-60;
					}
					if(plusHour2[z]>24) {
						plusHour2[z] = plusHour2[z]-24;
					}
				}
				
				// �װ�����Ʈ �ð��� ���
				for(int i = 0; i<everyList2.size(); i++) {
					for(int j = 0; j<everyList2.size()-1; j++) {
						String[] split1 = everyList2.get(j).getGo_time().split(":");
						int one = Integer.parseInt(split1[0]);
						int two = Integer.parseInt(split1[1]);
						String[] split2 = everyList2.get(j+1).getGo_time().split(":");
						int there = Integer.parseInt(split2[0]);
						int four = Integer.parseInt(split2[1]);
						if(one==there && two>four || one>there || one==there && two==four && plusHour2[j]==plusHour2[j+1] && 
								plusMin2[j]>plusMin2[j+1] || one==there && two==four && plusHour2[j]>plusHour2[j+1]) {
							TicketDTO a = everyList2.get(j);
							everyList2.remove(j);
							everyList2.add(j+1, a);
							int myplushour = plusHour2[j];
							plusHour2[j] = plusHour2[j+1];
							plusHour2[j+1] = myplushour;
							int myplusmin = plusMin2[j];
							plusMin2[j] = plusMin2[j+1];
							plusMin2[j+1] = myplusmin;
							int myhour = hour2[j];
							hour2[j] = hour2[j+1];
							hour2[j+1] = myhour;
							int mymin = min2[j];
							min2[j] = min2[j+1];
							min2[j+1] = mymin;
						}
					}
				}
				
				int [] inHour2 = new int[everyList2.size()];
				int [] inMin2 = new int[everyList2.size()];
				for(int i = 0; i<everyList2.size(); i++) {
					String[] z = everyList2.get(i).getGo_time().split(":");
					inHour2[i] = Integer.parseInt(z[0]);
					inMin2[i] = Integer.parseInt(z[1]);
				}
				
				model.addAttribute("inHour2", inHour2);
				model.addAttribute("inMin2", inMin2);
				
				// �˻��� �װ����� �������� �ʴ� ���
				if(goway==1) {
					if(chk==0) {
						model.addAttribute("msg", "�˻��Ͻ� �װ����� �������� �ʽ��ϴ�.");
						model.addAttribute("center", "ticketing/listfail.jsp");
						return "index";
					}
				}else if(goway==2) {
					if(chk==0 || chk2==0) {
						model.addAttribute("msg", "�˻��Ͻ� �װ����� �������� �ʽ��ϴ�.");
						model.addAttribute("center", "ticketing/listfail.jsp");
						return "index";
					}
				}
				
				model.addAttribute("everyList", everyList);
				model.addAttribute("everyList2", everyList2);
				model.addAttribute("center", "ticketing/ticketList.jsp");
				model.addAttribute("startPoint", startPoint);
				model.addAttribute("endPoint", endPoint);
				model.addAttribute("startGo", startGo);
				model.addAttribute("adultnum", adultnum);
				model.addAttribute("childnum", childnum);
				model.addAttribute("babynum", babynum);
				model.addAttribute("rank", rank);
				model.addAttribute("goway", goway);
				model.addAttribute("start", start);
				model.addAttribute("start2", start2);
				model.addAttribute("end", end);
				model.addAttribute("end2", end2);
				model.addAttribute("distanceKiloMeter", distanceKiloMeter);
				model.addAttribute("distanceKiloMeter2", distanceKiloMeter2);
				model.addAttribute("hour", hour);
				model.addAttribute("min", min);
				model.addAttribute("hour2", hour2);
				model.addAttribute("min2", min2);
				model.addAttribute("plusHour", plusHour);
				model.addAttribute("plusMin", plusMin);
				model.addAttribute("plusHour2", plusHour2);
				model.addAttribute("plusMin2", plusMin2);
				model.addAttribute("day01", day01);
				model.addAttribute("day02", day02);
				model.addAttribute("chk", chk);
				model.addAttribute("chk2", chk2);
				
				return "index";
			}
			
		}
	
	
}



































