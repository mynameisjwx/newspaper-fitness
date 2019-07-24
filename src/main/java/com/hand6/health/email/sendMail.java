package com.hand6.health.email;/**
 * Created by Administrator on 2019/7/12.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author xxxx
 * @description
 * @date 2019/7/12
 */
public class sendMail {
    @Autowired
    static
    JavaMailSender jms;

    public static void send() {
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("956740304@qq.com");
        //接收者
        mainMessage.setTo("wenxuan.jiang@hand-china.com");
        //发送的标题
        mainMessage.setSubject("运动记录");
        //发送的内容
        mainMessage.setText("全都完成");
        jms.send(mainMessage);

    }

    public static void main(String[] args) {
        send();
    }
}
