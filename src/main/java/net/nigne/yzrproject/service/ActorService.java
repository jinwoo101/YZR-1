package net.nigne.yzrproject.service;

import java.util.List;

import net.nigne.yzrproject.domain.ActorVO;

public interface ActorService {
	public List<String> getMovie_actor(String member_id);
	public List<String> getActor(String movie_id);
}
