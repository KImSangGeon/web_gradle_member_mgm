<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>관리자 회원 목록 보기</title>
</head>
<body>
<%-- ${list } --%>
		<h2>고객 목록</h2>
		<table border="1">
			<thead>
			<tr>
			<td colspan = "5">고객 리스트</td>
			
			</tr>
				<td>아이디</td>
				<td>이름</td>
				<td>나이</td>
				<td>성별</td>
				<td>이메일</td>
			</thead>
			<tbody>
				<c:forEach var = "member" items ="${list }">
					<tr>
						<td>${member.id }</td>
						<td><a href = "GetCustomerInformation?id=${member.id}">${member.name }</a></td>
						<td>${member.age}</td>
						<td>${member.gender }</td>
						<td>${member.email }</td>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan = "4"><a href = "Input.jsp">추가</a></td>
					<td colspan = "1"><a href = "LogoutProcess" >로그아웃</a>	
			</table>
			
</body>
</html>