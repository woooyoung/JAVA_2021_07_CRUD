package com.sbs.java.crud.service;

import com.sbs.java.crud.container.Container;
import com.sbs.java.crud.dao.MemberDao;
import com.sbs.java.crud.dto.Member;

public class MemberService {

	private MemberDao memberDao;

	public MemberService() {
		memberDao = Container.memberDao;
	}

	public int getMemberIndexByLoginId(String loginId) {

		return memberDao.getMemberIndexByLoginId(loginId);
	}

	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	}

	public void join(Member member) {
		memberDao.add(member);
	}

}
