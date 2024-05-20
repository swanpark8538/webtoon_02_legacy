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
	<h2>게시글 수정</h2>
	<form action="/board/update" id="updateFrm" method="post" enctype="multipart/form-data">
		<table border="1">
			<tbody>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="boardTitle" value="${board.boardTitle}">
						<input type="hidden" name="boardNo" value="${board.boardNo}">
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" value="${board.boardWriter}" name="boardWriter" readonly>
					</td>
				</tr>
				<tr>
					<th>기존 첨부파일</th>
					<td>
						<c:forEach items="${board.fileList }" var="file">
							<ul>
								<li>
									<span>${file.filename }</span>
									<button type="button" onclick="delFile(this,${file.boardFileNo});">삭제</button>
								</li>
							</ul>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th>첨부파일 추가</th>
					<td>
						<input type="file" multiple="multiple" name="upfile">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="boardContent">${board.boardContent}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">수정완료</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<a href="/board/boardList?reqPage=1">목록</a>
<script th:inline="javascript">
	const delFile = (obj, boardFileNo) => {
	    const delFileInput = document.createElement("input");
	    delFileInput.setAttribute("type", "hidden");
	    delFileInput.setAttribute("name", "delFileNo");
	    delFileInput.value = boardFileNo;
	    document.querySelector("#updateFrm").appendChild(delFileInput);
	    obj.parentElement.remove();
	}
</script>
</body>
</html>