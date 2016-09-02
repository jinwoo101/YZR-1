package net.nigne.yzrproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.MemberVO;
import net.nigne.yzrproject.domain.QnaReplyVO;
import net.nigne.yzrproject.domain.QnaVO;
import net.nigne.yzrproject.persistence.AdminQnaDAO;
import net.nigne.yzrproject.persistence.QnaDAO;

@Service
public class AdminQnaServiceImpl implements AdminQnaService {

	@Autowired
	private AdminQnaDAO dao;


	@Transactional(rollbackFor = { Exception.class })
	@Override
	public long getTotalCount() {
		// TODO Auto-generated method stub
		return dao.getTotalCount();
	}


	@Transactional(rollbackFor = { Exception.class })
	@Override
	public List<QnaVO> getListPage(Criteria criteria) {
		// TODO Auto-generated method stub
		return dao.getListPage(criteria);
	}


	@Override
	public List<QnaVO> getQnaSearch(String search,Criteria criteria) {
		// TODO Auto-generated method stub
		return dao.getQnaSearch(search,criteria);
	}


	@Override
	public long getSearchTotal(String search) {
		// TODO Auto-generated method stub
		return dao.getSearchTotal(search);
	}
	@Override
	public QnaVO getQna(int no) {
		// TODO Auto-generated method stub
		return dao.getQna(no);
	}


	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void replyInsert(int reply_no,int review_no, String user_id, String reply_content, String reply_date,String reply_reply) throws Exception {
		dao.replyInsert(reply_no,review_no, user_id, reply_content, reply_date, reply_reply);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public List<QnaReplyVO> getReply(int no) {
		return dao.getReply(no);
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public long getReplyCount(int no) {
		// TODO Auto-generated method stub
		return dao.getReplyCount(no);
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public List<QnaReplyVO> getReplyPage(int review_no, Criteria criteria) {
		// TODO Auto-generated method stub
		return dao.getReplyPage(review_no, criteria);
	}	
}