<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hamster.hamster.Hamster" %>
<html>
	<head>
		<title>Hamster Information List</title>
	</head>
	<body>
		<%@include file="top.jsp" %>
		[햄스터 정보 목록]
		<table border='2'>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>종</td>
			</tr>
			<% 
				List<Hamster> list = (List<Hamster>) request.getAttribute("list");
				for (int i = 0; i < list.size(); i++ ) {
					Hamster hamster = list.get(i);
			%> 		
					<tr>
						<td>${ list.get(i).no}</td>
						<td><a href='<%= this.getServletContext().getContextPath() + "/hamster/view?no=" + hamster.getNo()%>'><%= hamster.getName()%></a></td>
						<td><%= hamster.getSpecies()%></td>
					</tr>		
			<%	}%>
		</table>
		<a href='<%= this.getServletContext().getContextPath() + "/hamster/add"%>'><input type="button" value="등록하기"></a>
	</body>
</html>