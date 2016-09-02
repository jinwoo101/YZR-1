<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>

<style>
	th{background-color:#bf4040; color:white;}	
	th,td{text-align:center;}
	.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th{
		vertical-align:middle;
	}
	
	.table{
		border:1px solid lightgray;
	}
</style>

<script type="text/javascript">

</script>
<div style="width:340px; margin:0 auto;">
	
	<table class="table" >
	
		<c:choose>
			<c:when test="${ idFind != null }">
				<tr>
					<td colspan="2" ><h3>아이디를 찾았습니다.</h3></td>
				</tr>
				<tr>
					<th>아이디</th><td>${ idFind }</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="2" ><h3>정신차리고 검색해라!!!</h3></td>
				</tr>
				<tr>
					<th>아이디</th><td>검색된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		
	</table>
</div>
<hr>
<%@include file="../include/footer.jsp"%>