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
	<h2>게시글 작성</h2>
	<form action="/board/write" method="post" enctype="multipart/form-data">
		<table border="1">
			<tbody>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="boardTitle">
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" value="${sessionScope.member.memberId}" name="boardWriter" readonly>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="boardContent"></textarea>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<input type="file" multiple="multiple" name="upfile">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">작성완료</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<a href="/board/boardList?reqPage=1">목록</a>
</body>
</html>