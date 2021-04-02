package com.airplane.airLight.dto;

public class AdminBoardDTO {
	
	private int board_code;
	private long member_code;
	private String title;
	private String content;
	private String write_date;
	private int re_group; // 글그룹
	private int re_leve; // 답글용(관리자) 
	private int re_state; // 글상태
//==================================
	private String first_name;
	private String last_name;
	private String en_first_name;
	private String en_last_name;
	private int birth;
	private int gender;
	private String email;
	private String country;
	private String phone;
	private String tel;
	private String postcode;
	private String addr;
	private String detail_addr;
	private String id;
	private String pw;
	private int member_state; //회원상태(0:일반회원,1:탈퇴,2:관리자)
	private String joindate; // 가입일
	
	public int getBoard_code() {
		return board_code;
	}
	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}
	public long getMember_code() {
		return member_code;
	}
	public void setMember_code(long member_code) {
		this.member_code = member_code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public int getRe_group() {
		return re_group;
	}
	public void setRe_group(int re_group) {
		this.re_group = re_group;
	}
	public int getRe_leve() {
		return re_leve;
	}
	public void setRe_leve(int re_leve) {
		this.re_leve = re_leve;
	}
	public int getRe_state() {
		return re_state;
	}
	public void setRe_state(int re_state) {
		this.re_state = re_state;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEn_first_name() {
		return en_first_name;
	}
	public void setEn_first_name(String en_first_name) {
		this.en_first_name = en_first_name;
	}
	public String getEn_last_name() {
		return en_last_name;
	}
	public void setEn_last_name(String en_last_name) {
		this.en_last_name = en_last_name;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDetail_addr() {
		return detail_addr;
	}
	public void setDetail_addr(String detail_addr) {
		this.detail_addr = detail_addr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getMember_state() {
		return member_state;
	}
	public void setMember_state(int member_state) {
		this.member_state = member_state;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	
	
	
	

}
