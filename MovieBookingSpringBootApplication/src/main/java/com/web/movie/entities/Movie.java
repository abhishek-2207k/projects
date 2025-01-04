package com.web.movie.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.springframework.stereotype.Component;

@Component
@Entity
@NamedQuery(name = "movie.findByReleaseMid",
query = "select e from Movie e where e.mid = ?101")
public class Movie implements Comparable<Movie>{
	@Override
	public int hashCode() {
		return Objects.hash(mid, releaseDate, showCycle, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return mid == other.mid && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(showCycle, other.showCycle) && Objects.equals(title, other.title);
	}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int mid;
	private String title;
	private String releaseDate;
	private String showCycle;
	private int seats;
	

	
	public int getId() {
		return mid;
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
	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Movie [mid=" + mid + ", title=" + title + ", releaseDate=" + releaseDate + ", showCycle=" + showCycle
				+ "]";
	}
	public Movie( String title, String releaseDate, String showCycle,int seats) {
		super();
		
		this.title = title;
		this.releaseDate = releaseDate;
		this.showCycle = showCycle;
		this.seats=seats;
	}
	

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
