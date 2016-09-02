package net.nigne.yzrproject.service;

import java.util.List;

import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.QnaReplyVO;
import net.nigne.yzrproject.domain.QnaVO;

public interface AdminQnaService {

	public long getTotalCount();
	public List<QnaVO> getListPage(Criteria criteria);
	public List<QnaVO> getQnaSearch(String search,Criteria criteria);
	public long getSearchTotal(String search);
	public QnaVO getQna(int no);
	public void replyInsert(int reply_no,int review_no, String user_id, String reply_content, String reply_date, String reply_reply) throws Exception;
	public List<QnaReplyVO> getReply(int no);
	public long getReplyCount(int no);
	public List<QnaReplyVO> getReplyPage(int no, Criteria criteria);
}