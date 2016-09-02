<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
<%@include file="./sidebar.jsp"%>

<style>

	.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th{
		vertical-align:middle;
	}
	
	.table{
		border:1px solid lightgray;
	}

</style>

<div style="width:400px margin:0 auto;" >
	<h1>비밀번호찾기 --> 변경</h1>
	<form action="/user/pwFindAndEdit" id="pwFindAndEdit" name="pwFindAndEdit" method="post">
		<table class="table">
			<tr>
				<th>새 비밀번호</th><td><input type="text" id="newPw" name="newPw" ></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th><td><input type="text" id="newPwCheck" name="newPwCheck" ></td>
			</tr>
		</table>
	</form>
</div>

<%@include file="../include/footer.jsp"%>