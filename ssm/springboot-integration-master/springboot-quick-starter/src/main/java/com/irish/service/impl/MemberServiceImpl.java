package com.irish.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irish.dao.MemberDao;
import com.irish.model.Member;
import com.irish.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	

	@Override
	public void insert(Member m) {
		memberDao.insert(m);
	}


	@Override
	public void selectByExample(int offset , int pageSize) {
		RowBounds rowBounds = new RowBounds(offset, pageSize);
		List<Member> users = memberDao.selectByExampleWithRowbounds(null, rowBounds);
		users.forEach((x) -> {
			System.out.println(x.getId());
		});
	}

}
