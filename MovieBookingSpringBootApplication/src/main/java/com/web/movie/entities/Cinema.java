package com.web.movie.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Cinema implements Comparable<Cinema> {
	@Override
	public int hashCode() {
		return Objects.hash(cid, ctype, screen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cinema other = (Cinema) obj;
		return cid == other.cid && Objects.equals(ctype, other.ctype) && Objects.equals(screen, other.screen);
	}

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int cid;
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	private String ctype;


	@Override
	public String toString() {
		return "Cinema [cid=" + cid + ", ctype=" + ctype + "]";
	}

	public Cinema(int cid, String ctype) {
		super();
		this.cid = cid;
		this.ctype = ctype;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	@OneToMany(fetch=FetchType.EAGER)
	
    @JoinColumn(name = "fk_cid", referencedColumnName = "cid")
	@JsonBackReference
	private List<Screen> screen;

	@Override
	public int compareTo(Cinema o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
