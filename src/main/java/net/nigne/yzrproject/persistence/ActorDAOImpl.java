package net.nigne.yzrproject.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.stereotype.Repository;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.ReservationVO;

@Repository
public class ActorDAOImpl implements ActorDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<String> getMovie_actor(String member_id) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> actorQuery = cb.createQuery(String.class);
		Root<ActorVO> actorRoot = actorQuery.from(ActorVO.class);
		
		Subquery<ReservationVO> subQuery = actorQuery.subquery(ReservationVO.class);
		Root<ReservationVO> subQueryRoot = subQuery.from(ReservationVO.class);
		subQuery.select(subQueryRoot.get("movie_id"));
		subQuery.where(cb.equal(subQueryRoot.get("member_id"), member_id));
		
		actorQuery.select(actorRoot.get("actor_name"));
		actorQuery.where(actorRoot.get("movie_id").in(subQuery));
		actorQuery.groupBy(actorRoot.get("actor_name"));
		actorQuery.orderBy(cb.desc(cb.count(actorRoot.get("actor_name"))));
		
		TypedQuery<String> tq = entityManager.createQuery(actorQuery);
		
		List<String> actor = tq.getResultList();
		
		return actor;
	}

	@Override
	public List<String> getActor(String movie_id) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> actorQuery = cb.createQuery(String.class);
		Root<ActorVO> actorRoot = actorQuery.from(ActorVO.class);
		
		actorQuery.select(actorRoot.get("actor_name"));
		actorQuery.where(cb.equal(actorRoot.get("movie_id"), movie_id));
		
		TypedQuery<String> tq = entityManager.createQuery(actorQuery);
		
		List<String> actor = tq.getResultList();
		
		return actor;
	}

}
