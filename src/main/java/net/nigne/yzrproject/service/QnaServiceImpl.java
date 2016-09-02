package net.nigne.yzrproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.MemberVO;
import net.nigne.yzrproject.domain.QnaVO;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.persistence.QnaDAO;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDAO dao;


	@Transactional(rollbackFor = { Exception.class })
	@Override
	public long getTotalCount(String member_id) {
		// TODO Auto-generated method stub
		return dao.getTotalCount(member_id);
	}


	@Transactional(rollbackFor = { Exception.class })
	@Override
	public List<QnaVO> getListPage(String member_id, Criteria criteria) {
		// TODO Auto-generated method stub
		return dao.getListPage(member_id, criteria);
	}


	@Override
	public List<QnaVO> getQnaSearch(String member_id, String search,Criteria criteria) {
		// TODO Auto-generated method stub
		return dao.getQnaSearch(member_id, search,criteria);
	}


	@Override
	public long getSearchTotal(String member_id, String search) {
		// TODO Auto-generated method stub
		return dao.getSearchTotal(member_id, search);
	}


	@Override
	public MemberVO getMember(String member_id) {
		// TODO Auto-generated method stub
		return dao.getMember(member_id);
	}


	@Override
	public QnaVO getQna(int no) {
		// TODO Auto-generated method stub
		return dao.getQna(no);
	}


}