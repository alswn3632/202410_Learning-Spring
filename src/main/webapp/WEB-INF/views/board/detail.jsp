<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Board Detail Page! </h1>
	<hr>
	
	<table>
		<tr>
			<th>no.</th>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th>title.</th>
			<td>${bvo.title }</td>
		</tr>
		<tr>
			<th>writer.</th>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<th>content.</th>
			<td>${bvo.content }</td>
		</tr>
		<tr>
			<th>regDate.</th>
			<td>${bvo.regDate }</td>
		</tr>
		<tr>
			<th>modDate.</th>
			<td>${bvo.modDate }</td>
		</tr>
	</table>
	
	<a href="/board/modify?bno=${bvo.bno }"><button type="button">modify</button></a>
	<a href="/board/delete?bno=${bvo.bno }"><button type="button">delete</button></a>
	<a href="/board/list"><button type="button">list</button></a>
	
</body>
</html>