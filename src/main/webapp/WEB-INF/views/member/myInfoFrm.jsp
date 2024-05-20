<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 구글 아이콘 -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
  <!-- jquery -->
  <script src="/resources/js/jquery-3.6.0.js"></script>
  <!-- 페이지 js -->
  <!-- 기본 CSS -->
  <link rel="stylesheet" href="/resources/css/default-psw.css" />
  <!-- 페이지 CSS -->
  <link rel="stylesheet" href="/resources/css/member/myInfoFrm.css" />
</head>
<body>

  <!-- main -->
  <main class="main">

    <!-- main-myInfo -->
    <main class="main-myInfo">

      <h2 class="page-title">내 정보 수정</h2>

      <div class="seperate seperate-right seperate-this">
        <span class="text-color-red">*</span>
        <span>필수입력사항</span>
      </div>

      <form action="/member/mypage/updateMyInfo" method="post" class="myInfo-form" id="myInfo-form">

        <!-- id -->
        <div class="inputWrap-default">
          <label for="memberId">
            <div class="inputTitleDiv">
              <span>아이디</span>
              <span>*</span>
            </div>
          </label>
          <label for="memberId">
            <div class="inputDiv">
              <!-- id만 autofocus 넣기. 페이지 로드 완료시 커서 위치이고, boolean형임. -->
              <input type="text" name="memberId" id="memberId" required
                value="${sessionScope.member.memberId}" readonly>
            </div>
          </label>
        </div>
        <!-- //id -->

        <!-- nickName -->
        <div class="inputWrap-default">
          <label for="memberNickName">
            <div class="inputTitleDiv">
              <span>닉네임</span>
              <span>*</span>
            </div>
          </label>
          <label for="memberNickName">
            <div class="inputDiv">
              <input type="text" name="memberNickName" id="memberNickName" required autofocus
              value="${sessionScope.member.memberNickName}">
            </div>
          </label>
          <button type="button" class="btn-default btn-bg-blue_light" id="checkNickName">중복 확인</button>
        </div>
        <!-- //nickName -->

        <!-- name -->
        <div class="inputWrap-default">
          <label for="memberName">
            <div class="inputTitleDiv">
              <span>이름</span>
              <span>*</span>
            </div>
          </label>
          <label for="memberName">
            <div class="inputDiv">
              <input type="text" name="memberName" id="memberName" required
              value="${sessionScope.member.memberName}">
            </div>
          </label>
        </div>
        <!-- //name -->

        <!-- email -->
        <div class="inputWrap-default">
          <label for="memberEmail">
            <div class="inputTitleDiv">
              <span>이메일</span>
              <span>*</span>
            </div>
          </label>
          <label for="memberEmail">
            <div class="inputDiv">
              <input type="email" name="memberEmail" id="memberEmail"
                placeholder="예 : example@gmail.com"
                required
                value="${sessionScope.member.memberEmail}">
              <span>03:00</span>
            </div>
          </label>
          <button type="button" class="btn-default btn-bg-blue_light" id="authEmail">인증번호 발송</button>
        </div>
        <!-- //email -->

        <!-- phone -->
        <div class="inputWrap-default">
          <label for="memberPhone">
            <div class="inputTitleDiv">
              <span>휴대폰</span>
              <span>*</span>
            </div>
          </label>
          <label for="memberPhone">
            <div class="inputDiv">
              <input type="text" name="memberPhone" id="memberPhone"
                placeholder="숫자만 입력해주세요(예 : 01012345678)"
                required
                value="${sessionScope.member.memberPhone}">
            </div>
          </label>
          <button type="button" class="btn-default btn-bg-blue_light" id="authPhone">본인 인증</button>
        </div>
        <!-- //phone -->

        <!-- address -->
        <div class="inputWrap-address">
          <div class="inputTitleDiv">
            <span>주소</span>
          </div>
          <div class="inputDivWrap">
            <div class="inputDiv">
              <input type="text" name="addressMain" id="addressMain"
                placeholder="주소를 검색해주세요."
                readonly>
            </div>
            <div class="inputDiv">
              <input type="text" name="memberAddress" id="memberAddress"
                placeholder="상세주소를 입력해주세요."
                value="${sessionScope.member.memberAddress}">
            </div>
          </div>
          <button type="button" class="btn-default btn-bg-blue_light" id="searchAddress">주소 검색</button>
        </div>
        <!-- //address -->

        <!-- birthdate -->
        <div class="inputWrap-birthdate">
          <label for="memberBirthdate">
            <div class="inputTitleDiv">
              <span>주민등록번호</span>
              <span>*</span>
            </div>
          </label>
          <label for="memberBirthdate">
            <div class="inputDiv-b">
              <input type="text" name="memberBirthdate" id="memberBirthdate" required
                value="${sessionScope.member.memberBirthdate}">
            </div>
          </label>
          <div class="dashDiv">
            <span>-</span>
          </div>
          <label for="memberGender">
            <div class="inputDiv-g">
              <input type="text" name="memberGender" id="memberGender" required
                value="${sessionScope.member.memberGender}">
              <span>******</span>
            </div>
          </label>
        </div>
        <!-- //birthdate -->

        <div class="seperate seperate-right seperate-this">
          <span class="text-color-red">내 정보를 수정하기 위해 현재 비밀번호를 입력해주세요.</span>
        </div>

        <!-- password -->
        <div class="checkPassword">
          <div class="inputWrap-default">
            <label for="memberPw">
              <div class="inputTitleDiv">
                <span>현재 비밀번호</span>
                <span>*</span>
              </div>
            </label>
            <label for="memberPw">
              <div class="inputDiv">
                <input type="password" name="memberPw" id="memberPw" required>
              </div>
            </label>
          </div>
        </div>
        <!-- //password -->

        <div class="seperate seperate-right seperate-this">
        </div>

      </form>
      <!-- //form -->

      <div class="btnArea">
        <button type="submit" form="myInfo-form" class="btn-big btn-bg-blue_bold" id="signUpBtn">수정하기</button>
      </div>

    </main>
    <!-- //main-myInfo -->

  </main>
  <!-- //main -->

</body>
</html>