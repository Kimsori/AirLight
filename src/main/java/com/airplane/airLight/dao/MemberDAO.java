package com.airplane.airLight.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.airplane.airLight.dto.MemberDTO;
import com.airplane.airLight.dto.TicketDTO;

public class MemberDAO {
	
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
			// ������DB ����̹� �ε� �Ѵ�.
			Class.forName("org.mariadb.jdbc.Driver");
			// ������DB (�������� :mariadb://������I host P�ּ� : ��Ʈ��ȣ/DB �̸� ","���̵�","�н�����") ����
			con = DriverManager.getConnection(url, id, pw);
			/*con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/DB","root","root");*/
			System.out.println("DB ���� �Ϸ�");
		}catch(Exception e) {
			System.out.println("JDBC ����̹� �ε� ����");
		}
	}
	
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(conn != null) {conn.close();}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// ================================================= �Ҹ� ===========================================================
	
	// �ɹ� ���̵�� �ɹ��ڵ� ã�� DAO
	public long findMemberCoder(String id) {
		long code = 0;
		getCon();
		
		try {
			String sql = "select member_code from air_member where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				code = rs.getLong(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
		return code;
	}
	
	// ���̵� �ߺ�üũ
	public int dupleId(String id) {
		int cnt = 0;
		getCon();
		
		try {
			String sql = "select count(id) from air_member where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
		return cnt;
	}
	
	
	// ================================================= �Ҹ� ===========================================================
	
	//=========================================================
		//===============ȸ�� ���� insert ��===================
	public void JoinInsert(MemberDTO mdto) {
		getCon();
		
		try {
			String sql = "insert into air_member values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,now(),?)";
			pstm = con.prepareStatement(sql);
			pstm.setLong(1,mdto.getMember_code());
			pstm.setString(2, mdto.getFirst_name());
			pstm.setString(3, mdto.getLast_name());
			pstm.setString(4, mdto.getEn_first_name());
			pstm.setString(5, mdto.getEn_last_name());
			pstm.setInt(6, mdto.getBirth());
			pstm.setInt(7, mdto.getGender());
			pstm.setString(8, mdto.getEmail());
			pstm.setString(9, mdto.getCountry());
			pstm.setString(10, mdto.getPhone());
			pstm.setString(11, mdto.getPostcode());
			pstm.setString(12, mdto.getAddr());
			pstm.setString(13, mdto.getDetail_addr());
			pstm.setString(14, mdto.getId());
			pstm.setString(15, mdto.getPw());
			pstm.setString(16, mdto.getTel());
			pstm.executeUpdate();
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
	}
	//==================================================
		//======ȸ���ڵ� ���� ============
	public int membercode(String sysd) {
		getCon();
		int a =0;
		try {
			String sql =  "select count(*) from air_member where member_code like ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, sysd);
			rs =pstm.executeQuery();
			if (rs.next()) {
				a = rs.getInt(1)+1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstm, rs);
		}
		return a;
	}
	//===================================================
		//=======�α��� ID================
	public String loginid(String id) {
		String loginid = "";
		getCon();
		try {
			String sql = "select id from air_member where id = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				loginid = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		
		return loginid;
	}
	//=====================================================
		//======�α��� ��й�ȣ 
	public String loginpw(String id) {
		String loginpw = "";
		getCon();
		
		try {
			String sql = "select pw from air_member where id  = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				loginpw = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		return loginpw;
	}
	//========================================================
		//=====ȸ�� ���� üũ ====
	public int state(String id,String pw) {
			getCon();
			int state = 0;
		try {
			String sql = "select membar_state from air_member where id = ?  and pw = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			rs = pstm.executeQuery();
			if(rs.next()) {
				state = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		return state;
	}
	//===================================================
			//=======ȸ���ڵ�� ���̵� �� �� �α���================
		public long membercodeid(long member_code) {
			long membercodeid = 0;
			getCon();
			try {
				String sql = "select member_code from air_member where member_code = ?";
				pstm = con.prepareStatement(sql);
				pstm.setLong(1, member_code);
				rs = pstm.executeQuery();
				if(rs.next()) {
					membercodeid = rs.getLong(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, pstm, rs);
			}
			
			return membercodeid;
		}
		//===================================================
		//=======ȸ���ڵ�� ��й�ȣ �� ��  �α���================
		public String membercodepw(long member_code) {
		String membercodepw = "";
		getCon();
		try {
			String sql = "select pw from air_member where member_code = ?";
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, member_code);
			rs = pstm.executeQuery();
			if(rs.next()) {
				membercodepw = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		
		return membercodepw;
	}

		//========================================================
			//=====ȸ�� ���� üũ ====
		public int codestate(long member_code ,String pw) {
				getCon();
				int state = 0;
			try {
				String sql = "select membar_state from air_member where member_code = ?  and pw = ?";
				
				pstm = con.prepareStatement(sql);
				pstm.setLong(1, member_code);
				pstm.setString(2, pw);
				rs = pstm.executeQuery();
				if(rs.next()) {
					state = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, pstm, rs);
			}
			return state;
		 }
		//===========================================================
		//======���̵� ã�� (ȸ���ڵ��)===
		public String idsearch(long member_code , int birth) {
			String idsearch = "";
			getCon();
			try {
				String sql = "select id from air_member where member_code = ? and birth = ? ";
				pstm = con.prepareStatement(sql);
				pstm.setLong(1, member_code);
				pstm.setInt(2, birth);
				rs = pstm.executeQuery();
				if(rs.next()) {
					idsearch = rs.getString(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, pstm, rs);
			}
			
			return idsearch;
		}
		//===========================================================
				//======���̵� ã�� (�̸����ּҷ�)===
				public String idsearch1(String email , int birth) {
					String idsearch1 = "";
					getCon();
					try {
						String sql = "select id from air_member where email = ? and birth = ? ";
						pstm = con.prepareStatement(sql);
						pstm.setString(1, email);
						pstm.setInt(2, birth);
						rs = pstm.executeQuery();
						if(rs.next()) {
							idsearch1 = rs.getString(1);
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						close(con, pstm, rs);
					}
					
					return idsearch1;
				}
		//=====================================================
				//=====������� �񱳽�
			public int birthsearch(int birth) {
				int birthsearch = 0;
				getCon();
				try {
					String sql = "select birth from air_member where birth = ?";
					pstm = con.prepareStatement(sql);
					pstm.setInt(1, birth);
					rs = pstm.executeQuery();
					
					if(rs.next()) {
						birthsearch = rs.getInt(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(con, pstm, rs);
				}
				
				return birthsearch;
			}
			//=====================================================
				//=====�ɹ��ڵ� �񱳽�
			public long membercodesearch(long member_code) {
				
				getCon();
				long membercodesearch = 0;
				try {
					String sql = "select member_code from air_member where member_code = ?";
					pstm = con.prepareStatement(sql);
					pstm.setLong(1, member_code);
					rs = pstm.executeQuery();
					if(rs.next()) {
						membercodesearch = rs.getLong(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return membercodesearch;
			}
			//=======================================================
				//==== �̸��� �񱳽�
			public String emailsearch(String email) {
				String emailsearch = "";
				getCon();
				try {
					String sql = "select email from air_member where email = ?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, email);
					rs = pstm.executeQuery();
					if(rs.next()) {
						emailsearch = rs.getString(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return emailsearch;
			}
			//========================================================
				//=====��й�ȣ ã�� DAO 
			public String pwsearch(String id,String en_first_name,int birth) {
				String pwsearch = "";
				getCon();
				try {
					String sql = "select pw from air_member where id = ? and en_first_name = ? and birth = ?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, id);
					pstm.setString(2, en_first_name);
					pstm.setInt(3, birth);
					rs = pstm.executeQuery();
					if(rs.next()) {
						pwsearch = rs.getString(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(con, pstm, rs);
				}
				
				return pwsearch;
			}
			//========================================================
			//=====��й�ȣ ã�� DAO 
			public int pwcnt(String id,String en_first_name,int birth) {
			int pwcnt = 0;
			getCon();
			try {
				String sql = "select count(*) from air_member where id = ? and en_first_name = ? and birth = ?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, id);
				pstm.setString(2, en_first_name);
				pstm.setInt(3, birth);
				rs = pstm.executeQuery();
				if(rs.next()) {
					pwcnt = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, pstm, rs);
			}
			
			return pwcnt;
		}
			//========================================================
				//=====ȸ���ڵ�ã�� �޴��� ��ȣ
			public String phonesearch(String en_first_name,String en_last_name,String phone,int birth) {
				String phonesearch = "";
				getCon();
				try {
					String sql = "select member_code from air_member where en_first_name = ? "
							+ "and en_last_name = ? and phone = ? and birth = ?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, en_first_name);
					pstm.setString(2, en_last_name);
					pstm.setString(3, phone);
					pstm.setInt(4, birth);
					rs = pstm.executeQuery();
					if(rs.next()) {
						phonesearch = rs.getString(1);
					}
						
				} catch (Exception e) {
					e.printStackTrace();
				}
				return phonesearch;
			}
			//========================================================
				//=====ȸ���ڵ�ã��  �̸��� �ּ�
			public String emailsearchs(String en_first_name,String en_last_name,String email,int birth) {
				String emailsearchs = "";
				getCon();
				try {
					String sql = "select member_code from air_member where en_first_name = ? "
							+ "and en_last_name = ? and email = ? and birth = ?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, en_first_name);
					pstm.setString(2, en_last_name);
					pstm.setString(3, email);
					pstm.setInt(4, birth);
					rs = pstm.executeQuery();
					if(rs.next()) {
						emailsearchs = rs.getString(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return emailsearchs;
			}
			//========================================================
				//===== pw �� �־��ִ� DAO 
			public String insertpw(String id) {
				getCon();
				String insertpw = "";
				try {
					String sql = "select pw from air_member where id = ?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, id);
					rs = pstm.executeQuery();
					
					if(rs.next()) {
						insertpw = rs.getString(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return insertpw;
			}
			//========================================================
				//===== ������ �� �����ִ� DAO
			public String enfirstname(String en_first_name) {
				String enfirstname = "";
				getCon();
				try {
					String sql  = "select pw from air_member where en_first_name = ?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, en_first_name);
					rs = pstm.executeQuery();
					if(rs.next()) {
						enfirstname = rs.getString(1);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(con, pstm, rs);
				}
				return enfirstname;
			}
			//========================================================
			//=====  ���� ��,�̸�,�޴���,������� �� membercode �����ϴ� DAO 
			public long membercodesch(String en_first_name,String en_last_name,String phone,int birth) {
				long membercodesch = 0;
				getCon();
				try {
					String sql = "select member_code from air_member where en_first_name = ? and en_last_name = ?"
							+ "and phone = ? and birth = ?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, en_first_name);
					pstm.setString(2, en_last_name);
					pstm.setString(3, phone);
					pstm.setInt(4,birth);
					rs = pstm.executeQuery();
					if(rs.next()) {
						membercodesch = rs.getLong(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(con, pstm, rs);
				}
				
				return membercodesch;
			}
			
			//========================================================
			//=====  ���� ��,�̸�,�޴���,������� �� membercode ī��Ʈ���ϴ� DAO 
			public int membercodecnt(String en_first_name,String en_last_name,String phone,int birth) {
				int membercodecnt = 0;
				getCon();
				try {
					String sql = "select count(*) from air_member where en_first_name = ? and en_last_name = ? "
							+ "and phone = ? and birth = ?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, en_first_name);
					pstm.setString(2, en_last_name);
					pstm.setString(3, phone);
					pstm.setInt(4,birth);
					rs = pstm.executeQuery();
					if(rs.next()) {
						membercodecnt = rs.getInt(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(con, pstm, rs);
				}
				
				return membercodecnt;
			}
			//========================================================
			//===== ���� ��,�̸�,�̸���,������� �� membercode �����ϴ� DAO 
			public long membercodesch2(String en_first_name,String en_last_name,String email,int birth) {
				long membercodesch = 0;
				getCon();
				try {
					String sql = "select member_code from air_member where en_first_name = ? and en_last_name = ?"
							+ "and email = ? and birth = ?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, en_first_name);
					pstm.setString(2, en_last_name);
					pstm.setString(3, email);
					pstm.setInt(4,birth);
					rs = pstm.executeQuery();
					if(rs.next()) {
						membercodesch = rs.getLong(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(con, pstm, rs);
				}
				
				return membercodesch;
			}
			//========================================================
			//=====  ���� ��,�̸�,�̸���,������� �� membercode ī��Ʈ���ϴ� DAO 
			public int membercodecnt1(String en_first_name,String en_last_name,String email,int birth) {
				int membercodecnt1 = 0;
				getCon();
				try {
					String sql = "select count(*) from air_member where en_first_name = ? and en_last_name = ?"
							+ "and email = ? and birth = ?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, en_first_name);
					pstm.setString(2, en_last_name);
					pstm.setString(3, email);
					pstm.setInt(4,birth);
					rs = pstm.executeQuery();
					if(rs.next()) {
						membercodecnt1 = rs.getInt(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(con, pstm, rs);
				}
				
				return membercodecnt1;
			}
			//==========================================
				//=====
			public long memcode(String phone) {
				long memcode = 0;
				getCon();
				
				try {
					String sql = "select member_code from air_member where phone = ?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, phone);
					rs = pstm.executeQuery();
					if(rs.next()) {
						memcode = rs.getLong(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return memcode;
			}
			//==========================================
			//=====
			public long memcodes(String email) {
			long memcodes = 0;
			getCon();
			
			try {
				String sql = "select member_code from air_member where email = ?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, email);
				rs = pstm.executeQuery();
				if(rs.next()) {
					memcodes = rs.getLong(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return memcodes;
		}
			//======================================
				//============
			public int idcnt(long member_code,int birth) {
				int idcnt = 0;
				getCon();
				
				try {
					String sql = "select count(*) from air_member where member_code = ? and birth = ?";
					pstm = con.prepareStatement(sql);
					pstm.setLong(1, member_code);
					pstm.setInt(2, birth);
					rs = pstm.executeQuery();
					if(rs.next()) {
						idcnt = rs.getInt(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return idcnt;
			}
			//======================================
			//============
		public int idcnt1(String email,int birth) {
			int idcnt1 = 0;
			getCon();
			
			try {
				String sql = "select count(*) from air_member where email = ? and birth = ?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, email);
				pstm.setInt(2, birth);
				rs = pstm.executeQuery();
				if(rs.next()) {
					idcnt1 = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return idcnt1;
		}
		//================���̵� �ߺ�Ȯ��
			//====================
		public int idchk(String id) {
			int idchk = 0;
			getCon();
			try {
				String sql = "select count(*) from air_member where id = ?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, id);
				rs = pstm.executeQuery();
				if(rs.next()) {
					idchk = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, pstm, rs);
			}
			return idchk;
		}
		
		// �α��� �ϸ� �̸�����
		public String getName(long code) {
			String name ="";
			getCon();
			try {
				String sql ="select first_name , last_name  from air_member where member_code = ? ";
				pstm =con.prepareStatement(sql);
				pstm.setLong(1, code);
				rs = pstm.executeQuery();
				if (rs.next()) {
					name = rs.getString(1)+rs.getString(2);
				}
			} catch (Exception e) {
				System.out.println("�α��� ȸ�� �̸� ���� ����");
			} finally {
				close(con, pstm, rs);
			}
			return name;
		}
}
			
