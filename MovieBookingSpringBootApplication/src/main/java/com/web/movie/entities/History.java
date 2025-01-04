package com.web.movie.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class History implements Comparable<History>{

	@Override
	public int hashCode() {
		return Objects.hash(hid, releaseDate, showCycle, status, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		History other = (History) obj;
		return hid == other.hid && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(showCycle, other.showCycle) && Objects.equals(status, other.status)
				&& Objects.equals(title, other.title);
	}

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int hid;
	private String title;
	private String releaseDate;
	private String showCycle;
	private int seatNo;
	private String status;
	
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public History( String title, String releaseDate, String showCycle,int seatNo, String status) {
		super();
		
		this.title = title;
		this.releaseDate = releaseDate;
		this.showCycle = showCycle;
		this.status = status;
		this.seatNo=seatNo;
	}
	public History() {
		super();
		
	}
	
	@Override
	public String toString() {
		return "History [hid=" + hid + ", title=" + title + ", releaseDate=" + releaseDate + ", showCycle=" + showCycle
				+ ", status=" + status + "]";
	}
	@Override
	public int compareTo(History o) {
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
