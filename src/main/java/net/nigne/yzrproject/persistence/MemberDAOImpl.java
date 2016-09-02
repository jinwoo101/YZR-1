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

@Repository
public class MemberDAOImpl implements MemberDAO {

    @PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(MemberVO vo) {
		entityManager.persist(vo);

	}
	@Override
	public MemberVO select(String member_id) {
		
		MemberVO vo = null;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<MemberVO> cq = cb.createQuery(MemberVO.class);
		Root<MemberVO> root = cq.from(MemberVO.class);
		cq.select(root);
		cq.where(cb.equal(root.get("member_id"), member_id));
		try{
			TypedQuery<MemberVO> tq = entityManager.createQuery(cq);
			vo =tq.getSingleResult();
			return vo;
		}catch(Exception e){
			return vo;
		}
	}

	@Override
	public void delete(String member_id) {
		MemberVO vo = entityManager.find(MemberVO.class, member_id);
		entityManager.remove(vo);
	}
	
	// ���̵� üũ
	@Override
	public boolean idCheck(String member_id) {
		String check=null;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<MemberVO> root = cq.from(MemberVO.class);
		cq.select(root.get("member_id"));
		cq.where(cb.equal(root.get("member_id"), member_id));
		try{
			TypedQuery<String> tq = entityManager.createQuery(cq);
			check = tq.getSingleResult();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	// ��й�ȣ üũ
	@Override
	public boolean pwCheck(String member_pw, String member_id) {
		String check=null;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<MemberVO> root = cq.from(MemberVO.class);
		cq.select(root.get("member_pw"));
		cq.where(cb.equal(root.get("member_id"), member_id));
		TypedQuery<String> tq = entityManager.createQuery(cq);
		check = tq.getSingleResult();
		if(check == member_pw || member_pw.equals(check)){
			
			return true;
		}else{
			return false;
		}
	}
	
	// ȸ������ ������
	@Override
	public MemberVO getMemberInfo(String member_id) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<MemberVO> cq = cb.createQuery(MemberVO.class);
		Root<MemberVO> root = cq.from(MemberVO.class);
		Predicate p = cb.equal(root.get("member_id"), member_id);
		cq.select(root).where(p);
		TypedQuery<MemberVO> tq = entityManager.createQuery(cq);
		MemberVO vo= tq.getSingleResult();
		
		return vo;
	}
	
	//��й�ȣ����
	@Override
	public void pwUpdate(String member_id, String newPw) {
		
		MemberVO vo = new MemberVO();
		vo.setMember_id(member_id);
		vo = entityManager.find(MemberVO.class, vo.getMember_id());
		MemberVO mergevo = entityManager.merge(vo);
		mergevo.setMember_pw(newPw);
		
	}
	
	
	//ȸ����������
	@Override
	public void userInfoUpdate(String member_id, MemberVO vo) {
		MemberVO tempvo = new MemberVO();
		tempvo.setMember_id(member_id);
		tempvo = entityManager.find(MemberVO.class, tempvo.getMember_id());
		MemberVO mergevo = entityManager.merge(tempvo);
		mergevo.setAddress(vo.getAddress());
		mergevo.setMember_name(vo.getMember_name());
		mergevo.setEmail(vo.getEmail());
		mergevo.setTel(vo.getTel());
		mergevo.setQuestion(vo.getQuestion());
		mergevo.setAnswer(vo.getAnswer());
	}
	
	//���̵�ã��
	
	@Override
	public String idSearch(String member_name, String email){
		String check=null;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<MemberVO> root = cq.from(MemberVO.class);
		cq.select(root.get("member_id"));
		cq.where(cb.equal(root.get("member_name"), member_name), cb.equal(root.get("email"), email));
		try{
			TypedQuery<String> tq = entityManager.createQuery(cq);
			check = tq.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return check;
	}
	
	//��й�ȣã��
	@Override
	public boolean pwFind(MemberVO vo){
		
		boolean check = true;
		try{
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<String> cq = cb.createQuery(String.class);
			Root<MemberVO> root = cq.from(MemberVO.class);
			cq.select(root.get("member_id"));
			Predicate mc = cb.equal(root.get("member_id"), vo.getMember_id());
			Predicate qc = cb.equal(root.get("question"), vo.getQuestion());
			Predicate ac = cb.equal(root.get("answer"), vo.getAnswer());
			cq.where(cb.and(mc,qc,ac));
		
			TypedQuery<String> tq = entityManager.createQuery(cq);
			check = tq.getSingleResult().isEmpty();
			System.out.println(check);
			return check;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return check;
		}
	}
	@Override
	public MemberVO getMember(String member_id) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<MemberVO> mainQuery = cb.createQuery(MemberVO.class);
		Root<MemberVO> mainQueryroot = mainQuery.from(MemberVO.class);
		
		mainQuery.select(mainQueryroot);
		mainQuery.where(cb.equal(mainQueryroot.get("member_id"), member_id));
		
		TypedQuery<MemberVO> tq = entityManager.createQuery(mainQuery);
		List<MemberVO> list = tq.getResultList();
		
		return list.get(0);
	}
	@Override
	   public void pointUpdate(String memberId, int point) {
	      // TODO Auto-generated method stub
	      
	      String grade = grade(point);
	                                             //primarykey
	      MemberVO memberVO = entityManager.find(MemberVO.class, memberId);
	      
	      MemberVO mergeVO = entityManager.merge(memberVO);
	      mergeVO.setPoint(point);
	      mergeVO.setGrade(grade);
	   }
	   
	   private String grade(int point) {

	      String grade = "";
	      
	      if(point>=6000) {
	         grade = "ç����";
	      } else if(point>=5000) {
	         grade = "������";
	      } else if(point>=4000) {
	         grade = "���̾Ƹ��";
	      } else if(point>=3000) {
	         grade = "�÷�Ƽ��";
	      } else if(point>=2000) {
	         grade = "���";
	      } else if(point>=1000) {
	         grade = "�ǹ�";
	      } else {
	         grade = "�����";
	      }
	      
	      return grade;
	   }
}