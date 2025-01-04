package com.web.movie.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bookings implements Comparable<Bookings> {
	@Override
	public int hashCode() {
		return Objects.hash(bid, releaseDate, showCycle, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bookings other = (Bookings) obj;
		return bid == other.bid && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(showCycle, other.showCycle) && Objects.equals(title, other.title);
	}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int bid;
	private String title;
	private String releaseDate;
	private String showCycle;
	private int seatNo;
	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bookings( String title, String releaseDate, String showCycle,int seatNo) {
		super();
		
		this.title = title;
		this.releaseDate = releaseDate;
		this.showCycle = showCycle;
		this.setSeatNo(seatNo);
	}
	@Override
	public String toString() {
		return "Bookings [bid=" + bid + ", title=" + title + ", releaseDate=" + releaseDate + ", showCycle=" + showCycle
				+ "]";
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getShowCycle() {
		return showCycle;
	}
	public void setShowCycle(String showCycle) {
		this.showCycle = showCycle;
	}
	@Override
	public int compareTo(Bookings o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
}
