package net.nigne.yzrproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.persistence.ActorDAO;

@Service
public class ActorServiceImpl implements ActorService {
	
	@Autowired
	private ActorDAO dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<String> getMovie_actor(String member_id) {
		return dao.getMovie_actor(member_id);
	}

	@Override
	public List<String> getActor(String movie_id) {
		return dao.getActor(movie_id);
	}

}
