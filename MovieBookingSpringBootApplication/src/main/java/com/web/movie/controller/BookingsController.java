package com.web.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.movie.services.BookingsServiceImpl;
import com.web.movie.services.HistoryServiceIml;
import com.web.movie.entities.Bookings;
import com.web.movie.entities.History;
import com.web.movie.entities.Movie;
import com.web.movie.repository.HistoryRepo;
import com.web.movie.repository.MovieRepo;

@Controller
public class BookingsController {
	@Autowired
	private BookingsServiceImpl bsi;
	@Autowired
	private HistoryRepo hp;
	@Autowired
	private HistoryServiceIml hsi;
	@Autowired
	private Movie movie;
	@Autowired
	private MovieRepo mr;
	@RequestMapping("/bookings")
	public String Bookings(Model model) {	
		model.addAttribute("ml",bsi.getAllBookings());
		return "bookings";
	}
	@RequestMapping(value="/bookMovie/{title}/{releaseDate}/{showCycle}", method=RequestMethod.POST)
	@ResponseBody
	public void bookMovies(@PathVariable String title, @PathVariable String releaseDate, @PathVariable String  showCycle,Model model) {
		int seat=mr.getSeats(title);
		
		
		
		Bookings m=new Bookings(title,releaseDate,showCycle,seat);
		History h=new History(title,releaseDate,showCycle,seat,"booked");
		seat--;
		if(seat<=0)
		{
		seat=0;
		}
		mr.editSeats(seat,title);
		
		if(seat!=0)
		{
		hp.save(h);
		bsi.saveBookings(m);
		}
		
	}
	@RequestMapping(value="/deletebookings/{title}/{releaseDate}/{showCycle}",method=RequestMethod.DELETE)
	@ResponseBody
	public String cancelMovies(@PathVariable String title, @PathVariable String releaseDate, @PathVariable String  showCycle) {
		int seat=mr.getSeats(title);
		seat++;
		mr.editSeats(seat, title);
		History h=new History(title,releaseDate,showCycle,seat,"cancelled");
		hp.save(h);
		bsi.deleteBookingsByTitle(title);
		return "bookings";
	}
	
	@GetMapping("/History")
	public String showHistory(Model model)
	{
		model.addAttribute("hp",hsi.getAllHistory());
		return "History";
		
	}
}
