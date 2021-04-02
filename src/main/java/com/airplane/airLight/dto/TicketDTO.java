package com.airplane.airLight.dto;

public class TicketDTO {

	// 나라
	private String country_code;
	private String country_name;
	
	// 공항
	private int port_code;
	private String port_name;
	private String port_addr;
	private float latitude;
	private float longitude;
	
	// 비행기
	private int plane_code;
	private String plane_name;
	private int e_price;
	private int b_price;
	private int f_price;
	private int site_x;
	private int site_y;
	
	// 시간
	private int time_code;
	private String go_day;
	private String go_time;
	private String start_point;
	private String end_point;
	private String remain_seat;
	
	// 좌석
	private int seat_code;
	private String seat_name;
	private int seat_state;
	
	// 예매
	private int ticket_code;
	private long member_code;
	private String endTime;
	private String wayTime;
	private int adult;
	private int child;
	private int baby;
	private int price;
	private int ticket_state;
	private String ticket_date;
	private String deposit;
	private String seat;
	private int wayType;
	
	// ArrayList
	private String name;
	private String value;
	
	public int getWayType() {
		return wayType;
	}
	public void setWayType(int wayType) {
		this.wayType = wayType;
	}
	public int getTicket_code() {
		return ticket_code;
	}
	public void setTicket_code(int ticket_code) {
		this.ticket_code = ticket_code;
	}
	public long getMember_code() {
		return member_code;
	}
	public void setMember_code(long member_code) {
		this.member_code = member_code;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getWayTime() {
		return wayTime;
	}
	public void setWayTime(String wayTime) {
		this.wayTime = wayTime;
	}
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	public int getBaby() {
		return baby;
	}
	public void setBaby(int baby) {
		this.baby = baby;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTicket_state() {
		return ticket_state;
	}
	public void setTicket_state(int ticket_state) {
		this.ticket_state = ticket_state;
	}
	public String getTicket_date() {
		return ticket_date;
	}
	public void setTicket_date(String ticket_date) {
		this.ticket_date = ticket_date;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getStart_point() {
		return start_point;
	}
	public void setStart_point(String start_point) {
		this.start_point = start_point;
	}
	public int getPlane_code() {
		return plane_code;
	}
	public void setPlane_code(int plane_code) {
		this.plane_code = plane_code;
	}
	public String getPlane_name() {
		return plane_name;
	}
	public void setPlane_name(String plane_name) {
		this.plane_name = plane_name;
	}
	public int getE_price() {
		return e_price;
	}
	public void setE_price(int e_price) {
		this.e_price = e_price;
	}
	public int getB_price() {
		return b_price;
	}
	public void setB_price(int b_price) {
		this.b_price = b_price;
	}
	public int getF_price() {
		return f_price;
	}
	public void setF_price(int f_price) {
		this.f_price = f_price;
	}
	public int getSite_x() {
		return site_x;
	}
	public void setSite_x(int site_x) {
		this.site_x = site_x;
	}
	public int getSite_y() {
		return site_y;
	}
	public void setSite_y(int site_y) {
		this.site_y = site_y;
	}
	public int getTime_code() {
		return time_code;
	}
	public void setTime_code(int time_code) {
		this.time_code = time_code;
	}
	public String getGo_day() {
		return go_day;
	}
	public void setGo_day(String go_day) {
		this.go_day = go_day;
	}
	public String getGo_time() {
		return go_time;
	}
	public void setGo_time(String go_time) {
		this.go_time = go_time;
	}
	public String getEnd_point() {
		return end_point;
	}
	public void setEnd_point(String end_point) {
		this.end_point = end_point;
	}
	public String getRemain_seat() {
		return remain_seat;
	}
	public void setRemain_seat(String remain_seat) {
		this.remain_seat = remain_seat;
	}
	public int getSeat_code() {
		return seat_code;
	}
	public void setSeat_code(int seat_code) {
		this.seat_code = seat_code;
	}
	public String getSeat_name() {
		return seat_name;
	}
	public void setSeat_name(String seat_name) {
		this.seat_name = seat_name;
	}
	public int getSeat_state() {
		return seat_state;
	}
	public void setSeat_state(int seat_state) {
		this.seat_state = seat_state;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public int getPort_code() {
		return port_code;
	}
	public void setPort_code(int port_code) {
		this.port_code = port_code;
	}
	public String getPort_name() {
		return port_name;
	}
	public void setPort_name(String port_name) {
		this.port_name = port_name;
	}
	public String getPort_addr() {
		return port_addr;
	}
	public void setPort_addr(String port_addr) {
		this.port_addr = port_addr;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	
	
}
