<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="com.hamster.hamster.Hamster" %>

<% Hamster hamster = (Hamster) request.getAttribute("edit");

	int no = hamster.getNo();
	String name = hamster.getName();
	String gender = hamster.getGender();
	String species = hamster.getSpecies();
	String birth_date = hamster.getBirth_date();
	String color = hamster.getColor();
	String status = hamster.getStatus();	
%>
<html>
	<head>
		<title>Hamster Information Edit</title>
	</head>
	<body>
		<%@ include file="top.jsp" %>
		[햄스터 정보 수정]
		<form action='<%= application.getContextPath() +"/hamster/edit?no=" + no %>' method='post'>
			<table border='2'>
				<tr>
					<td>번호</td>
					<td><%= no%></td>	
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%= name%>"></td>	
				</tr> 
				<tr>
					<td>성별</td>
					<td><input type='radio' name='gender' value='M'>수컷 <input type='radio' name='gender' value='F'>암컷</td>	
				</tr> 
				<tr>
					<td>종</td>
					<td><input type='radio' name='species' value='G'> 시리아 <input type='radio' name='species' value='W'> 윈터화이트  <input type='radio' name='species' value='K'> 캠밸  <input type='radio' name='species' value='R'> 로브로브 스키  <input type='radio' name='species' value='C'> 차이니즈 </td>	
				</tr> 
				<tr>
					<td>태어난 날</td>
					<td><input type="text" name="birth_date" value="<%= birth_date%>"></td>	
				</tr> 
				<tr>
					<td>색깔</td>
					<td><input type="text" name="color" value="<%= color%>"></td>	
				</tr> 
				<tr>
					<td>상태</td>
					<td><textarea name="status" ><%= status%></textarea></td>	
				</tr>  
			</table>
			<input type="submit" value="수정 완료"> 
			<a href='<%= application.getContextPath() + "/hamster/list" %>'><input type="button" value="뒤로가기"></a>
		</form>
	</body>
</html>