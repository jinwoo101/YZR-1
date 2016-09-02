package net.nigne.yzrproject.persistence;

import java.util.List;

import net.nigne.yzrproject.domain.ActorVO;

public interface ActorDAO {
	public List<String> getMovie_actor(String member_id);
	public List<String> getActor(String movie_id);
}
