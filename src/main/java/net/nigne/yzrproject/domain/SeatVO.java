package net.nigne.yzrproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="seat")
public class SeatVO {
	@Id
	@GeneratedValue(generator="NoSequence", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="NoSequence", sequenceName="SEAT_NO_SEQ", allocationSize=1)
	@Column(name="no")
	int no;
	
	@Column(name="theater_id")
	String theater_id;
	
	@Column(name="plex_number")
	String plex_number;
	
	@Column(name="seat_type")
	String seat_type;
	
	@Column(name="seat_index")
	String seat_index;
	
	@Column(name="seat_number")
	int seat_number;
	
	@Column(name="reservation_exist")
	String reservation_exist;

	@Column(name="start_time")
	String start_time;
	
	@Column(name="current_time")
	String current_time;
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTheater_id() {
		return theater_id;
	}

	public void setTheater_id(String theater_id) {
		this.theater_id = theater_id;
	}

	public String getPlex_number() {
		return plex_number;
	}

	public void setPlex_number(String plex_number) {
		this.plex_number = plex_number;
	}

	public String getSeat_type() {
		return seat_type;
	}

	public void setSeat_type(String seat_type) {
		this.seat_type = seat_type;
	}

	public String getSeat_index() {
		return seat_index;
	}

	public void setSeat_index(String seat_index) {
		this.seat_index = seat_index;
	}

	public int getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}

	public String getReservation_exist() {
		return reservation_exist;
	}

	public void setReservation_exist(String reservation_exist) {
		this.reservation_exist = reservation_exist;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getCurrent_time() {
		return current_time;
	}

	public void setCurrent_time(String current_time) {
		this.current_time = current_time;
	}


}
