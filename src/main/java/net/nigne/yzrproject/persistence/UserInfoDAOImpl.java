/** 
*
*/
package net.nigne.yzrproject.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import net.nigne.yzrproject.domain.MemberVO;
import net.nigne.yzrproject.domain.MovieVO;

/** 
* @FileName : UserInfoDAOImpl.java 
* @Package  : net.nigne.yzrproject.persistence 
* @Date     : 2016. 7. 28. 
* @작성자		: 강대성
* @프로그램 	: 설명...
*/
@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

	@PersistenceContext
	EntityManager em;
	/** 
	* @Method Name	: getMemberInfo 
	* @Method 설명	: 
	* @param member_id
	* @return 
	*/
	@Override
	public MemberVO getMemberInfo(String member_id) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MemberVO> cq = cb.createQuery(MemberVO.class);
		Root<MemberVO> root = cq.from(MemberVO.class);
		Predicate p = cb.equal(root.get("member_id"), member_id);
		cq.select(root).where(p);
		TypedQuery<MemberVO> tq = em.createQuery(cq);
		MemberVO vo= tq.getSingleResult();
		
		return vo;
	}
	@Override
	public void pwUpdate(String member_id, String newPw) {
		
		MemberVO vo = new MemberVO();
		vo.setMember_id(member_id);
		vo = em.find(MemberVO.class, vo.getMember_id());
		MemberVO mergevo = em.merge(vo);
		mergevo.setMember_pw(newPw);
		
	}
	
	@Override
	public void userInfoUpdate(String member_id, MemberVO vo) {
		MemberVO tempvo = new MemberVO();
		tempvo.setMember_id(member_id);
		tempvo = em.find(MemberVO.class, tempvo.getMember_id());
		MemberVO mergevo = em.merge(tempvo);
		mergevo.setAddress(vo.getAddress());
		mergevo.setMember_name(vo.getMember_name());
		mergevo.setEmail(vo.getEmail());
		mergevo.setTel(vo.getTel());
	}
	
	@Override
	public boolean pwFind(MemberVO vo){
		
		boolean check = true;
		try{
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<String> cq = cb.createQuery(String.class);
			Root<MemberVO> root = cq.from(MemberVO.class);
			cq.select(root.get("member_id"));
			Predicate mc = cb.equal(root.get("member_id"), vo.getMember_id());
			Predicate qc = cb.equal(root.get("question"), vo.getQuestion());
			Predicate ac = cb.equal(root.get("answer"), vo.getAnswer());
			cq.where(cb.and(mc,qc,ac));
		
			TypedQuery<String> tq = em.createQuery(cq);
			check = tq.getSingleResult().isEmpty();
			System.out.println(check);
			return check;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return check;
		}
	}

}
