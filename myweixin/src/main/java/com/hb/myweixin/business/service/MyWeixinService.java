package com.hb.myweixin.business.service;

import com.hb.myweixin.business.entity.BaseMessage;
import com.hb.myweixin.business.util.MessageDigestUtil;
import com.hb.myweixin.business.util.XMLUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.servlet.ServletInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MyWeixinService {

    @Value("${weixin.token}")
    private String token;

    @Autowired
    private  MessageService messageService;

    /**
     * 微信认证
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     * @throws Exception
     */
    public Boolean checkSignature(String signature, String timestamp, String nonce) throws Exception{
        String[] strs = new String[] {token,timestamp,nonce};
        Arrays.sort(strs);
        //将三个参数字符串拼接成一个字符串进行sha1加密
        String str = strs[0]+strs[1]+strs[2];
        String mysig = MessageDigestUtil.sha1(str);
        //开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        return mysig.equalsIgnoreCase(signature);
    }

    /**
     * 解析xml数据包
     * @param is
     * @return
     */
    public Map<String,String> parseRequest(ServletInputStream is) {
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        try {
            //读取输入流，获取文档对象
            Document document = reader.read(is);
            //根据文档对象获取根节点
            Element root = document.getRootElement();
            //获取根节点的所有的子节点
            List<Element> elements = root.elements();
            for(Element e:elements) {
                map.put(e.getName(), e.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 回复的数据包
     * @param requestMap
     * @return
     */
    public String getRespose(Map<String,String> requestMap) {
        BaseMessage msg=null;
        String msgType = requestMap.get("MsgType");
        msg=messageService.dealTextMessage(requestMap);
        //把消息对象处理为xml数据包
        if(msg!=null) {
            return XMLUtil.beanToXml(msg);
        }
        return null;
    }
}
