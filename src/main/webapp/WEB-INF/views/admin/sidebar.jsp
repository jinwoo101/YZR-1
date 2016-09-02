<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
/* remove outer padding */
.main .row {
	padding: 0px;
	margin: 0px;
}
/*Remove rounded coners*/
nav.sidebar.navbar {
	border-radius: 0px;
}
nav.sidebar, .main {
	-webkit-transition: margin 200ms ease-out;
	-moz-transition: margin 200ms ease-out;
	-o-transition: margin 200ms ease-out;
	transition: margin 200ms ease-out;
}
/* Add gap to nav and right windows.*/
.main {
	padding: 10px 10px 0 10px;
}
/* .....NavBar: Icon only with coloring/layout.....*/

/*small/medium side display*/
@media ( min-width : 768px) {
	/*Allow main to be next to Nav*/
	.main {
		position: absolute;
		width: calc(100% - 40px); /*keeps 100% minus nav size*/
		margin-left: 40px;
		float: right;
	}
	/*lets nav bar to be showed on mouseover*/
	nav.sidebar:hover+.main {
		margin-left: 200px;
	}
	/*Center Brand*/
	nav.sidebar.navbar.sidebar>.container .navbar-brand, .navbar>.container-fluid .navbar-brand
		{
		margin-left: 0px;
	}
	/*Center Brand*/
	nav.sidebar .navbar-brand, nav.sidebar .navbar-header {
		text-align: center;
		width: 100%;
		margin-left: 0px;
	}
	/*Center Icons*/
	nav.sidebar a {
		padding-right: 13px;
	}
	/*adds border top to first nav box */
	nav.sidebar .navbar-nav>li:first-child {
		border-top: 1px #000 solid;
	}
	/*adds border to bottom nav boxes*/
	nav.sidebar .navbar-nav>li {
		border-bottom: 1px #000 solid;
	}
	/* Colors/style dropdown box*/
	nav.sidebar .navbar-nav .open .dropdown-menu {
		position: static;
		float: none;
		width: auto;
		margin-top: 0;
		background-color: transparent;
		border: 0;
		-webkit-box-shadow: none;
		box-shadow: none;
	}
	/*allows nav box to use 100% width*/
	nav.sidebar .navbar-collapse, nav.sidebar .container-fluid {
		padding: 0 0px 0 0px;
	}
	/*colors dropdown box text */
	.navbar-inverse .navbar-nav .open .dropdown-menu>li>a {
		color: #000;
	}
	/*gives sidebar width/height*/
	nav.sidebar {
		width: 200px;
		height: 100%;
		margin-left: -160px;
		float: left;
		z-index: 8000;
		margin-bottom: 0px;
	}
	/*give sidebar 100% width;*/
	nav.sidebar li {
		width: 100%;
	}
	/* Move nav to full on mouse over*/
	nav.sidebar:hover {
		margin-left: 0px;
	}
	/*for hiden things when navbar hidden*/
	.forAnimate {
		opacity: 0;
	}
}
/*Allow main to be next to Nav*/
.main {
	width: calc(100% - 200px); /*keeps 100% minus nav size*/
	margin-left: 200px;
}
/*Show all nav*/
nav.sidebar {
	margin-left: 0px;
	float: left;
}
/*Show hidden items on nav*/
nav.sidebar .forAnimate {
	opacity: 1;
}
nav.sidebar .navbar-nav .open .dropdown-menu>li>a:hover, nav.sidebar .navbar-nav .open .dropdown-menu>li>a:focus
	{
	color: #000;
	background-color: transparent;
}
nav:hover .forAnimate {
	opacity: 1;
}
section {
	padding-left: 15px;
}
</style>
<div id="wrap_content" style="position: absolute; left: 250px;">
	<nav class="navbar navbar-defalt sidebar" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="font-weight: bold;">회원 관리 <span class="caret"></span>
				<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a>
					<ul class="dropdown-menu forAnimate" role="menu">
						<li><a href="/admin/user">회원 목록</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="font-weight: bold;">영화 관리 <span class="caret"></span>
				<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-film"></span></a>
					<ul class="dropdown-menu forAnimate" role="menu">
						<li><a href="/admin/movie">영화 목록</a></li>
						<li><a href="/admin/movie/new">영화 등록</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="font-weight: bold;">상영시간 관리 <span class="caret"></span>
				<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-time"></span></a>
					<ul class="dropdown-menu forAnimate" role="menu">
						<li><a href="/admin/timetable">상영시간표</a></li>
						<li><a href="/admin/timetable/new">상영시간 등록</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="font-weight: bold;">문의 관리 <span class="caret">
				</span><span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-question-sign"></span></a>
					<ul class="dropdown-menu forAnimate" role="menu">
						<li><a href="/admin/qna">1:1 문의</a></li>
						<li><a href="/admin/rent">대관 문의</a></li>
						<li><a href="/admin/lost">분실물 문의</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="font-weight: bold;">공지 관리 <span class="caret"></span>
				<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-pencil"></span></a>
					<ul class="dropdown-menu forAnimate" role="menu">
						<li><a href="/admin/notice">공지 목록</a></li>
						<li><a href="/admin/notice/new">공지 등록</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="font-weight: bold;">쿠폰 발송 <span class="caret"></span>
				<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-send"></span></a>
					<ul class="dropdown-menu forAnimate" role="menu">
						<li><a href="/admin/usercoupon">개인 발송</a></li>
						<li><a href="/admin/clubcoupon">클럽 발송</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="font-weight: bold;">기타 관리 <span class="caret"></span>
				<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-wrench"></span></a>
					<ul class="dropdown-menu forAnimate" role="menu">
						<li><a href="/admin/actor/new">배우 등록</a></li>
						<li><a href="/admin/director/new">감독 등록</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	</nav>
</div>