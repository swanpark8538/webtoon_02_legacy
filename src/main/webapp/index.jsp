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
	<c:if test="${empty sessionScope.member}">
	<ul>
      <li><a href="/member/signInFrm">로그인</a></li>
      <li><a href="/member/signUpFrm">회원가입</a></li>
      <li><a href="/board/boardList?reqPage=1">게시판</a></li>
    </ul>
    </c:if>
    <c:if test="${not empty sessionScope.member}">
    <ul>
      <li><a href="/member/mypage/myInfoFrm">마이페이지</a></li>
      <li><a href="/member/signOut">로그아웃</a></li>
      <li><a href="/board/boardList?reqPage=1">게시판</a></li>
     </ul>
     </c:if>
     
</body>
</html>