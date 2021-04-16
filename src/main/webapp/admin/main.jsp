<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:set var="id" value="${id}" />
<!-- 보안문제로 한번 더 선언 -->
<c:if test="${id eq null}">
	<c:redirect url="loginForm.jsp" />
</c:if> --%>
<%-- 
로그인한 아이디 ${id}
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>	
	<h3>${id}  로그인 하셨습니다.</h3>

	<c:if test="${id eq 'admin' }">
		<a href="MemberList">관리자모드 접속(회원 목록 보기)</a>
	</c:if>
	<br>
	<a href="LogoutProcess">로그아웃</a>
</body>
</html>