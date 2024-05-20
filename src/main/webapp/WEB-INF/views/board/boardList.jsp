<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판</h2>
	<c:if test="${not empty sessionScope.member }">
		<h3><a href="/board/writeFrm">게시글 작성</a></h3>
	</c:if>
	<table border="1">
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="b" items="${list }">
				<tr>
					<td>${b.boardNo }</td>
					<td>
						<a href="/board/boardView?boardNo=${b.boardNo }">${b.boardTitle }</a>
					</td>
					<td>${b.boardWriter }</td>
					<td>${b.readCount }</td>
					<td>${b.boardDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pageNavi">${pageNavi }</div>
	<a href="/">메인으로 가기</a>
</body>
</html>