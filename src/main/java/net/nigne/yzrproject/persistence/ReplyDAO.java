package net.nigne.yzrproject.persistence;

import java.sql.Timestamp;
import java.util.List;



import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.MovieVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.domain.ReviewVO;

public interface ReplyDAO {

	public void replyInsert(int reply_no,int review_no, String user_id, String reply_content, String reply_date, String reply_reply) throws Exception;
	public void reply_Reply_Insert(int reply_no,int review_no, String user_id, String reply_content, String reply_date, String reply_reply) throws Exception;
	public List<ReplyVO> getReply_Reply(int review_no);
	public List<ReplyVO> getReply(int review_no);
	public long getReplyCount(int review_no);
	public List<ReplyVO> getReplyPage(int review_no, Criteria criteria);
	public void delete_Reply(int no);
//	public void gpaInsert(String movie_id, String acting) throws Exception;
}
