package net.nigne.yzrproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.PageMaker;
import net.nigne.yzrproject.domain.QnaReplyVO;
import net.nigne.yzrproject.domain.QnaVO;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.service.AdminQnaService;

@Controller
public class AdminQnaController {

	@Autowired
	private AdminQnaService qna_Service;
	
	@RequestMapping(value = "/admin/qna", method = RequestMethod.GET)
	public ModelAndView userQnaPage() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("admin/qna");
		return view;
	}
	
	@RequestMapping(value = "/admin/qna/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> qnalistPage(HttpServletRequest request,
			@PathVariable("page") Integer page,@RequestParam("search") String search   ) {
		ResponseEntity<Map<String, Object>> entity = null;
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			Criteria criteria = new Criteria();
			criteria.setPage(page);
			List<QnaVO> list = null;
			if("".equals(search)){
				list=qna_Service.getListPage(criteria);
				long qnaTotal = qna_Service.getTotalCount();
				PageMaker pm = new PageMaker(criteria, qnaTotal);
				map.put("l", list);
				map.put("p", pm);
			}else{
				list=qna_Service.getQnaSearch(search, criteria);
				long qnasearchTotal = qna_Service.getSearchTotal(search);
				PageMaker pm = new PageMaker(criteria, qnasearchTotal);
				map.put("l", list);
				map.put("p", pm);
			}
			entity = new ResponseEntity<>(map, HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
		return entity;
	}
	
	@RequestMapping(value = "/admin/qna/read/{no}", method = RequestMethod.GET)
	public String qna_read(Locale locale, Model model, @PathVariable("no") int no,HttpServletRequest request) throws Exception {

		QnaVO qnavo = qna_Service.getQna(no);
		model.addAttribute("qnavo", qnavo);

		return "/admin/qna_read";
	}
	
	@RequestMapping(value = "/admin/qna/reply/{no}", method = RequestMethod.POST)
	public ResponseEntity<String> reply_insert(@RequestBody ReplyVO vo, @PathVariable("no") int no) {
		ResponseEntity<String> entity = null;
		try {
			qna_Service.replyInsert(vo.getReply_no(), vo.getReview_no(), vo.getUser_id(), vo.getReply_content(),
					vo.getReply_date(), vo.getReply_reply());
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value = "/admin/qna/{no}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> reply_read(Locale locale, Model model, @PathVariable("no") int no,
			@PathVariable("page") Integer page) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;

		try {
			Criteria criteria = new Criteria();
			criteria.setPage(page);
			long replyTotal = qna_Service.getReplyCount(no);
			List<QnaReplyVO> replypagelist = qna_Service.getReplyPage(no, criteria);
			PageMaker pm = new PageMaker(criteria, replyTotal);
			Map<String, Object> map = new HashMap<>();
			map.put("l", replypagelist);
			map.put("p", pm);
			entity = new ResponseEntity<>(map, HttpStatus.OK);

		} catch (Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	



}