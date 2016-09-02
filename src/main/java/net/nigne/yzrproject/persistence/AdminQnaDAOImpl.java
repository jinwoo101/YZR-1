package net.nigne.yzrproject.persistence;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.QnaReplyVO;
import net.nigne.yzrproject.domain.QnaVO;
import net.nigne.yzrproject.domain.ReplyVO;

@Repository
public class AdminQnaDAOImpl implements AdminQnaDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public long getTotalCount() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(long.class);
		Root<QnaVO> root = cq.from(QnaVO.class);
		cq.select(cb.count(root.get("no")));
		TypedQuery<Long> tq = entityManager.createQuery(cq);
		long totalcount = tq.getSingleResult();
		return totalcount;
	}


	@Override
	public List<QnaVO> getListPage(Criteria criteria) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<QnaVO> cq = cb.createQuery(QnaVO.class);
		Root<QnaVO> root = cq.from(QnaVO.class);
		cq.select(root);
		cq.orderBy(cb.desc(root.get("no")));
		TypedQuery<QnaVO> tq = entityManager.createQuery(cq).setFirstResult(criteria.getStartPage()).setMaxResults(criteria.getArticlePerPage());
		List<QnaVO> qnapagelist = tq.getResultList();
		return qnapagelist;
	}


	@Override
	public List<QnaVO> getQnaSearch(String search,Criteria criteria) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<QnaVO> cq = cb.createQuery(QnaVO.class);
		Root<QnaVO> root = cq.from(QnaVO.class);
		Predicate s = cb.like(root.get("title"), "%"+search+"%");
		cq.select(root).where(s);
		TypedQuery<QnaVO> tq = entityManager.createQuery(cq).setFirstResult(criteria.getStartPage()).setMaxResults(criteria.getArticlePerPage());;
		List<QnaVO> qnasearchlist = tq.getResultList();
		return qnasearchlist;
	}
	@Override
	public long getSearchTotal(String search) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(long.class);
		Root<QnaVO> root = cq.from(QnaVO.class);
		Predicate s = cb.like(root.get("content"), "%"+search+"%");
		cq.select(cb.count(root.get("no")));
		cq.where(s);
		TypedQuery<Long> tq = entityManager.createQuery(cq);
		long totalcount = tq.getSingleResult();
		return totalcount;
	}
	@Override
	public QnaVO getQna(int no) {
		// TODO Auto-generated method stub
		QnaVO vo=new QnaVO();
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<QnaVO> cq=cb.createQuery(QnaVO.class);
		Root<QnaVO> root = cq.from(QnaVO.class);
		cq.select(root);
		cq.where(cb.equal(root.get("no"),no));
		TypedQuery<QnaVO> tq = entityManager.createQuery(cq);
		vo=tq.getSingleResult();
		
		return vo;
	}


	@Override
	public void replyInsert(int reply_no,int review_no, String user_id, String reply_content, String reply_date,
			String reply_reply) throws Exception {
		QnaReplyVO vo = new QnaReplyVO();
		vo.setReply_no(reply_no);
		vo.setReview_no(review_no);
		vo.setUser_id(user_id);
		vo.setReply_content(reply_content);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String date = sdf.format(cal.getTime().getTime());
		vo.setReply_date(date);
		vo.setReply_reply(reply_reply);
		entityManager.persist(vo);
	}


	@Override
	public List<QnaReplyVO> getReply(int no) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<QnaReplyVO> cq = cb.createQuery(QnaReplyVO.class);
		Root<QnaReplyVO> root = cq.from(QnaReplyVO.class);
		Predicate p = cb.equal(root.get("no"), no);
		cq.select(root).where(p);
		TypedQuery<QnaReplyVO> tq = entityManager.createQuery(cq);
		List<QnaReplyVO> replylist = tq.getResultList();
		return replylist;
	}


	@Override
	public long getReplyCount(int review_no) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(long.class);
		Root<QnaReplyVO> root = cq.from(QnaReplyVO.class);
		Predicate p = cb.equal(root.get("review_no"), review_no);
		cq.select(cb.count(root.get("review_no")));
		cq.where(p);
		TypedQuery<Long> tq = entityManager.createQuery(cq);
		long totalreplycount = tq.getSingleResult();
		return totalreplycount;
	}


	@Override
	public List<QnaReplyVO> getReplyPage(int no, Criteria criteria) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println(no);
		System.out.println(criteria.getArticlePerPage());
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<QnaReplyVO> cq = cb.createQuery(QnaReplyVO.class);
		Root<QnaReplyVO> root = cq.from(QnaReplyVO.class);
		Predicate p = cb.equal(root.get("review_no"), no);
		cq.select(root);
		cq.where(p);
		TypedQuery<QnaReplyVO> tq = entityManager.createQuery(cq).setFirstResult(criteria.getStartPage()).setMaxResults(criteria.getArticlePerPage());
		List<QnaReplyVO> replypagelist = tq.getResultList();
		
		for(QnaReplyVO vo : replypagelist){
			System.out.println("content : " + vo.getReply_content());
		}
		
		return replypagelist;
	}
	
}
