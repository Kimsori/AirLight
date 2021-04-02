package com.airplane.airLight.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.airplane.airLight.dto.AdminBoardDTO;
import com.airplane.airLight.dto.MemberDTO;
import com.airplane.airLight.dto.TicketDTO;

public class AdminDAO {

	/*String url = "jdbc:mariadb://127.0.0.1:3306/airLight";
	String id = "root";
	String pw = "root";*/
	String url = "jdbc:mariadb://127.0.0.1:3306/rlaekths";
	String id = "rlaekths";
	String pw = "admin2958!";

	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public void getCon() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 연결 완료");
		} catch (Exception e) {
			System.out.println("JDBC 드라이버 로드 에러");

		}
	}
	
	public void close(Connection con, PreparedStatement pstm, ResultSet rs) {
		try {

			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// =========================================== 소리 =============================================
	//
	public int ticketAllListCount() {
		getCon();

		int count = 0;
		try {
			String sql = "select count(*) from air_ticket as ticket, air_time as time where ticket.time_code = time.time_code ";
			pstm = con.prepareStatement(sql);

			rs = pstm.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		return count;
	}	
	// 관리자 전체 회원 보기
	public ArrayList<TicketDTO> ticketAllList(int startRow,int pageSize){
		ArrayList<TicketDTO> a = new ArrayList<TicketDTO>();
		getCon();
		
		try {
			String sql = "select * from air_ticket as ticket, air_time as time where ticket.time_code = time.time_code order by ticket_code desc limit ?,?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, startRow);
			pstm.setInt(2, pageSize);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				TicketDTO tdto = new TicketDTO();
				tdto.setTicket_code(rs.getInt(1));
				tdto.setMember_code(rs.getLong(2));
				tdto.setTime_code(rs.getInt(3));
				tdto.setEndTime(rs.getString(4));
				tdto.setWayTime(rs.getString(5));
				tdto.setAdult(rs.getInt(6));
				tdto.setChild(rs.getInt(7));
				tdto.setBaby(rs.getInt(8));
				tdto.setPrice(rs.getInt(9));
				tdto.setTicket_state(rs.getInt(10));
				tdto.setTicket_date(rs.getString(11));
				tdto.setDeposit(rs.getString(12));
				tdto.setSeat(rs.getString(13));
				tdto.setWayType(rs.getInt(14));
				tdto.setTime_code(rs.getInt(15));
				tdto.setPlane_code(rs.getInt(16));
				tdto.setGo_day(rs.getString(17));
				tdto.setGo_time(rs.getString(18));
				tdto.setStart_point(rs.getString(19));
				tdto.setEnd_point(rs.getString(20));
				tdto.setRemain_seat(rs.getString(21));
				a.add(tdto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
		return a;
	}
	
	// 환불시: wayType으로 좌석 검색
	public ArrayList<TicketDTO> Seat(int way){
		ArrayList<TicketDTO> a = new ArrayList<TicketDTO>();
		getCon();
		
		try {
			String sql = "select seat from air_ticket where wayType=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, way);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				TicketDTO tdto = new TicketDTO();
				tdto.setSeat(rs.getString(1));
				a.add(tdto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
		return a;
	}
	
	// 환불시: 남은 좌석 update
	public void remainSeatUpdate(int remain, int time) {
		getCon();
		
		try {
			String sql = "update air_time set remain_seat = remain_seat + ? where time_code = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, remain);
			pstm.setInt(2, time);
			pstm.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
	}
	
	// 환불시: 예매했던 좌석 다시 비예매 상태로
	public void seatUpdate(int time, String seat) {
		getCon();
		
		try {
			String sql = "update air_seat set seat_state = 0 where time_code = ? and seat_name=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, time);
			pstm.setString(2, seat);
			pstm.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
	}
	
	//관리자 검색 카운트 회원 예매날짜
	public int adminSearch1Count(String first, String end) {
		getCon();

		int count = 0;
		try {
			String sql = "select count(*) from air_ticket as ticket, air_time as time where ticket.time_code = time.time_code "
					+ "and ticket_date between ? and ? ";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, first);
			pstm.setString(2, end);
			rs = pstm.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		return count;
	}	
	
	// 관리자 검색: 회원 예매날짜
	public ArrayList<TicketDTO> adminSearch1(String first, String end,int startRow,int pageSize){
		ArrayList<TicketDTO> a = new ArrayList<TicketDTO>();
		getCon();
		
		try {
			String sql = "select * from air_ticket as ticket, air_time as time where ticket.time_code = time.time_code "
					+ "and ticket_date between ? and ? order by ticket_code desc limit ?,?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, first);
			pstm.setString(2, end);
			pstm.setInt(3, startRow);
			pstm.setInt(4, pageSize);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				TicketDTO tdto = new TicketDTO();
				tdto.setTicket_code(rs.getInt(1));
				tdto.setMember_code(rs.getLong(2));
				tdto.setTime_code(rs.getInt(3));
				tdto.setEndTime(rs.getString(4));
				tdto.setWayTime(rs.getString(5));
				tdto.setAdult(rs.getInt(6));
				tdto.setChild(rs.getInt(7));
				tdto.setBaby(rs.getInt(8));
				tdto.setPrice(rs.getInt(9));
				tdto.setTicket_state(rs.getInt(10));
				tdto.setTicket_date(rs.getString(11));
				tdto.setDeposit(rs.getString(12));
				tdto.setSeat(rs.getString(13));
				tdto.setWayType(rs.getInt(14));
				tdto.setTime_code(rs.getInt(15));
				tdto.setPlane_code(rs.getInt(16));
				tdto.setGo_day(rs.getString(17));
				tdto.setGo_time(rs.getString(18));
				tdto.setStart_point(rs.getString(19));
				tdto.setEnd_point(rs.getString(20));
				tdto.setRemain_seat(rs.getString(21));
				a.add(tdto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
		return a;
	}
	//
	public int adminSearch2Count(String first, String end,int state) {
		getCon();

		int count = 0;
		try {
			String sql = "select count(*) from air_ticket as ticket, air_time as time where ticket.time_code = time.time_code "
					+ "and ticket_date between ? and ? and ticket_state = ? ";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, first);
			pstm.setString(2, end);
			pstm.setInt(3, state);
			rs = pstm.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		return count;
	}	
	// 관리자 검색: 회원 예매날짜, 예매상태
	public ArrayList<TicketDTO> adminSearch2(String first, String end, int state,int startRow,int pageSize){
		ArrayList<TicketDTO> a = new ArrayList<TicketDTO>();
		getCon();
		
		try {
			String sql = "select * from air_ticket as ticket, air_time as time where ticket.time_code = time.time_code "
					+ "and ticket_date between ? and ? and ticket_state = ? order by ticket_code desc limit ?,?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, first);
			pstm.setString(2, end);
			pstm.setInt(3, state);
			pstm.setInt(4, startRow);
			pstm.setInt(5, pageSize);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				TicketDTO tdto = new TicketDTO();
				tdto.setTicket_code(rs.getInt(1));
				tdto.setMember_code(rs.getLong(2));
				tdto.setTime_code(rs.getInt(3));
				tdto.setEndTime(rs.getString(4));
				tdto.setWayTime(rs.getString(5));
				tdto.setAdult(rs.getInt(6));
				tdto.setChild(rs.getInt(7));
				tdto.setBaby(rs.getInt(8));
				tdto.setPrice(rs.getInt(9));
				tdto.setTicket_state(rs.getInt(10));
				tdto.setTicket_date(rs.getString(11));
				tdto.setDeposit(rs.getString(12));
				tdto.setSeat(rs.getString(13));
				tdto.setWayType(rs.getInt(14));
				tdto.setTime_code(rs.getInt(15));
				tdto.setPlane_code(rs.getInt(16));
				tdto.setGo_day(rs.getString(17));
				tdto.setGo_time(rs.getString(18));
				tdto.setStart_point(rs.getString(19));
				tdto.setEnd_point(rs.getString(20));
				tdto.setRemain_seat(rs.getString(21));
				a.add(tdto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
		return a;
	}
	//
	public int adminSearch3Count(String first, String end, int state, long code) {
		getCon();

		int count = 0;
		try {
			String sql = "select * from air_ticket as ticket, air_time as time where ticket.time_code = time.time_code "
					+ "and ticket_date between ? and ? and ticket_state = ? and member_code = ? ";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, first);
			pstm.setString(2, end);
			pstm.setInt(3, state);
			pstm.setLong(4, code);
			rs = pstm.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		return count;
	}	
	// 관리자 검색: 회원 예매날짜, 예매상태, 회원번호
	public ArrayList<TicketDTO> adminSearch3(String first, String end, int state, long code,int startRow,int pageSize){
		ArrayList<TicketDTO> a = new ArrayList<TicketDTO>();
		getCon();
		
		try {
			String sql = "select * from air_ticket as ticket, air_time as time where ticket.time_code = time.time_code "
					+ "and ticket_date between ? and ? and ticket_state = ? and member_code = ? order by ticket_code desc limit ?,?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, first);
			pstm.setString(2, end);
			pstm.setInt(3, state);
			pstm.setLong(4, code);
			pstm.setInt(5, startRow);
			pstm.setInt(6, pageSize);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				TicketDTO tdto = new TicketDTO();
				tdto.setTicket_code(rs.getInt(1));
				tdto.setMember_code(rs.getLong(2));
				tdto.setTime_code(rs.getInt(3));
				tdto.setEndTime(rs.getString(4));
				tdto.setWayTime(rs.getString(5));
				tdto.setAdult(rs.getInt(6));
				tdto.setChild(rs.getInt(7));
				tdto.setBaby(rs.getInt(8));
				tdto.setPrice(rs.getInt(9));
				tdto.setTicket_state(rs.getInt(10));
				tdto.setTicket_date(rs.getString(11));
				tdto.setDeposit(rs.getString(12));
				tdto.setSeat(rs.getString(13));
				tdto.setWayType(rs.getInt(14));
				tdto.setTime_code(rs.getInt(15));
				tdto.setPlane_code(rs.getInt(16));
				tdto.setGo_day(rs.getString(17));
				tdto.setGo_time(rs.getString(18));
				tdto.setStart_point(rs.getString(19));
				tdto.setEnd_point(rs.getString(20));
				tdto.setRemain_seat(rs.getString(21));
				a.add(tdto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
		return a;
	}
	//
	public int adminSearch4Count(String first, String end, long code) {
		getCon();

		int count = 0;
		try {
			String sql = "select count(*) from air_ticket as ticket, air_time as time where ticket.time_code = time.time_code "
					+ "and ticket_date between ? and ? and member_code = ? ";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, first);
			pstm.setString(2, end);
			pstm.setLong(3, code);
			rs = pstm.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		return count;
	}	
	
	// 관리자 검색: 회원 예매날짜, 회원번호
	public ArrayList<TicketDTO> adminSearch4(String first, String end, long code,int startRow,int pageSize){
		ArrayList<TicketDTO> a = new ArrayList<TicketDTO>();
		getCon();
		
		try {
			String sql = "select * from air_ticket as ticket, air_time as time where ticket.time_code = time.time_code "
					+ "and ticket_date between ? and ? and member_code = ? order by ticket_code desc limit ?,?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, first);
			pstm.setString(2, end);
			pstm.setLong(3, code);
			pstm.setInt(4, startRow);
			pstm.setInt(5, pageSize);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				TicketDTO tdto = new TicketDTO();
				tdto.setTicket_code(rs.getInt(1));
				tdto.setMember_code(rs.getLong(2));
				tdto.setTime_code(rs.getInt(3));
				tdto.setEndTime(rs.getString(4));
				tdto.setWayTime(rs.getString(5));
				tdto.setAdult(rs.getInt(6));
				tdto.setChild(rs.getInt(7));
				tdto.setBaby(rs.getInt(8));
				tdto.setPrice(rs.getInt(9));
				tdto.setTicket_state(rs.getInt(10));
				tdto.setTicket_date(rs.getString(11));
				tdto.setDeposit(rs.getString(12));
				tdto.setSeat(rs.getString(13));
				tdto.setWayType(rs.getInt(14));
				tdto.setTime_code(rs.getInt(15));
				tdto.setPlane_code(rs.getInt(16));
				tdto.setGo_day(rs.getString(17));
				tdto.setGo_time(rs.getString(18));
				tdto.setStart_point(rs.getString(19));
				tdto.setEnd_point(rs.getString(20));
				tdto.setRemain_seat(rs.getString(21));
				a.add(tdto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
		return a;
	}
	
	// =========================================== 소리 =============================================

	// =========================================== 다손 =============================================
	
public int memberAllcount(String addsql) {
	getCon();
	int count =0;
	try {
		String sql ="select count(*) from air_member "+addsql;
		System.out.println("카운트 sql 검사"+sql);
		pstm = con.prepareStatement(sql);
		rs = pstm.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}
	} catch (Exception e) {
		System.out.println("회원수 조회 실패");
	}finally {
		close(con, pstm, rs);
	}
	return count;
}
public ArrayList<MemberDTO> memberAllSelect(String addsql,int startRow , int pageSize) {
	getCon();
	ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
	
	try {
		String sql ="select * from air_member "+addsql+" order by member_code desc limit ?,?";
		System.out.println("list sql 검사"+sql);
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, startRow);
		pstm.setInt(2, pageSize);
		rs = pstm.executeQuery();
		while (rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setMember_code(rs.getLong(1));
			dto.setFirst_name(rs.getString(2));
			dto.setLast_name(rs.getString(3));
			dto.setEn_first_name(rs.getString(4));
			dto.setEn_last_name(rs.getString(5));
			dto.setBirth(rs.getInt(6));
			dto.setGender(rs.getInt(7));
			dto.setEmail(rs.getString(8));
			dto.setCountry(rs.getString(9));
			dto.setPhone(rs.getString(10));
			dto.setPostCode(rs.getInt(11));
			dto.setAddr(rs.getString(12));
			dto.setDetail_addr(rs.getString(13));
			dto.setId(rs.getString(14));
			dto.setPw(rs.getString(15));
			dto.setMembar_state(rs.getInt(16));
			dto.setJoindate(rs.getString(17));
			dto.setTel(rs.getString(18));
			list.add(dto);
		}
	} catch (Exception e) {
		System.out.println("회원정보 검색 실패");
	}finally {
		close(con, pstm, rs);
	}
	
	return list;
}

public int boardAllcount(String addsql) {
	getCon();
	int count =0;
	try {
		String sql ="select count(*) from air_board "+addsql;
		System.out.println("카운트 sql 검사"+sql);
		pstm = con.prepareStatement(sql);
		rs = pstm.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}
	} catch (Exception e) {
		System.out.println("회원수 조회 실패");
	}finally {
		close(con, pstm, rs);
	}
	return count;
}

public ArrayList<AdminBoardDTO> boardAllSelect(String addsql,int startRow , int pageSize) {
	getCon();
	ArrayList<AdminBoardDTO> list = new ArrayList<AdminBoardDTO>();
	
	try {
		String sql ="select * from air_board as b  join air_member as m "+
				"where b.member_code = m.member_code "+addsql
				+" order by re_group  desc limit ?,?";
		System.out.println("list sql 검사"+sql);
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, startRow);
		pstm.setInt(2, pageSize);
		rs = pstm.executeQuery();
		while (rs.next()) {
			AdminBoardDTO dto = new AdminBoardDTO();
			dto.setBoard_code(rs.getInt(1));
			dto.setMember_code(rs.getLong(2));
			dto.setTitle(rs.getString(3));
			dto.setContent(rs.getString(4));
			dto.setWrite_date(rs.getString(5));
			dto.setRe_group(rs.getInt(6));
			dto.setRe_leve(rs.getInt(7));
			dto.setRe_state(rs.getInt(8));
			dto.setMember_code(rs.getLong(9));
			dto.setFirst_name(rs.getString(10));
			dto.setLast_name(rs.getString(11));
			dto.setEn_first_name(rs.getString(12));
			dto.setEn_last_name(rs.getString(13));
			dto.setBirth(rs.getInt(14));
			dto.setGender(rs.getInt(15));
			dto.setEmail(rs.getString(16));
			dto.setCountry(rs.getString(17));
			dto.setPhone(rs.getString(18));
			dto.setPostcode(rs.getString(19));
			dto.setAddr(rs.getString(20));
			dto.setDetail_addr(rs.getString(21));
			dto.setId(rs.getString(22));
			dto.setPw(rs.getString(23));
			dto.setMember_state(rs.getInt(24));
			dto.setJoindate(rs.getString(25));
			dto.setTel(rs.getString(26));
			list.add(dto);
		}
	} catch (Exception e) {
		System.out.println("관리자 게시글 검색 실패");
	}finally {
		close(con, pstm, rs);
	}
	
	return list;
}

public ArrayList<AdminBoardDTO> reWriteSelect(int bcode) {
	getCon();
	ArrayList<AdminBoardDTO> list = new ArrayList<AdminBoardDTO>();
	
	try {
		int group = 0;
		
		String groupSql ="select re_group FROM air_board where board_code = ?";
		pstm = con.prepareStatement(groupSql);
		pstm.setInt(1, bcode);
		rs = pstm.executeQuery();
		
		if (rs.next()) {
			group = rs.getInt(1);
		}
		
		if (group!=0) {
			String sql ="select * from air_board as b  join air_member as m "+
					"where b.member_code = m.member_code and re_group = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, group);
			rs = pstm.executeQuery();
			while (rs.next()) {
				AdminBoardDTO dto = new AdminBoardDTO();
				dto.setBoard_code(rs.getInt(1));
				dto.setMember_code(rs.getLong(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setWrite_date(rs.getString(5));
				dto.setRe_group(rs.getInt(6));
				dto.setRe_leve(rs.getInt(7));
				dto.setRe_state(rs.getInt(8));
				dto.setMember_code(rs.getLong(9));
				dto.setFirst_name(rs.getString(10));
				dto.setLast_name(rs.getString(11));
				dto.setEn_first_name(rs.getString(12));
				dto.setEn_last_name(rs.getString(13));
				dto.setBirth(rs.getInt(14));
				dto.setGender(rs.getInt(15));
				dto.setEmail(rs.getString(16));
				dto.setCountry(rs.getString(17));
				dto.setPhone(rs.getString(18));
				dto.setPostcode(rs.getString(19));
				dto.setAddr(rs.getString(20));
				dto.setDetail_addr(rs.getString(21));
				dto.setId(rs.getString(22));
				dto.setPw(rs.getString(23));
				dto.setMember_state(rs.getInt(24));
				dto.setJoindate(rs.getString(25));
				dto.setTel(rs.getString(26));
				list.add(dto);
			}
		}else {
			System.out.println("없는 게시글 입니다");
		}
		
	} catch (Exception e) {
		System.out.println("관리자 게시글 검색 실패");
	}finally {
		close(con, pstm, rs);
	}
	
	return list;
}

public void reWrite(int bcode, String content,int group,long member_code) {
	getCon();
	try {
		String updateSql ="UPDATE air_board SET re_state = ? where board_code = ? and re_group =?";
		pstm = con.prepareStatement(updateSql);
		pstm.setInt(1, 1);
		pstm.setInt(2, bcode);
		pstm.setInt(3, group);
		pstm.executeUpdate();
		
		String insertSql ="insert into air_board(member_code,title,content,write_date,re_group,re_level,re_state)"+
		" values(?,?,?,now(),?,?,?)";
		pstm =con.prepareStatement(insertSql);
		pstm.setLong(1, member_code); // 관리자 코드
		pstm.setString(2, "답글");
		pstm.setString(3, content);
		pstm.setInt(4, group);
		pstm.setInt(5, 2);
		pstm.setInt(6, 1);
		pstm.executeUpdate();
	} catch (Exception e) {
		System.out.println("관리자 회원 답글 실패");
	}finally {
		close(con, pstm, rs);
	}
}

public void adminUpdateMember(long code) {
	getCon();
	try {
		String sql ="UPDATE air_member SET membar_state = 0 where member_code  = ?";
		pstm =con.prepareStatement(sql);
		pstm.setLong(1,code);
		pstm.executeUpdate();
	} catch (Exception e) {
		System.out.println("관리자 탈퇴 회원 전환실패");
	}finally {
		close(con, pstm, rs);
	}
}
	// =========================================== 다손 =============================================
	
}
























