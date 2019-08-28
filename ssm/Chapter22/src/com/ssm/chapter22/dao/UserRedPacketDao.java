package com.ssm.chapter22.dao;

import org.springframework.stereotype.Repository;
import com.ssm.chapter22.pojo.UserRedPacket;

@Repository
public interface UserRedPacketDao {

	/**
	 * �����������Ϣ.
	 * @param userRedPacket �����������Ϣ
	 * @return Ӱ���¼��.
	 */
	public int grapRedPacket(UserRedPacket  userRedPacket);
}
