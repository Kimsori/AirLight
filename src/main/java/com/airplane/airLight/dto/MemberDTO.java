package com.airplane.airLight.dto;

public class MemberDTO {
	//== 신상정보 
	private long member_code;
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
	//== 아이디 pw 정보 
	private String id;
	private String pw;
	private int member_state;
	private String joindate;
	
	 private int postCode;
	 private int membar_state; // 회원상태(0:일반회원,1:탈퇴,2:관리자)/ 지역전화
	
	
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public int getMembar_state() {
		return membar_state;
	}
	public void setMembar_state(int membar_state) {
		this.membar_state = membar_state;
	}
	public long getMember_code() {
		return member_code;
	}
	public void setMember_code(long member_code) {
		this.member_code = member_code;
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
