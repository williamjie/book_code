package com.irish.service;

import com.irish.model.Member;

public interface MemberService {

	void insert(Member m);

	void selectByExample(int offset, int pageSize);

}
