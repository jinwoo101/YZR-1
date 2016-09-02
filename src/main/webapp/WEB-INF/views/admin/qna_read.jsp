<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
<%@include file="./sidebar.jsp"%>
<style>
tr{
	height: 60px;
}
td{
	text-align: left;
}
th{
	width: 100px;
	text-align: left;
	font-weight: bold;
}
.table > tbody > tr > th, .table > tbody > tr > td{
	vertical-align: middle;
	background-color: ivory;
}
</style>
<div class="content" style="margin-left: 120px; width: 890px;">
	<div>
		<h3>나의 1:1 문의</h3>
	</div><br>
	<div style="height: 40px;background-color: red;">
	</div>
	<table class="table">

		<tr style="border: 0px;">
			<th style="border-top: 0px;">문의유형</th>
			<td colspan="3" style="border-top: 0px;">
				${qnavo.qnatype }
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">
				${qnavo.title }
			</td>
		</tr>
		<tr>
			<th style="vertical-align: text-top;">내용</th>
			<td colspan="3" style="height: 200px; vertical-align: text-top;">
				${qnavo.content }
			</td>
		</tr>
	</table>
	<div style="float: right;">
		<a href="/user/qna"><input type="button" class="btn btn-danger" value="목록" style="margin-bottom: 20px;"></a>
	</div>
			<div id="reply_write_wrap" class="reply_write_wrap">
				<div id="reply_write_input" class="reply_write_input">
					<input type="hidden" id="reply_reply" class="reply_reply" name="reply_reply" value="n" /> 
						<input type="text" id="user_id"	name="user_id" class="form-control" data-rule-required="true" value="${member_id}" maxlength="20" readonly="readonly" style="background-color: white;" />
						<textarea id="reply_content" name="reply_content" class="form-control col-lg-12" rows="4" style="resize: none;" placeholder="내용을 입력하세요"></textarea>
						<button id="reply_submit" class="reply_submit btn btn-primary" onclick="insertReply('${qnavo.no}')" style="margin-left: 800px;">답변 등록</button>		
					<input type="hidden" id="review_no" name="review_no" value="${qnavo.no }" />
				</div>
			</div>
			</div>
				<div id="reply" class="reply"></div>
			<div id="reply_page" style="margin-top:40px; text-align: center;"></div>
<script>
var reno = $("#review_no").val();
var currentPage = 1;
function insertReply(no) {
	var qna_no ="${qnavo.no}";
	var reply_reply = $("#reply_reply").val();
	var user_id = "${member_id}";
	var reply_content = $("#reply_content").val();
	var reply_no = $("#review_no").val();
		$.ajax({
			type : 'post',
			url : ' /admin/qna/reply/'+no,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			data : JSON.stringify({
				"user_id" : user_id,
				"reply_content" : reply_content,
				"reply_reply" : reply_reply,
				"review_no" : no
			}),
			dataType : 'text',
			success : function(result) {
				if (result == "SUCCESS") {
					getReplyList();
					$('#reply_content').val('');
				}
			}
		});
	}
	
function setReplyList(data){
	var result = "";  
	var reply_list = null;
	var reply_reply_list = null;
	$(data).each(function(){
		reply_list = this;
				result += "<div style='margin-left:100px; margin-top:30px;'>"
				+ "<div class='div_re_uid' id='div_re_uid' name='div_re_uid'>"
				+ "<div style='margin-bottm: 5px; margin-left:20px; font-size:15px'>"
				+"<b><span> 아이디 : "+ reply_list.user_id +"</span><span style=' margin-left:20px;'> 등록일  :"+ reply_list.reply_date+"</span></b></div>"
				+"<div><textarea disabled readonly='readonly' style='10px; padding: 2px; border: 0px;width: 840px; height: 70px; font-size:18px;"
				+"resize: none; margin-top: 5px; margin-left: 20px; background-color: white'>" + reply_list.reply_content
				+"</textarea></div>" 
				+ "</div>";
	});	
	result += "</div>";
	document.getElementById("reply").innerHTML = result;
}


function getReplyList(page){
	if(page ==null){
		page = currentPage;
	}
	currentPage = page;
	$.ajax({
		type : 'get',
		url : '/admin/qna/' + reno + "/"+page,
		headers : {
			"Content-Type" : "application/json",
			//"X-HTTP-Method-Override" : "GET",  ----  POST 이거나 GET인경우는 생략가능
		},
		dataType : 'json',
		data : '',
		success : function(result){
			setReplyList(result.l);
			setPagePrint(result.p);
		}
	});
}

getReplyList(1);


function setPagePrint(pm){
	var str = "<ul class='pagination'>";
	
	if(pm.prev){
		str += "<li> &lt; </li>"
	}
	
	for(var i = pm.startPage; i <= pm.endPage ; i++){
		if(i == pm.criteria.page){
			str += "<li class='active'><a href='#'>" + i + "</a></li>"
		}else{
			str += "<li><a href='javascript:getReplyList("+i+")'>" + i + "</a></li>"
		}
	}
	
	if(pm.next){
		str += "<li> &gt; </li>"
	}
	
	str += "</ul>"
	document.getElementById("reply_page").innerHTML = str;
}

</script>
<%@include file="../include/footer.jsp"%>