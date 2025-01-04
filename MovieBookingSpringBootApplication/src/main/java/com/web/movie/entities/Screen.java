package com.web.movie.entities;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Screen implements Comparable<Screen>{
	@Override
	public int hashCode() {
		return Objects.hash(movie, sid, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screen other = (Screen) obj;
		return Objects.equals(movie, other.movie) && sid == other.sid && Objects.equals(type, other.type);
	}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int sid;
	private String type;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Screen [sid=" + sid + ", type=" + type + "]";
	}
	public Screen(int sid, String type) {
		super();
		this.sid = sid;
		this.type = type;
	}
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "movie_id", referencedColumnName = "mid")
	private Movie movie;
	@Override
	public int compareTo(Screen o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
