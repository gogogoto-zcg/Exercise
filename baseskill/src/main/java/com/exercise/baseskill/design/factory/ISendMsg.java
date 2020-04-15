package com.exercise.baseskill.design.factory;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 17:45
 * @Description : 简单工厂模式
 */
public interface ISendMsg {
    boolean sendMsg(String msg);
}

class SmsSendMsg implements ISendMsg{
    @Override
    public boolean sendMsg(String msg) {
        System.out.println("发送短信。。。");
        return true;
    }
}
class WeixinSendMsg implements  ISendMsg{

    @Override
    public boolean sendMsg(String msg) {
        System.out.println("微信发送。。。");
        return true;
    }
}

class SendMsgFactory{

    public static ISendMsg sendMsg(String type){
        if(type.equals("sms")){
            return new SmsSendMsg();
        } else if(type.equals("weixin")){
            return new WeixinSendMsg();
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        ISendMsg weixin = SendMsgFactory.sendMsg("weixin");
        ISendMsg sms = SendMsgFactory.sendMsg("sms");
        sms.sendMsg("hello");
        weixin.sendMsg("hello");
    }

}
