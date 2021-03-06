/** 
*
*/
package net.nigne.yzrproject.service;

import net.nigne.yzrproject.domain.MemberVO;

/** 
* @FileName : UserInfoService.java 
* @Package  : net.nigne.yzrproject.service 
* @Date     : 2016. 7. 28. 
* @작성자		: 강대성
* @프로그램 	: 설명...
*/
public interface UserInfoService {
	public MemberVO getMemberInfo(String member_id);
	public void pwUpdate(String member_id, String newPw);
	public void userInfoUpdate(String member_id, MemberVO vo);
	public boolean pwFind(MemberVO vo);
}
