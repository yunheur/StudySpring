<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 목</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>프로젝트 목록</h1>
<p><a href='add.do'>신규 프로젝트</a></p>
<table border="1">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>시작일</th>
	<th>종료일</th>
	<th>상태</th>
	<th></th>
</tr>
<c:forEach var="project" items="${projects}">
<tr>
	<td>${project.no}</td>
	<td><a href='update.do?no=${project.no}'>${project.title}</a></td>
	<td>${project.startDate}</td>
	<td>${project.endDate}</td>
	<td>${project.state}</td>
	<td><a href='delete.do?no=${project.no}'>[삭제]</a></td>
</tr>
</c:forEach>
</table>
<jsp:include page="/Tail.jsp"/>
</body>
</html>