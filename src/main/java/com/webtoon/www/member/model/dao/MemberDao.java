package com.webtoon.www.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webtoon.www.member.model.dto.Member;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate session;
	public int insertMember(Member m) {
		return session.insert("member.insertMember",m);
	}

	public Member selectOneMember(Member m) {
		// TODO Auto-generated method stub
		return session.selectOne("member.selectOneMember",m);
	}

	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return session.update("member.updateMember",m);
	}

}
