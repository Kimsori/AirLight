package com.airplane.airLight.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.airplane.airLight.Action;
import com.airplane.airLight.Command.ticketing.TicketCommand;
import com.airplane.airLight.dao.MemberDAO;
import com.airplane.airLight.dto.MemberDTO;
import com.airplane.airLight.dto.searchDTO;

import net.crizin.KoreanCharacter;
import net.crizin.KoreanRomanizer;

@Controller
public class MemberController {

@Autowired
private MemberDAO mdao;
private Action command;

@RequestMapping("/")
	public String indexgo(Model model) {
		model.addAttribute("center", "main/ticketing.jsp");
		command = new TicketCommand();
		command.execute(model);
		return "index";
	}
@RequestMapping("index")
public String index2(Model model ,HttpServletRequest request) {
	String log = request.getParameter("log");
	command = new TicketCommand();
	command.execute(model);
	model.addAttribute("log", log);
	model.addAttribute("center", "main/ticketing.jsp");
	return "index";
}

@RequestMapping(value="joingo",method= {RequestMethod.GET,RequestMethod.POST})
public String joingo(Model model , HttpServletRequest request) {
	command = new TicketCommand();
	command.execute(model);
	model.addAttribute("x", 1);
	model.addAttribute("y", 1);
	model.addAttribute("center","member/join.jsp");
	return "index";
}
@RequestMapping(value="indexpage",method= {RequestMethod.GET,RequestMethod.POST})
public String mainhome(Model model,HttpServletRequest request) {
	command = new TicketCommand();
	command.execute(model);
	model.addAttribute("center","main/ticketing.jsp");
	return "index";
}

@RequestMapping(value="engChange")
public String engchange(@RequestParam("krname") String krname,@RequestParam("krname2") String krname2,Model model) {
	
	String krname11 =KoreanRomanizer.romanize(krname,KoreanCharacter.Type.NameTypical); // 성을 영어변경
	//성 영문으로 변경 하는 메서드 ,KoreanCharacter.Type.NameTypical
	String krname22 =KoreanRomanizer.romanize(krname2,KoreanCharacter.Type.Substantives); // 이름을 영어로 변경
	//이름 영문으로 변경 하는 메서드 ,KoreanCharacter.Type.Substantives
	
	model.addAttribute("english",krname11); //성
	model.addAttribute("english2",krname22); //이름
	
	return "member/engChangeNameForm";
}

@RequestMapping(value="join",method= {RequestMethod.GET,RequestMethod.POST})
public String joininsert(MemberDTO mdto,Model model,HttpServletRequest request,HttpSession session) {
	//==========================================================
		//=========회원코드 생성 코딩
	Date date = new Date();
	SimpleDateFormat sysday = new SimpleDateFormat("yyyMMdd");
	String sysd = sysday.format(date)+'%';
	int i = mdao.membercode(sysd);
	System.out.println("test:"+i);
	String memberCode =sysday.format(date)+String.format("%04d", i);
	System.out.println("test:" +memberCode);
	mdto.setMember_code(Long.parseLong(memberCode));
	
	System.out.println(mdto.getMember_code());
	
	mdto.setFirst_name(request.getParameter("krname"));
	mdto.setLast_name(request.getParameter("krname2"));
	mdto.setEn_first_name(request.getParameter("engname"));
	mdto.setEn_last_name(request.getParameter("engname2"));
	//==========================================================
		//==========생년월일 (ex: 960303) 으로 합쳐서 자르기코딩
	String b =request.getParameter("birth1")+request.getParameter("birth2")+request.getParameter("birth3");
	String b1 = b.substring(2, 8);
	System.out.println(b1);
	mdto.setBirth(Integer.parseInt(b1));
	mdto.setGender(Integer.parseInt(request.getParameter("gender")));
	mdto.setEmail(request.getParameter("email"));
	mdto.setCountry(request.getParameter("country"));
	mdto.setPhone(request.getParameter("phone_num"));
	mdto.setPostcode(request.getParameter("postcode"));
	//======================================================
		//=========주소 상세주소 합치기 
	mdto.setAddr(request.getParameter("roadaddress"));
	mdto.setDetail_addr(request.getParameter("detailaddress"));
	String join_id = request.getParameter("join_id");
	int dupleCnt = mdao.dupleId(join_id);
	System.out.println("dupleCnt: "+dupleCnt);
	System.out.println("join_id: "+join_id);
	if(dupleCnt>0) {
		session.setAttribute("msg", "중복된 아이디입니다.");
		model.addAttribute("center", "member/joinfail.jsp");
		return "member/joinfail";
	}else {
		mdto.setId(join_id);
		mdto.setPw(request.getParameter("pw"));
		mdto.setTel(request.getParameter("wireline"));
		
		mdao.JoinInsert(mdto);
		
		return "member/joinsucess";
	}
	
	
	
}	
	//============================================================
		//==========아이디 체크
	/*@RequestMapping("idchk")
	public String idchk(Model model,HttpServletRequest request,HttpSession session) {
		int x = 0;
		String id = request.getParameter("join_id");
		if(mdao.idchk(id) != x) {
			session.setAttribute("msg", "중복된 아이디입니다.");
			model.addAttribute("center", "member/join.jsp");
			return "member/searchfail";
		}else {
			session.setAttribute("msg", "가입가능한아이디입니다.");
			model.addAttribute("x", x);
			model.addAttribute("center", "member/join.jsp");
			return "member/loginsucess";
		}
		
	}*/
	
	
	//============================================================
		//==========로그인 맵핑 
	@RequestMapping(value="login", method= {RequestMethod.GET,RequestMethod.POST})
	public String login(Model model,HttpServletRequest request,MemberDTO mdto,HttpSession session) {
		
		String pw = request.getParameter("pw");
		int chk01 = Integer.parseInt(request.getParameter("chk01"));
		int state = 0;
		command = new TicketCommand();
		command.execute(model);
		//=================================================================================================
		// 아이디로 로그인
		if(chk01 == 1) {
			String id = request.getParameter("id");
			if(id!="" && pw !="") {
				if(!id.equals(mdao.loginid(id))) {
					session.setAttribute("log", "손님");
					session.setAttribute("msg", "아이디 정보가 일치 하지않습니다.");
					model.addAttribute("center", "member/loginfail.jsp");
					return "member/loginfail";
				}else {
					if(!pw.equals(mdao.loginpw(id))) {
						session.setAttribute("log", "손님");
						session.setAttribute("msg", "비밀번호가 일치 하지않습니다.");
						model.addAttribute("center", "member/loginfail.jsp");
						return "member/loginfail";
					}else {
						state = mdao.state(id, pw);
						if(state == 0) {
							session.setAttribute("log", "회원");
							session.setAttribute("id", id);
							Long memberCode = mdao.findMemberCoder(id);
							session.setAttribute("CodeMember", memberCode);
							String name = mdao.getName(memberCode);
							session.setAttribute("name", name);
							System.out.println("다손 테스트 name:"+name);
							System.out.println(memberCode);
							model.addAttribute("center", "main/ticketing.jsp");
							return "index";
						}else if(state == 1) {
							session.setAttribute("log", "손님");
							session.setAttribute("msg", "탈퇴된 회원입니다.");
							model.addAttribute("center", "member/loginfail.jsp");
							return "member/loginfail";
						}else {
							Long memberCode = mdao.findMemberCoder(id);
							session.setAttribute("CodeMember", memberCode);
							session.setAttribute("log", "관리자");
							//model.addAttribute("center", "admin/adminPage.jsp");
							return "redirect:AdminPage?num=0";
						}
						
					}
				}
			}else {
				session.setAttribute("msg", "로그인정보를 입력해주세요");
				model.addAttribute("center", "member/loginfail.jsp");
				return "index";
			}
//=================================================================================================
			// 회원코드로 로그인
			
		}else {
			long memid = Long.parseLong(request.getParameter("id"));
			if(memid != 0 && pw != "") {
				System.out.println("test2="+pw);
				if(memid != mdao.membercodeid(memid)) {
					session.setAttribute("log", "손님");
					session.setAttribute("msg", "회원코드가 일치 하지않습니다.");
					model.addAttribute("center", "member/loginfail.jsp");
					return "member/loginfail";
				}else {
					if(!pw.equals(mdao.membercodepw(memid))) {
						session.setAttribute("log", "손님");
						session.setAttribute("msg", "비밀번호가 일치 하지않습니다");
						model.addAttribute("center", "member/loginfail.jsp");
						return "member/loginfail";
					}else {
						state = mdao.codestate(memid, pw);
						if(state == 0) {
							session.setAttribute("log", "회원");
							session.setAttribute("id", memid);
							session.setAttribute("CodeMember", memid);
							String name = mdao.getName(memid);
							session.setAttribute("name", name);
							model.addAttribute("center", "main/ticketing.jsp");
							return "index";
						}else if(state == 1) {
							session.setAttribute("log", "손님");
							session.setAttribute("msg", "탈퇴된 회원입니다");
							model.addAttribute("center", "member/loginfail.jsp");
							return "member/loginfail";
						}else {
							session.setAttribute("CodeMember", memid);
							session.setAttribute("log", "관리자");
							//model.addAttribute("center", "admin/adminPage.jsp");
							return "redirect:AdminPage?num=0";
						}
						
					}
				}
			}else {
				session.setAttribute("msg", "로그인 정보를 입력해주세요");
				model.addAttribute("center", "member/loginfail.jsp");
				return "index";
			}
		}
	}
	
	@RequestMapping(value="logout",method= {RequestMethod.GET,RequestMethod.POST})
	public String logout(Model model,HttpSession session) {
		command = new TicketCommand();
		command.execute(model);
		session.setAttribute("log", "손님");
		session.setAttribute("msg", "로그아웃되었습니다");
		session.removeAttribute("id");
		session.setAttribute("CodeMember", 1111111111111L);
		session.removeAttribute("name");
		model.addAttribute("center", "member/loginfail.jsp");
		return "member/loginfail";
	}
	@RequestMapping(value="searchidpw",method= {RequestMethod.GET,RequestMethod.POST})
	public String searchidpw(Model model,HttpSession session) {
		
		model.addAttribute("center", "member/searchidpw.jsp");
		return "index";
	}
	
	@RequestMapping(value="idsearch",method= {RequestMethod.GET,RequestMethod.POST})
	public String idsearch(Model model,HttpSession session,HttpServletRequest request,MemberDTO mdto,searchDTO sdto) {
		int chks = Integer.parseInt(request.getParameter("chks"));
		String searchinput = request.getParameter("searchinput");
		String birth11 = sdto.getBirth11();
		String birth22 = sdto.getBirth22();
		String birth33 = sdto.getBirth33();
		command = new TicketCommand();
		command.execute(model);
		
		String b1 =birth11+birth22+birth33;
		String b2 = b1.substring(2, 8);
		
		System.out.println(chks);
		if(chks == 1) {
			if(mdao.idcnt(Long.parseLong(searchinput), Integer.parseInt(b2)) == 0) {
				session.setAttribute("msg", "입력하신 정보를 확인해주세요.");
				model.addAttribute("center", "member/searchfail.jsp");
				return "member/searchfail";
			}else{
				String id = mdao.idsearch(Long.parseLong(searchinput), Integer.parseInt(b2));
				model.addAttribute("member_code", sdto.getSearchinput());
				model.addAttribute("id", id);
				model.addAttribute("chks", chks);
				model.addAttribute("center", "member/searchresult.jsp");
				
			}
			return "index";
			
		}else {
			if(mdao.idcnt1(searchinput, Integer.parseInt(b2)) == 0) {
				session.setAttribute("msg", "입력하신 정보를 확인해주세요.");
				model.addAttribute("center", "member/searchfail.jsp");
				return "member/searchfail";
			}else {
				String myid = mdao.idsearch1(searchinput, Integer.parseInt(b2));
				model.addAttribute("email", sdto.getSearchinput());
				model.addAttribute("myid", myid);
				model.addAttribute("chks", chks);
				model.addAttribute("center", "member/searchresult.jsp");
			}
			return "index";
		}
	}
	@RequestMapping(value="pwsearch",method= {RequestMethod.GET,RequestMethod.POST})
	public String pwsearch(Model model,HttpServletRequest request,HttpSession session,searchDTO sdto,MemberDTO mdto) {
		String birth111 = sdto.getBirth111();
		String birth222 = sdto.getBirth222();
		String birth333 = sdto.getBirth333();
		String dbid = sdto.getDbid();
		String dbeng_first = sdto.getDbeng_first();
		
		String b11 =birth111+birth222+birth333;
		String b22 = b11.substring(2, 8);
		int chks3 = Integer.parseInt(request.getParameter("chks3"));
		command = new TicketCommand();
		command.execute(model);
		System.out.println("chks3값="+chks3);
		System.out.println("input박스에서 입력한 영어이름:"+dbeng_first);
		String n =mdao.enfirstname(dbeng_first);
		if(chks3 == 1) {
			if( mdao.pwcnt(dbid, dbeng_first, Integer.parseInt(b22)) == 0) {
				session.setAttribute("msg", "입력하신 정보를 확인해주세요.");
				model.addAttribute("center", "member/searchfail.jsp");
				return "member/searchfail";
			}else {
				String pw = mdao.loginpw(dbid);
				
				model.addAttribute("dbid", dbid);
				model.addAttribute("pw", pw);
				model.addAttribute("chks3", chks3);
				model.addAttribute("center", "member/searchresult.jsp");
			}
		}
		return "index";
		
	}
	@RequestMapping(value="membercodeserch",method= {RequestMethod.GET,RequestMethod.POST})
	public String membercode(Model model,HttpServletRequest request,HttpSession session,searchDTO sdto) {
		int chks1 = Integer.parseInt(request.getParameter("chks1"));
		
		String search1input = request.getParameter("search1input");
		
		command = new TicketCommand();
		command.execute(model);
		
		String birth1111 = sdto.getBirth1111();
		String birth2222 = sdto.getBirth2222();
		String birth3333 = sdto.getBirth3333();
		String engfirstname = sdto.getEngfirstname();
		String engnam = sdto.getEngnam();
		
		String b111 =birth1111+birth2222+birth3333;
		String b222 = b111.substring(2, 8);
		
		System.out.println(engfirstname);
		System.out.println(engnam);
		System.out.println(search1input);
		System.out.println(b222);
		System.out.println(chks1+"너의이름은?");
		if(chks1 == 1) {
			System.out.println("chks1 1번쨰값="+chks1);
			System.out.println(engfirstname);
			System.out.println(engnam);
			System.out.println(search1input);
			System.out.println(b222);
			System.out.println("체크1 ="+mdao.membercodecnt(engfirstname, engnam, search1input, Integer.parseInt(b222)));
			if(mdao.membercodecnt(engfirstname, engnam, search1input, Integer.parseInt(b222)) == 0) {
				System.out.println("체크2 ="+mdao.membercodecnt(engfirstname, engnam, search1input, Integer.parseInt(b222)));
				session.setAttribute("msg", "입력하신 정보를 확인해주세요.");
				model.addAttribute("center", "member/searchfail.jsp");
				return "member/searchfail";
			}else {
				long member_code = mdao.membercodesch(engfirstname, engnam, search1input, Integer.parseInt(b222));
				model.addAttribute("phone", search1input);
				model.addAttribute("member_code",member_code );
				model.addAttribute("chks1", chks1);
				model.addAttribute("center", "member/searchresult.jsp");
			}
		}else {
			System.out.println("chks1 2번쨰값="+chks1);
			System.out.println(engfirstname);
			System.out.println(engnam);
			System.out.println(search1input);
			System.out.println(b222);
			if(mdao.membercodecnt1(engfirstname, engnam, search1input, Integer.parseInt(b222)) == 0) {
				session.setAttribute("msg", "입력하신 정보를 확인해주세요.");
				model.addAttribute("center", "member/searchfail.jsp");
				return "member/searchfail";
			}else {
				long member_code = mdao.membercodesch2(engfirstname, engnam, search1input, Integer.parseInt(b222));
				model.addAttribute("email", search1input);
				model.addAttribute("member_code",member_code );
				model.addAttribute("chks1", chks1);
				model.addAttribute("center", "member/searchresult.jsp");
		}
	}
		return "index";
}
}
