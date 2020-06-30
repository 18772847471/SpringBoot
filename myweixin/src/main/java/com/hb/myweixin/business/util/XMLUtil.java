package com.hb.myweixin.business.util;

import com.hb.myweixin.business.entity.BaseMessage;
import com.hb.myweixin.business.entity.TextMessage;
import com.thoughtworks.xstream.XStream;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLUtil {
    /**
     * 把对应实体类转换成xml
     * @param msg
     * @return
     */
    public static String beanToXml(BaseMessage msg) {
        XStream stream = new XStream();
        //将包名换掉
        stream.processAnnotations(TextMessage.class);
        String xml = stream.toXML(msg);
        //去掉空格
        Pattern p = Pattern.compile("\\s{2,}|\t|\r|\n");
        Matcher m = p.matcher(xml);
        return  m.replaceAll("");
    }
}
