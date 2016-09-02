package net.nigne.yzrproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="qnareply")
public class QnaReplyVO {
	@Id
	@GeneratedValue(generator="NoSequence", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="NoSequence", sequenceName="QNAREPLY_NO_SEQ", allocationSize=1)
	@Column(name="no")
	int no;
	
	@Column(name="reply_no")
	int reply_no;	
	
	@Column(name="user_id")
	String user_id;
	
	@Column(name="reply_content")
	String reply_content;
	
	@Column(name="reply_date")
	String reply_date;
	
	@Column(name="reply_reply")
	String reply_reply;
	
	@Column(name="review_no")
	int review_no;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_date() {
		return reply_date;
	}
	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}
	public String getReply_reply() {
		return reply_reply;
	}
	public void setReply_reply(String reply_reply) {
		this.reply_reply = reply_reply;
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	
}