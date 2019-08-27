package com.ssm.chapter22.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.chapter22.service.UserRedPacketService;

@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {

    @Autowired
    private UserRedPacketService userRedPacketService = null;

    @RequestMapping(value = "/grapRedPacket")
    @ResponseBody
    public Map<String, Object> grapRedPacket(Long redPacketId, Long userId) {
        // �����
        int result = userRedPacketService.grapRedPacket(redPacketId, userId);
        Map<String, Object> retMap = new HashMap<String, Object>();
        boolean flag = result > 0;
        retMap.put("success", flag);
        retMap.put("message", flag ? "������ɹ�" : "�����ʧ��");
        return retMap;
    }


    //�ֹ�������ʹ��ʱ�޸�javascript������·��
    @RequestMapping(value = "/grapRedPacketForVersion")
    @ResponseBody
    public Map<String, Object> grapRedPacketForVersion(Long redPacketId, Long userId) {
        // �����
        int result = userRedPacketService.grapRedPacketForVersion(redPacketId, userId);
        Map<String, Object> retMap = new HashMap<String, Object>();
        boolean flag = result > 0;
        retMap.put("success", flag);
        retMap.put("message", flag ? "������ɹ�" : "�����ʧ��");
        return retMap;
    }

    @RequestMapping(value = "/grapRedPacketByRedis")
    @ResponseBody
    public Map<String, Object> grapRedPacketByRedis(Long redPacketId, Long userId) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Long result = userRedPacketService.grapRedPacketByRedis(redPacketId, userId);
        boolean flag = result > 0;
        resultMap.put("result", flag);
        resultMap.put("message", flag ? "������ɹ�": "�����ʧ��");
        return resultMap;
    }
}
