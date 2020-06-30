package com.hb.myweixin.business.service;

import com.hb.myweixin.business.entity.BaseMessage;
import com.hb.myweixin.business.entity.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageService {

    @Autowired
    private  RobotService  robotService;

    /**
     * 处理文本消息
     * @param requestMap
     * @return
     */
    public TextMessage dealTextMessage(Map<String,String> requestMap) {
        String content = requestMap.get("Content");
        String responstr = robotService.chat(content);
        TextMessage textMessage = new TextMessage(requestMap, responstr);
        return textMessage;
    }
}
