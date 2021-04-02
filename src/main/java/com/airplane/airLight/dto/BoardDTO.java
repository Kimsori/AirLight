package com.airplane.airLight.dto;

//Q&A 게시판DTO
public class BoardDTO {
	private int board_code;
	private long member_code;
	private String title;
	private String content;
	private String write_date;
	private int re_group; // 글그룹
	private int re_leve; // 답글용(관리자) 
	private int re_state; // 글상태

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
}
