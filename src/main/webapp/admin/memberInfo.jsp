<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
</head>
<body>
<%-- ${member } --%>
		<fieldset>
			<h2>고객정리</h2>
			<label for = "member">ID : </label>
			<input type="text" name ="member" id = "member" value ="${member.id }"  autofocus required/><br>
			
			<a href = "MemDelServlet?id=${member.id }">삭제</a>
			<a href = "admin/memUpdate.jsp?id=${member.id }
			&name=${member.name}
			&age=${member.age}
			$gender=${member.gender}
			$email=${member.email}">수정</a>
			
						
			</fieldset>


</body>
</html>