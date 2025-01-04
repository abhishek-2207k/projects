package com.web.movie.services;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.movie.entities.History;
import com.web.movie.repository.HistoryRepo;
@Service
public class HistoryServiceIml implements HistoryService {

	@Autowired
	private HistoryRepo hp;
	
	
	@Override
	@Transactional(dontRollbackOn= {NullPointerException.class,BrokenBarrierException.class})
	public List<History> getAllHistory() {
		
		return hp.findAll();
	}

}
