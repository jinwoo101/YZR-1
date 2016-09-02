<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
<style>
	box1{
		margin:50px;
		border:1px;
	}
	.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th{
		vertical-align:middle;
	}
	
	.table{
		border:1px solid lightgray;
	}
</style>

<div id="box1" align="center" >
	<div style="margin-top:30px;" >
		<h2>아이디 찾기</h2>
	</div>
	
	<br>
	<form id="idSearch" name="idSearch" action="/user/idFind"  method="post">
		<table class="table" style="width:240px;" >
			<tr>
				<td><input type="text" id="member_name" class="form-control" name="member_name" placeholder="이름" /></td>
			</tr>
			<tr>
				<td><input type="text" id="email" name="email" class="form-control" placeholder="아이디" /></td>
			</tr>
		</table>
		<input type="button" onclick="inputCheck()" class="btn btn-danger btn-lg" value="확인"/>
	</form>
</div>
<script type="text/javascript">
	function inputCheck(){
		
		var form = document.getElementById("idSearch");
		
		if($("#member_name").val()==null||$("#member_name").val()==""){
			alert("이름을 입력하세요.");
		}else if($("#email").val()==null||$("#email").val()==""){
			alert("이메일을 입력하세요.");
		}else{
			form.submit();
		}
	}
</script>
<%@include file="../include/footer.jsp"%>