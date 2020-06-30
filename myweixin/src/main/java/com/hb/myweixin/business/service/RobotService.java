package com.hb.myweixin.business.service;

import com.alibaba.fastjson.JSONObject;
import com.hb.myweixin.business.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RobotService {

    @Value("${robot.url}")
    private String  url;

    @Value("${robot.appKey}")
    private String  appKey;


    public String chat(String content) {
        String urlstr = url+"?info="+content+"&key="+appKey;
        String  result = HttpClientUtil.doGet(urlstr);
        JSONObject fastjson = JSONObject.parseObject(result);
        Integer error_code = fastjson.getInteger("error_code");
        if(new Integer(0).compareTo(error_code)==0){
            String resultStr =  fastjson.getString("result");
            JSONObject resultson = JSONObject.parseObject(resultStr);
            return  resultson.getString("text");
        }
        return  null;
    }
}
