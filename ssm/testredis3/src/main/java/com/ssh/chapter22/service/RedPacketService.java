package com.ssm.chapter22.service;

import com.ssm.chapter22.pojo.RedPacket;

public interface RedPacketService {

	public RedPacket getRedPacket(Long id);

	public int decreaseRedPacket(Long id);
	
}