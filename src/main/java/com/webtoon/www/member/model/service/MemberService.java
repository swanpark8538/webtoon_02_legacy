package com.webtoon.www.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webtoon.www.member.model.dao.MemberDao;
import com.webtoon.www.member.model.dto.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//PasswordEncAdvice클래스에서
	//resultType = int && 메소드명 = *BCrypt && 첫번째 매개변수 = Member객체
	//인 것에 그 메소드 실행 전에 비밀번호가 암호화되도록 해놨음
	//그래서 selectOneMember같은 메소드는 리턴타입부터 틀리므로 해당 메소드 내에서 직접 암호화해야 함.

	@Transactional
	public int insertMember_BCrypt(Member m) {
		return memberDao.insertMember(m);
	}

	public Member selectOneMember(Member m) {
		Member selectedMember = memberDao.selectOneMember(m);
		if(m!=null && bCryptPasswordEncoder.matches(m.getMemberPw(), selectedMember.getMemberPw())) {
			return selectedMember;
		}else {
			return null;
		}
	}

	@Transactional
	public int updateMember_BCrypt(Member m) {
		//id와 pw가 일치하는 회원이 있는지 확인
		Member searchMember = selectOneMember(m);
		if(searchMember != null) {//회원이 존재한다면
			return memberDao.updateMember(m);
		} else {//회원이 존재하지 않는다면
			return 0;
		}
	}

}
