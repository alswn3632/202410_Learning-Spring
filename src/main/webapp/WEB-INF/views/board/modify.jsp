<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Board Modify Page! </h1>
	<hr>
	<form action="/board/update" method="post">
		<table>
			<tr>
				<th>no.</th>
				<td>${bvo.bno } <input type="hidden" name="bno" value="${bvo.bno }"></td>
			</tr>
			<tr>
				<th>title.</th>
				<td><input type="text" name="title" value="${bvo.title }"></td>
			</tr>
			<tr>
				<th>writer.</th>
				<td><input type="text" name="writer" value="${bvo.writer }"></td>
			</tr>
			<tr>
				<th>content.</th>
				<td><textarea rows="10" cols="50" name="content">${bvo.content }</textarea></td>
			</tr>
		</table>
	
		<button type="submit">update</button>
		
	</form>
	
</body>
</html>