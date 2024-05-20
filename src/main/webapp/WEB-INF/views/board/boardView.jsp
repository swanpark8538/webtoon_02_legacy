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
	<h2>게시글 상세</h2>
	<table border="1">
		<tbody>
			<tr>
				<th>제목</th>
				<td colspan="5">${board.boardTitle}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.boardWriter }</td>
				<th>작성일</th>
				<td>${board.boardDate }</td>
				<th>조회수</th>
				<td>${board.readCount }</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="5">
					<c:forEach items="${board.fileList }" var="file">
						<div>
							<a href="/board/downloadFile?filename=${file.filename }&filepath=${file.filepath}">${file.filename }</a>
						</div>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="5">${board.boardContent }</td>
			</tr>
			<c:if test="${not empty sessionScope.member && sessionScope.member.memberId eq board.boardWriter }">
				<tr>
					<td colspan="6">
						<a href="/board/updateFrm?boardNo=${board.boardNo }">수정</a>
						<a href="/board/delete?boardNo=${board.boardNo }">삭제</a>
					</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<a href="/board/boardList?reqPage=1">목록</a>
</body>
</html>