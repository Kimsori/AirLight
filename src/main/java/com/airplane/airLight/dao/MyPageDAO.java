package com.airplane.airLight.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.airplane.airLight.dto.BoardDTO;
import com.airplane.airLight.dto.MemberDTO;
import com.airplane.airLight.dto.PointDTO;
import com.airplane.airLight.dto.TicketDTO;

public class MyPageDAO {

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

	// ===========================================================
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

	//------------------다손---------------------------

	//=========================================================
	public long selectCode(String id) {
		getCon();
		long  code = 0;
		try {
			String sql = "select member_code from air_member where id = ? ";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			
			if (rs.next()) {
				code = rs.getLong(1); // 아이디가 들어오면 회원코드 추출
			}else {
				code = Long.parseLong(id); // 회원코드가 들어오면 형변환 하여 반환
			}
			
		} catch (Exception e) {
			System.out.println("로그인한 회원 코드 추출 실패");
		}finally {
			close(con, pstm, rs);
		}
		return  code;
		
	}
	// 로그인한 회원정보로 정보 셀렉트
	public MemberDTO memberInfo(long code) {

		getCon();
		MemberDTO dto = new MemberDTO();
		try {
			String sql = "select * from air_member where member_code = ?";
			pstm = con.prepareStatement(sql);
			
			pstm.setLong(1,code);
			
			rs = pstm.executeQuery();

			if (rs.next()) {
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
			}

		} catch (Exception e) {
			System.out.println("회원정보 조회 실패");
		} finally {
			close(con, pstm, rs);
		}

		return dto;
	}
	//===========================================================
	//회원 탈퇴 
	public void memberUpdateState(long code) {
		getCon();
		try {
			String sql ="upadte air_member set membar_state = 2 where member_code =?";
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, code);
			pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("회원상태 변경 오류");
		}finally {
			close(con, pstm, rs);
		}
	}
	//===========================================================
	// 회원정보 수정 
	public void memberUpdata(MemberDTO dto) {
		getCon();
		try {
			String sql = "UPDATE air_member SET first_name = ?, last_name= ?, en_first_name= ?, "
					+ "en_last_name= ?,birth= ?, email= ?, phone= ?,postCode= ?, addr= ?,"
					+ " detail_addr= ?, tel= ? WHERE member_code = ?";
			pstm =con.prepareStatement(sql);
			pstm.setString(1, dto.getFirst_name());
			pstm.setString(2, dto.getLast_name());
			pstm.setString(3, dto.getEn_first_name());
			pstm.setString(4, dto.getEn_last_name());
			pstm.setInt(5, dto.getBirth());
			pstm.setString(6, dto.getEmail());
			pstm.setString(7, dto.getPhone());
			pstm.setInt(8, dto.getPostCode());
			pstm.setString(9, dto.getAddr());
			pstm.setString(10, dto.getDetail_addr());
			pstm.setString(11, dto.getTel());
			pstm.setLong(12, dto.getMember_code());
			pstm.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("회원정보수정 실패");
		}finally {
			close(con, pstm, rs);
		}
	}
	// ==========================================================
	// 회원 비밀번호 변경
	public void userPwUpdate(String pw,long code) {
		getCon();
		try {
			String sql="UPDATE air_member SET pw=? where member_code=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, pw);
			pstm.setLong(2, code);
			pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("비밀번호 변경 실패");
		}finally {
			close(con, pstm, rs);
		}
	}
	// ==========================================================
	// 로그인한 회원 마일리지 테이블 내역 카운트 후 반환
	public int memberPointCount(long code) {
		getCon();

		int count = 0;
		try {
			String sql = "select count(*) from air_point where member_code=?";
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, code);
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
	
	// =============================================================
	// 회원 총 포인트 출력
	public int memberTotalPoint(long code) {
		getCon();
		int total = 0;
		try {
			String sql ="select sum(point_price) from air_point where member_code = ?";
			pstm =con.prepareStatement(sql);
			pstm.setLong(1, code);
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				total = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("로그인 회원 총포인트 조회 실패");
		}finally {
			close(con, pstm, rs);
		}
		
		return total;
	}

	// =============================================================
	// 회원 포인트 내역 페이징 추출
	public ArrayList<PointDTO> memberPoint(long code,int startRow,int pageSize) {
		getCon();
		ArrayList<PointDTO> pointlist = new ArrayList<PointDTO>();

		try {
			String sql = "select * from air_point where member_code =? order by point_code desc limit ?,?  ";
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, code);
			pstm.setInt(2, startRow);
			pstm.setInt(3, pageSize);
			rs = pstm.executeQuery();
			while (rs.next()) {
				PointDTO dto = new PointDTO();
				dto.setPoint_code(rs.getInt(1));
				dto.setMember_code(rs.getLong(2));
				dto.setPoint_price(rs.getInt(3));
				dto.setPoint_content(rs.getString(4));
				dto.setPoint_date(rs.getString(5));
				pointlist.add(dto);
			}
		} catch (Exception e) {
			System.out.println("포인트 페이징 실패");
		} finally {
			close(con, pstm, rs);
		}
		return pointlist;
	}

	// ==========================================================
	// 로그인한 회원 Q&A내역 카운트
	public int memberBoardCount(long code) {
		getCon();

		int count = 0;
		try {
			String sql = "select count(*) from air_board where member_code=?";
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, code);
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

	// =============================================================
	// Q&A 게시판 페이징 추출
	public ArrayList<BoardDTO> memberBoard(long code,int startRow,int pageSize) {
		getCon();
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();

		try {
			String sql = "select * from air_board where member_code =? order by board_code desc limit ?,?";
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, code);
			pstm.setInt(2, startRow);
			pstm.setInt(3, pageSize);
			rs = pstm.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();

				dto.setBoard_code(rs.getInt(1));
				dto.setMember_code(rs.getLong(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setWrite_date(rs.getString(5));
				dto.setRe_group(rs.getInt(6));
				dto.setRe_leve(rs.getInt(7));
				dto.setRe_state(rs.getInt(8));
				System.out.println("보드dao추출"+rs.getInt(8));
				boardlist.add(dto);
			}
		} catch (Exception e) {
			System.out.println("Q&A 페이징 추출 실패");
		} finally {
			close(con, pstm, rs);
		}
		return boardlist;
	}
	
	// =============================================================
	// QnA게시판 글작성
	public void writeBoard(BoardDTO dto) {
		getCon();
		int re_group =0;
		try {
			String resql ="select max(re_group) from air_board";
			pstm =con.prepareStatement(resql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				re_group =rs.getInt(1)+1;
			}
			System.out.println("re_group:"+re_group);
			System.out.println(dto.getMember_code());
			System.out.println(dto.getTitle());
			System.out.println(dto.getContent());
			String sql ="insert into air_board(member_code,title,content,write_date,re_group,re_level,re_state)"
					+ "values(?,?,?,now(),?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, dto.getMember_code());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			pstm.setInt(4, re_group);
			pstm.setInt(5, 1);
			pstm.setInt(6, 0);
			pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("글쓰기 실패");
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
		
		
	}
	// =============================================================
	// QnA게시글 선택 추출
	
	public ArrayList<BoardDTO> oneBoard(int groupNum) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		getCon();
		try {
			String sql = "select * from air_board where re_group =?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, groupNum);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_code(rs.getInt(1));
				dto.setMember_code(rs.getLong(2));
				dto.setTitle(rs.getString(3));							
				dto.setContent(rs.getString(4));
				dto.setWrite_date(rs.getString(5));
				dto.setRe_group(rs.getInt(6));
				dto.setRe_leve(rs.getInt(7));
				dto.setRe_state(rs.getInt(8));
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("글 검색 실패");
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
		
		return list;
	}
	
	// =============================================================
		// QnA게시글 선택 삭제
		
		public void boardDelete(int board_code) {
			
			getCon();
			try {
				String sql = "delete from  air_board where board_code =?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, board_code);
				pstm.executeUpdate();				
				
			} catch (Exception e) {
				System.out.println("글 삭제 실패");
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
			
		}
		
		// =============================================================
		// QnA게시글 수정 추출
		
		public BoardDTO boardSelectUpdate(int board_code) {
			
			getCon();
			BoardDTO dto = new BoardDTO();
			try {
				String sql = "select * from  air_board where board_code =?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, board_code);
				rs = pstm.executeQuery();
				if (rs.next()) {
					dto.setBoard_code(rs.getInt(1));
					dto.setMember_code(rs.getLong(2));
					dto.setTitle(rs.getString(3));							
					dto.setContent(rs.getString(4));
					dto.setWrite_date(rs.getString(5));
					dto.setRe_group(rs.getInt(6));
					dto.setRe_leve(rs.getInt(7));
					dto.setRe_state(rs.getInt(8));
				}
				
			} catch (Exception e) {
				System.out.println("수정글 추출 실패");
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
			return dto;
		}
		// =============================================================
				// QnA게시글 수정
				
				public void boardUpdate(int board_code,String title,String content) {
					
					getCon();
					try {
						String sql = "UPDATE air_board SET title=?,content =? where board_code=?";
						pstm = con.prepareStatement(sql);
						pstm.setString(1, title);
						pstm.setString(2, content);
						pstm.setInt(3, board_code);
						pstm.executeUpdate();				
						
					} catch (Exception e) {
						System.out.println("글 수정 실패");
						e.printStackTrace();
					}finally {
						close(con, pstm, rs);
					}
					
				}
	
	//============================================
	public void userDelete(Long member_code) {

		getCon();
		try {
			String sql = "UPDATE air_member SET membar_state=1 where member_code=?";
			pstm = con.prepareStatement(sql);
			pstm.setLong(1,member_code);
			pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("회원 상태 탈퇴 회원으로 변경 실패");
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}

	}
	
	
	//------------------다손---------------------------
				// 티켓 게시판 카운트
				public int ticketListCount(long code) {
					getCon();

					int count = 0;
					try {
						String sql = "select count(*) from air_ticket as ticket, air_time as time where ticket.time_code = time.time_code and member_code=?";
						pstm = con.prepareStatement(sql);
						pstm.setLong(1, code);
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
				
	// ============================================================ 소리 ===========================================================
	
		// 회원이 예매한 정보 출력
		public ArrayList<TicketDTO> ticketList(Long memberCode,int startRow,int pageSize){
			ArrayList<TicketDTO> a = new ArrayList<TicketDTO>();
			getCon();
			
			try {
				String sql = "select * from air_ticket as ticket, air_time as time where ticket.time_code = time.time_code and member_code=? order by ticket_code desc limit ?,?";
				pstm = con.prepareStatement(sql);
				pstm.setLong(1, memberCode);
				pstm.setInt(2, startRow);
				pstm.setInt(3, pageSize);
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
		
			
		// 공항의 나라 찾는 DAO
		public String country(String name) {
			String countryName = "";
			getCon();
			
			try {
				String sql = "select country_name from air_country as c, air_port as p where c.country_code=p.country_code and port_name=?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, name);
				rs = pstm.executeQuery();
				
				if(rs.next()) {
					countryName = rs.getString(1);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
			return countryName;
		}
		
		// 회원상태 업데이트
		public void state(int myState, int code) {
			getCon();
			
			try {
				String sql = "update air_ticket set ticket_state=? where ticket_code=?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, myState);
				pstm.setInt(2, code);
				pstm.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
		}
		
		// 회원상태 업데이트
		public void state2(int myState, int way) {
			getCon();
			
			try {
				String sql = "update air_ticket set ticket_state=? where wayType=?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, myState);
				pstm.setInt(2, way);
				pstm.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
		}
		
		// 마일리지 
		public void point(Long member, double price, String content) {
			getCon();
			
			try {
				String sql = "insert into air_point (member_code, point_price, point_content, point_date) values(?,?,?,now())";
				pstm = con.prepareStatement(sql);
				pstm.setLong(1, member);
				pstm.setDouble(2, price);
				pstm.setString(3, content);
				pstm.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
		}
		
		// 입금일 
		public void inputDay(int code) {
			getCon();
			
			try {
				String sql = "update air_ticket set deposit = now() where ticket_code = ?";
				pstm = con.prepareStatement(sql);
				pstm.setLong(1, code);
				pstm.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
		}
		
		// 입금일2 
		public void inputDay2(int way) {
			getCon();
			
			try {
				String sql = "update air_ticket set deposit = now() where wayType = ?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, way);
				pstm.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
		}
		
		// 왕복일때 총 가격 찾기
		public int selectMaxPrice(int way) {
			int price = 0;
			getCon();
			
			try {
				String sql = "select max(price) from air_ticket where wayType = ?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, way);
				rs = pstm.executeQuery();
				
				if(rs.next()) {
					price = rs.getInt(1);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
			return price;
		}
		
		// 왕복일때 도착 공항
		public String findEndPoint(int way, String endPoint) {
			String point = "";
			getCon();
			
			try {
				String sql = "select end_point from air_ticket as t, air_time as time where time.time_code = t.time_code and wayType=? and end_point != ?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, way);
				pstm.setString(2, endPoint);
				rs = pstm.executeQuery();
				
				if(rs.next()) {
					point = rs.getString(1);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
			return point;
		}	
		
		// 당일예매 시 출발시간-2시간 이내까지 미입금시 자동 취소
		public void autoMoneyToday() {
			getCon();
			
			try {
				String sql = "update air_ticket as tic, air_time as time set ticket_state = 7 where tic.time_code = time.time_code "
						+ "and DATE_FORMAT(now(), '%Y-%m-%d')=go_day and "
						+ "hour(now())*60+minute(now())+120>=cast(left(go_time,2) as unsigned)*60+cast(right(go_time,2) as unsigned) "
						+ "and ticket_state=0";
				pstm = con.prepareStatement(sql);
				pstm.executeUpdate();
				
				// 왕복일 경우
				String sql22 = "select wayType from air_ticket where ticket_state = 7";
				pstm = con.prepareStatement(sql22);
				rs = pstm.executeQuery();
				
				while(rs.next()) {
					int way = rs.getInt(1);
					String sql222 = "update air_ticket set ticket_state = 7 where wayType>1 and wayType = ?";
					pstm = con.prepareStatement(sql222);
					pstm.setInt(1, way);
					pstm.executeUpdate();
				}
				
				// 자동 취소 시 남아있는 좌석 원래대로
				String sql2 = "update air_time as time, air_ticket as tic set remain_seat = remain_seat + (adult+child+baby) "
						+ "where time.time_code = tic.time_code and ticket_state = 7";
				pstm = con.prepareStatement(sql2);
				pstm.executeUpdate();
				
				String sql3 = "select seat from air_ticket where ticket_state = 7";
				pstm = con.prepareStatement(sql3);
				rs = pstm.executeQuery();
				
				// 자동 취소 시 예매했던 좌석들 예매 가능 상태로
				while(rs.next()) {
					String i = rs.getString(1);
					String[] j = i.split(", ");
					for(int z = 0; z<j.length; z++) {
						String sql4 = "update air_seat as s, air_time as time, air_ticket as tic set seat_state=0 "
								+ "where time.time_code = tic.time_code and time.time_code = s.time_code and ticket_state = 7 "
								+ "and seat_state = 1 and seat_name=?";
						pstm = con.prepareStatement(sql4);
						System.out.println(j[z]);
						pstm.setString(1, j[z]);
						pstm.executeUpdate();
					}
				}
				
				String sql5 = "update air_ticket set ticket_state = 5 where ticket_state = 7";
				pstm = con.prepareStatement(sql5);
				pstm.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
		}
		
		// 24시간 이내에 입금 안할시 자동 미입금 처리
		public void autoMoney() {
			getCon();
			
			try {
				String sql = "update air_ticket set ticket_state = 7 where now()>(DATE_ADD(ticket_date, INTERVAL 1 DAY)) "
						+ "and ticket_state=0";
				pstm = con.prepareStatement(sql);
				pstm.executeUpdate();
				
				// 왕복일 경우
				String sql22 = "select wayType from air_ticket where ticket_state = 7";
				pstm = con.prepareStatement(sql22);
				rs = pstm.executeQuery();
				
				while(rs.next()) {
					int way = rs.getInt(1);
					String sql222 = "update air_ticket set ticket_state = 7 where wayType = ?";
					pstm = con.prepareStatement(sql222);
					pstm.setInt(1, way);
					pstm.executeUpdate();
				}
				
				// 자동 취소 시 남아있는 좌석 원래대로
				String sql2 = "update air_time as time, air_ticket as tic set remain_seat = remain_seat + (adult+child+baby) "
						+ "where time.time_code = tic.time_code and ticket_state = 7";
				pstm = con.prepareStatement(sql2);
				pstm.executeUpdate();
				
				String sql3 = "select seat from air_ticket where ticket_state = 7";
				pstm = con.prepareStatement(sql3);
				rs = pstm.executeQuery();
				
				// 자동 취소 시 예매했던 좌석들 예매 가능 상태로
				while(rs.next()) {
					String i = rs.getString(1);
					String[] j = i.split(", ");
					for(int z = 0; z<j.length; z++) {
						String sql4 = "update air_seat as s, air_time as time, air_ticket as tic set seat_state=0 "
								+ "where time.time_code = tic.time_code and time.time_code = s.time_code and ticket_state = 7 "
								+ "and seat_state = 1 and seat_name=?";
						pstm = con.prepareStatement(sql4);
						System.out.println(j[z]);
						pstm.setString(1, j[z]);
						pstm.executeUpdate();
					}
				}
				
				String sql5 = "update air_ticket set ticket_state = 5 where ticket_state = 7";
				pstm = con.prepareStatement(sql5);
				pstm.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
		}
		
		// 탑승일로부터 -5일 이내부터 환불 불가능
		public void autoRefund() {
			getCon();
			
			try {
				String sql = "update air_ticket, air_time set ticket_state = 6 where air_ticket.time_code = air_time.time_code "
		                  + "and ticket_state = 1 and DATE_FORMAT(now(), '%Y-%m-%d')>DATE_ADD(go_day, INTERVAL -5 DAY)";
				pstm = con.prepareStatement(sql);
				pstm.executeUpdate();
				
				String selectSql2 = "select count(wayType) from air_ticket where ticket_state=6 and wayType!=1";
				pstm = con.prepareStatement(selectSql2);
				rs = pstm.executeQuery();
				int num = 0;
				
				if(rs.next()) {
					num = rs.getInt(1);
				}
				System.out.println("num"+num);
				
				String selectSql = "select wayType from air_ticket where ticket_state=6 and wayType!=1";
				pstm = con.prepareStatement(selectSql);
				rs = pstm.executeQuery();
				int [] way = new int[num];
				int i = 0;
				
				while(rs.next()) {
					way[i] = rs.getInt(1);
					System.out.println(i + "번째: "+way[i]);
					i = i + 1;
				}
				
				for(int j = 0; j<way.length; j++) {
					String updateSql = "update air_ticket set ticket_state = 6 where wayType = ?";
					pstm = con.prepareStatement(updateSql);
					pstm.setInt(1, way[j]);
					pstm.executeUpdate();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
		}
		
		// 탑승완료 자동
		public void autoPlane() {
			getCon();
			
			try {
				// 오늘 날짜 탑승완료
				String sql = "update air_ticket as tic, air_time as time set ticket_state=2 "
						+ "where time.time_code = tic.time_code and now()>=go_day "
						+ "and date_format(curtime(),'%H')=cast(left(go_time, 2) as signed) "
						+ "and date_format(curtime(),'%i')>=cast(substring(go_time, 5, 2) as signed) "
						+ "and ticket_state = 6";
				pstm = con.prepareStatement(sql);
				pstm.executeUpdate();
				
				// 오늘 날짜 탑승완료
				String sql6 = "update air_ticket as tic, air_time as time set ticket_state=2 "
						+ "where time.time_code = tic.time_code and now()>=go_day "
						+ "and date_format(curtime(),'%H')>cast(left(go_time, 2) as signed) "
						+ "and ticket_state = 6";
				pstm = con.prepareStatement(sql6);
				pstm.executeUpdate();
				
				// 지난 날짜들 탑승 완료
				// 년도와 달이 같고 탑승날짜가 오늘 날짜보다 작을때
				String sql2 = "update air_ticket, air_time set air_ticket.ticket_state=2 "
						+ "where air_time.time_code = air_ticket.time_code and year(now())=cast(left(go_day,4) as unsigned) "
						+ "and month(now())=cast(substring(go_day,6,2) as unsigned) "
						+ "and day(now())>cast(substring(go_day,9,2) as unsigned) and ticket_state = 6";
				pstm = con.prepareStatement(sql2);
				pstm.executeUpdate();
				
				// 년도가 같고 탑승 달이 오늘 날짜보다 작을때
				String sql3 = "update air_ticket, air_time set ticket_state=2 "
						+ "where air_time.time_code = air_ticket.time_code and year(now())=cast(left(go_day,4) as unsigned) "
						+ "and month(now())>cast(substring(go_day,6,2) as unsigned) and ticket_state = 6";
				pstm = con.prepareStatement(sql3);
				pstm.executeUpdate();
				
				// 년도가 탑승 년도보다 작을때
				String sql4 = "update air_ticket, air_time set ticket_state=2 "
						+ "where air_time.time_code = air_ticket.time_code and year(now())>cast(left(go_day,4) as unsigned) "
						+ "and ticket_state = 6";
				pstm = con.prepareStatement(sql4);
				pstm.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
		}
		
		// wayType으로 time_code 찾는 DAO
		public ArrayList<TicketDTO> findCode(int way){
			ArrayList<TicketDTO> a = new ArrayList<>();
			getCon();
			
			try {
				String sql = "select time_code from air_ticket where wayType = ?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, way);
				rs = pstm.executeQuery();
				
				while(rs.next()) {
					TicketDTO tdto = new TicketDTO();
					tdto.setTime_code(rs.getInt(1));
					a.add(tdto);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstm, rs);
			}
			return a;
		}
		
		
		// ============================================================= 소리 ==========================================================
		
		

}
