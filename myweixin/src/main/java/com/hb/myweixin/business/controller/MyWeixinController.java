package com.hb.myweixin.business.controller;


import com.hb.myweixin.business.service.MyWeixinService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class MyWeixinController {

    @Autowired
    private MyWeixinService myWeixinService;

    /**
     * 微信认证
     * @param request
     * @return
     */
    @ApiOperation(value = "微信认证接口",notes = "微信认证接口")
    @RequestMapping(value = "/wx",method = RequestMethod.GET)
    public ResponseEntity  testInterface(HttpServletRequest request) throws Exception{
        //获取参数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        //验证
        Boolean result = myWeixinService.checkSignature(signature,timestamp,nonce);
        if(result){
            return new ResponseEntity(echostr,HttpStatus.OK);
        }else{
            return new ResponseEntity("验证失败",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * 微信认证
     * @param request
     * @return
     */
    @ApiOperation(value = "接收消息和事件推送",notes = "接收消息和事件推送")
    @RequestMapping(value = "/wx",method = RequestMethod.POST)
    public ResponseEntity  getMessage(HttpServletRequest request) throws Exception{
        //处理消息和事件推送
        Map<String, String> requestMap = myWeixinService.parseRequest(request.getInputStream());
        //准备回复的数据包
        String respXml = myWeixinService.getRespose(requestMap);
        return new ResponseEntity(respXml,HttpStatus.OK);
    }
}
