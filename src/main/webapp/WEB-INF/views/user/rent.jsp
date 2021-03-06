<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
<%@include file="./sidebar.jsp"%>
<c:if test="${ member_id == null }">
	<script>
		<%response.sendRedirect("/login");%>
	</script>
</c:if>
<div class="content" style="margin-left: 120px; width: 890px;">
	<div>
		<h3>나의 대관 문의</h3>
	</div>
	<div style="margin-top:4px;">
		<b style="float: left;margin-top: 4px;">문의조회</b>
		<div class="col-xs-4" style="float:left">
			<input type="text" class="form-control" id = "search" style="margin-left: 5px;">
		</div>		
		<button class="btn btn-danger" style="height: 30px;" onclick="getRentList(1)">검색하기</button>
	</div>
	<div>
		<table class="table" style="margin-top: 30px;">
			<tr style="background-color: red; color: white;">
				<th style="text-align: center;">번호</th>
				<th style="text-align: center;">대관장소</th>
				<th width="60%" style="text-align: center;">문의 내용</th>
				<th style="text-align: center;">등록일</th>
				<th style="text-align: center;">상태</thstyle>
			</tr>
			<tbody id="rent_table">
			</tbody>
		</table>
	</div>	
	<div id="rent_page" style="text-align: center;"></div>
	<hr/>
	<div>
		
		<table class="table table-bordered">
			<tr height="100px;">
				<td width="50%">
					<div style="display: inline-block; height: 48px; width: 58px; margin-top: 15px; float: left; margin-left: 30px;">
						<i class="fa fa-question-circle-o fa-4x" aria-hidden="true"></i>
					</div>
					<div style="display: inline-block; height: 50px;float: left; margin-top:15px; margin-left: 10px;">
						<font size="4px;">
							<b>자주하시는 질문</b>
							<button class="btn btn-danger btn-xs" style="margin-bottom: 5px;" onclick="faq()">바로가기</button><br/>
						</font>
						<font size="3px;">
							고객님들께서 주로 하시는 질문에 대한 <br/> 답변을 한곳에 모아두었습니다.
						</font> 
					</div>
				</td>
				<td width="50%">
					<div style="display: inline-block; height: 48px; width: 58px; margin-top: 15px; float: left; margin-left: 30px;">
						<i class="fa fa-commenting-o fa-4x"></i>
					</div>
					<div style="display: inline-block; height: 50px;float: left; margin-top:15px; margin-left: 10px;">
						<font size="4px;">
							<b>고객의 말씀 </b>
							<button class="btn btn-danger btn-xs" style="margin-bottom: 5px; onclick="qna()">바로가기</button><br/>
						</font>
						<font size="3px;">
							불만사항이나 문의사항을 남겨주시면 <br/>친절히답변드리겠습니다. 
						</font> 
					</div>
				</td>
			</tr>
		</table>
	</div>		
</div>
<script>
var currentPage = 1;
var startPage = 1; 
var endPage = 1; 
var totalPage; 

function faq(){
	location.href="/support/faq";
}
function rent_read(no){
	location.href = "/user/rent/read/" + no;
}
function qna(){
	location.href = "/support/qna";
}

getRentList(1);
function setRentList(data){
	var result = "<tr>";
	if(data.length >0){
		$(data).each(function(){
			var place = this.rent_place.split(" ", 3);
			result += "<td style='text-align: center;'>" 
			+this.no
			+"</td>"
			+"<td  style='text-align: center;'>"
			+place[2]
			+"</td>"
			+"<td>";
			if(this.rent_content.length<20){
				result+="<a href='javascript:rent_read("+this.no+")'style='text-decoration:none;'>"+this.rent_content+"</a>"
			}else{
				result+="<a href='javascript:rent_read("+this.no+")'style='text-decoration:none;'>"+this.rent_content.substring(1,20)+"........</a>"
			}
			result+="</td>"
			+"<td  style='text-align: center;'>"
			+this.rent_date
			+"</td>"
			+"<td  style='text-align: center;'>";
			if(this.complete == 'N'){
				result+= "<font style='font-weight: bold; color: red;'>처리중</font>"
			}else{
				result+="<font style='font-weight: bold; color: blue;'>완료</font>"
			};
			result+="</td>"
			+"</tr>"
		});
	}else{
		result+='<td colspan="4" style="text-align: center; font-size:20px;">'
		+'문의 내역이 없습니다.'
		+'</td>'
		+'</tr>'
	}
	document.getElementById("rent_table").innerHTML = result;
}

function getRentList(page){

	$.ajax({
		type : 'get',
		url : '/user/rent/'+page,
		headers : {
			"Content-Type" : "application/json",
			//"X-HTTP-Method-Override" : "GET",  ----  POST 이거나 GET인경우는 생략가능
		},
		dataType : 'json',
		data : {"search" : $("#search").val()},
		success : function(result){
			setRentList(result.l);
			setRentPrint(result.p);
		}
	});
}

getRentList(1);

function setRentPrint(pm){
	var str = "<ul class='pagination'>";
	
	if(pm.prev){
		str += "<li> &lt; </li>"
	}
	
	for(var i = pm.startPage; i <= pm.endPage ; i++){
		if(i == pm.criteria.page){
			str += "<li class='active'><a href='#'>" + i + "</a></li>"
		}else{
			str += "<li><a href='javascript:getRentList("+i+")'>" + i + "</a></li>"
		}
	}
	
	if(pm.next){
		str += "<li> &gt; </li>"
	}
	
	str += "</ul>"
	document.getElementById("rent_page").innerHTML = str;
}



</script>


<%@include file="../include/footer.jsp"%>