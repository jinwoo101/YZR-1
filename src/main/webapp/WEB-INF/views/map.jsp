<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./include/header.jsp"%>
<script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<style>
	#reservation_content>div>div {
		float: left;
		width: 100px;
		font-weight: bold;
	}
	#reservation_content>div>div, #reservation_content>div>span {
		font-size: 13pt;
	}
	#reservation_content>div {
		margin-top:5px;
		margin-bottom:5px;
	}
	
	#table_wrap {
		margin:0px auto;
		width: 80%;
		border-radius: 15px;
		border:1px solid #000;
		margin-bottom : 20px;
	}
	table{
		width:100%;
	}
	th, td{
		width:50%;
	}
	th {
		font-size:25pt;
		text-align: center;
		border-bottom: 2px solid #000;
	}
	td {
		padding-left: 15px;		
	}
	#reservationCode {
		font-size: 15pt;
		text-align: center;
	}
	#map {
		margin:0px auto;
	}
	input{
		
	}
</style>

<script>
	function initialize() {
		var Y_point = parseFloat(frm.ypoint.value); // Y 좌표
		var X_point = parseFloat(frm.xpoint.value); // X 좌표

		var zoomLevel = 16; // 지도의 확대 레벨 : 숫자가 클수록 확대정도가 큼
		var markerTitle = $("#theaterName").val(); // 현재 위치 마커에 마우스를 오버했을때 나타나는 정보
		var markerMaxWidth = 300;
		// 말풍선 내용
		var contentString = $("#theaterAddr").val();
		var myLatlng = new google.maps.LatLng(Y_point, X_point);
		var mapOptions = {
			zoom : zoomLevel,
			center : myLatlng,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		} 
		var map = new google.maps.Map(document.getElementById('map'), mapOptions);
		var marker = new google.maps.Marker({
			position : myLatlng,
			map : map,
			title : markerTitle
		});
		var infowindow = new google.maps.InfoWindow({
			content : contentString,
			maxWidth : markerMaxWidth
		});
		google.maps.event.addListener(marker, 'click', function() {
			infowindow.open(map, marker);
		});
	}
	
	var load = setInterval(function() {
		initialize();
		clearInterval(load);
		
	},500);
	
	function goHome() {
		location.href="/index";
	}
	
</script>
<div class="content">
	<c:forEach items="${ reservationList }" var="reservation_list">
	<div id="table_wrap">
	<table class="reservation_table">
		<tr>
			<th>예매번호</th><th>예매정보</th>		
		</tr>
		<tr>
			<td id="reservationCode">${ reservation_list.reservation_code }</td>
			<td id="reservation_content">
			
				<div>
					<div>영화명</div><span>${ reservationMap.movie.title }</span>
				</div>
				<div>
					<div>관람극장</div><span>${ reservationMap.theater.theater_name } ${ reservation_list.plex_number }관 / ${ reservation_list.ticket_cnt }명</span>
				</div>
				<div>
					<div>관람좌석</div><span>${ reservation_list.view_seat }</span>
				</div>
				<div>
					<div>관람일시</div><span>${ reservation_list.start_time }</span>
				</div>
				<div>
					<div>결제</div><span>${ reservation_list.pay_method } / ${ reservation_list.pay }원</span>
				</div>
				
			</td>
		</tr>
	</table>
	</div>
	</c:forEach>
	<div id="map" style="width: 1000px; height: 600px;"></div>
	<form id="frm" name="frm">
		<c:forEach items="${ theaterList }" var="theater_list">
			<input type="hidden" id="xpoint" name="xpoint" value="${theater_list.xpoint}">
			<input type="hidden" id="ypoint" name="ypoint" value="${theater_list.ypoint}">
			<input type="hidden" id="theaterName" name="theaterName" value="${theater_list.theater_name}">
			<input type="hidden" id="theaterAddr" name="theaterAddr" value="${theater_list.theater_address}">
		</c:forEach>
	</form>
</div>
<div style="width:100%; text-align: center; padding-top:10px;">
	<input type="button"  class="btn btn-warning btn-lg" onclick="goHome()" value="메인페이지로">
</div>

<%@include file="./include/footer.jsp"%>