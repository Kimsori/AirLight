package com.airplane.airLight.dto;

//����Ʈ DTO
public class PointDTO {
	private int point_code; // pk
	private long member_code;
	private int point_price;
	private String point_content; // ��������
	private String point_date; // ������

	public int getPoint_code() {
		return point_code;
	}

	public void setPoint_code(int point_code) {
		this.point_code = point_code;
	}

	public long getMember_code() {
		return member_code;
	}

	public void setMember_code(long member_code) {
		this.member_code = member_code;
	}

	public int getPoint_price() {
		return point_price;
	}

	public void setPoint_price(int point_price) {
		this.point_price = point_price;
	}

	public String getPoint_content() {
		return point_content;
	}

	public void setPoint_content(String point_content) {
		this.point_content = point_content;
	}

	public String getPoint_date() {
		return point_date;
	}

	public void setPoint_date(String point_date) {
		this.point_date = point_date;
	}

}
