package com.ssm.chapter22.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ssm.chapter22.pojo.UserRedPacket;
import com.ssm.chapter22.service.RedisRedPacketService;
	/*

@Service
public class RedisRedPacketServiceImpl implements RedisRedPacketService {

	private static final String PREFIX = "red_packet_list_";
	// ÿ��ȡ��1000��������һ��ȡ������̫���ڴ�
	private static final int TIME_SIZE = 1000;

	@Autowired
	private RedisTemplate redisTemplate = null; // RedisTemplate

	@Autowired
	private DataSource dataSource = null; // ����Դ

	@Override
	// �������߳�����
	@Async
	public void saveUserRedPacketByRedis(Long redPacketId, Double unitAmount) {
		System.err.println("��ʼ��������");
		Long start = System.currentTimeMillis();
		// ��ȡ�б��������
		BoundListOperations ops = redisTemplate.boundListOps(PREFIX + redPacketId);
		Long size = ops.size();
		Long times = size % TIME_SIZE == 0 ? size / TIME_SIZE : size / TIME_SIZE + 1;
		int count = 0;
		List<UserRedPacket> userRedPacketList = new ArrayList<UserRedPacket>(TIME_SIZE);
		for (int i = 0; i < times; i++) {
			// ��ȡ����TIME_SIZE���������Ϣ
			List userIdList = null;
			if (i == 0) {
				userIdList = ops.range(i * TIME_SIZE, (i + 1) * TIME_SIZE);
			} else {
				userIdList = ops.range(i * TIME_SIZE + 1, (i + 1) * TIME_SIZE);
			}
			userRedPacketList.clear();
			// ��������Ϣ
			for (int j = 0; j < userIdList.size(); j++) {
				String args = userIdList.get(j).toString();
				String[] arr = args.split("-");
				String userIdStr = arr[0];
				String timeStr = arr[1];
				Long userId = Long.parseLong(userIdStr);
				Long time = Long.parseLong(timeStr);
				// �����������Ϣ
				UserRedPacket userRedPacket = new UserRedPacket();
				userRedPacket.setRedPacketId(redPacketId);
				userRedPacket.setUserId(userId);
				userRedPacket.setAmount(unitAmount);
				userRedPacket.setGrabTime(new Timestamp(time));
				userRedPacket.setNote("����� " + redPacketId);
				userRedPacketList.add(userRedPacket);
			}
			// �����������Ϣ
			count += executeBatch(userRedPacketList);
		}
		// ɾ��Redis�б�
		redisTemplate.delete(PREFIX + redPacketId);
		Long end = System.currentTimeMillis();
		System.err.println("�������ݽ�������ʱ" + (end - start) + "���룬��" + count + "����¼�����档");
	}

	private int executeBatch(List<UserRedPacket> userRedPacketList) {
		Connection conn = null;
		Statement stmt = null;
		int[] count = null;
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			for (UserRedPacket userRedPacket : userRedPacketList) {
				String sql1 = "update T_RED_PACKET set stock = stock-1 where id=" + userRedPacket.getRedPacketId();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String sql2 = "insert into T_USER_RED_PACKET(red_packet_id, user_id, " + "amount, grab_time, note)"
						+ " values (" + userRedPacket.getRedPacketId() + ", " + userRedPacket.getUserId() + ", "
						+ userRedPacket.getAmount() + "," + "'" + df.format(userRedPacket.getGrabTime()) + "'," + "'"
						+ userRedPacket.getNote() + "')";
				stmt.addBatch(sql1);
				stmt.addBatch(sql2);
			}
			// ִ������
			count = stmt.executeBatch();
			// �ύ����
			conn.commit();
		} catch (SQLException e) {
			throw new RuntimeException("���������ִ�г������");
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count.length / 2;
	}
}
	*/



