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
		</tr>
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
		<a href="/user/qna"><input type="button" class="btn btn-danger" value="목록" style="margin-bottom: 30px;"></a>
	</div>
	<div id="reply" class="reply"></div>
</div>
<script>
var reno = "${qnavo.no}";
var currentPage = 1;
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
		}
	});
}

getReplyList(1);
</script>
<%@include file="../include/footer.jsp"%>