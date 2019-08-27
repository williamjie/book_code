package com.irish.dao;

import com.irish.model.Member;
import com.irish.model.MemberExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface MemberDao {
    int deleteByPrimaryKey(Long id);

    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExampleWithRowbounds(MemberExample example, RowBounds rowBounds);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}