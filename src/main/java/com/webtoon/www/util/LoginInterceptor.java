package com.webtoon.www.util;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.webtoon.www.member.model.dto.Member;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(); // session 가져오기
		Member member = (Member)session.getAttribute("member"); //session에서 member객체 꺼내고, object타입이므로 Member타입으로 형변환
		if(member != null) {//로그인 되어있으면
			return true;//컨트롤러 실행O
		}else {
			response.sendRedirect("/member/signInFrm");
			return false;//컨트롤러 멈추고, MemberController에 signInFrm메소드 실행
			
		}
	}
	
	

}
