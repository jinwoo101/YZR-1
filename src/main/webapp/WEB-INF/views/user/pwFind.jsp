<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
<script type="text/javascript">

	function pwChange(){
		alert("비밀번호가 변경되었습니다!");
		var pwFindAndEdit = $("#pwFindAndEdit");
		pwFindAndEdit.submit();
	}

</script>

<style>

	h3{text-align:center;}
	th{background-color:#bf4040; color:white;}
	
	.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th{
		vertical-align:middle;
	}
	
	.table{
		border:1px solid lightgray;
	}

</style>
	<div style="width:400px; margin:0 auto;" >
		
		<br>
		<h3>새 비밀번호를 입력하세요</h3>
		<br>
		<form action="/user/pwFindAndEdit" id="pwFindAndEdit" name="pwFindAndEdit" method="post">
		<input type="hidden" id="member_id" name="member_id" value="${pwFindId}" >
			<table class="table">
				<tr>
					<th>새 비밀번호</th><td><input type="password" class="form-control" id="newPw" name="newPw" ></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th><td><input type="password" class="form-control" id="newPwCheck" name="newPwCheck" ></td>
				</tr>
			</table>
			<div align="center" >
				<input type="button" onclick="pwChange()" class="btn btn-danger" value="변경하기">
			</div>
			
		</form>
	</div>
<hr>
<%@include file="../include/footer.jsp"%>