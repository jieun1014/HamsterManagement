<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<html>
	<head>
		<title>Hamster Information Add</title>
	</head>
	<body>
		<%@ include file="top.jsp"%>
		 <form action='http://192.168.60.57/hamster/add' method='post'>
				[햄스터 개별 정보 등록]<br/>
				<table>
					<tr>
						<td>이름</td>
						<td><input type='text' name='name'></td>
					</tr>
					<tr>
						<td>성별</td>
						<td><input type='radio' name='gender' value='M'>수컷 <input type='radio' name='gender' value='F'>암컷 </td>
					</tr>
					<tr>
						<td>종</td>
						<td><input type='radio' name='species' value='G'> 시리아 <input type='radio' name='species' value='W'> 윈터화이트  <input type='radio' name='species' value='K'> 캠밸  <input type='radio' name='species' value='R'> 로브로브 스키  <input type='radio' name='species' value='C'> 차이니즈 </td>
					</tr>
					<tr>
						<td>태어난 날</td>
						<td><input type='text' name='birth_date'></td>
					</tr>
					<tr>
						<td>색깔</td>
						<td><input type='text' name='color'></td>
					</tr>
					<tr>
						<td>상태</td>
						<td><input type='text' name='status'></td>
					</tr>
				</table>
			<input type='submit' value='등록'>
			<a href='<%= this.getServletContext().getContextPath() + "/hamster/list"%>'><input type='button' value='뒤로가기'></a>
		</form>
	</body>
</html>