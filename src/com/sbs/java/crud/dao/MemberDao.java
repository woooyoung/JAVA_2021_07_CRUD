package com.sbs.java.crud.dao;

import java.util.ArrayList;
import java.util.List;

import com.sbs.java.crud.dto.Member;

public class MemberDao {
	public List<Member> members; 
	
	public MemberDao() {
		members = new ArrayList<>();
	}
}
