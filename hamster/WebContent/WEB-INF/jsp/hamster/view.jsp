<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.hamster.hamster.Hamster" %>

<% Hamster hamster = (Hamster) request.getAttribute("view");
%>
<html>
	<head>
		<title>Hamster Information view</title>
	</head>
	<body>
		<%@ include file="top.jsp" %>
		[햄스터 상세 정보]
		<table border='2'>
			<tr>
				<td>번호</td>
				<td><%= hamster.getNo()%></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%= hamster.getName()%></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><%= hamster.getGender()%></td>
			</tr>
			<tr>
				<td>종</td>
				<td><%= hamster.getSpecies()%></td>
			</tr>
			<tr>
				<td>태어난 날</td>
				<td><%= hamster.getBirth_date()%></td>
			</tr>
			<tr>
				<td>색깔</td>
				<td><%= hamster.getColor()%></td>
			</tr>
			<tr>
				<td>상태</td>
				<td><%= hamster.getStatus()%></td>
			</tr>
		</table>
		<br/>
		<a href='<%= this.getServletContext().getContextPath() + "/hamster/edit?no=" + hamster.getNo() %>'><input type='button' value='수정하기'></a>
		<a href='<%= this.getServletContext().getContextPath() + "/hamster/delete?no=" + hamster.getNo() %>'><input type='button' value='삭제하기'></a>
		<a href='<%= this.getServletContext().getContextPath() + "/hamster/list"%>'><input type='button' value='뒤로가기'></a>
	</body>
</html>