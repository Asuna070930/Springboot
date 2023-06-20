package com.atguigu.service.impl;

import com.atguigu.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/6 16:42
 */
@Service
public class SendMailServiceImpl implements SendMailService {
    /**
     * 发送右键需要准备
     * 发件人
     * 收件人
     * 主题
     * 内容
     */

    @Autowired
    private JavaMailSender javaMailSender;
    //发件人
    private String from = "956805174@qq.com";
    //收件人
    //1062760539@qq.com
    //136782527@qq.com
    //956805174@qq.com
    //lihao971015@gmail.com
    private String to = "lihao971015@gmail.com";
    //主题
    private String subject = "玩偶";
    //正文
    //    private String content = "hello";
    //发送图片
    //https://yezibk.net/wp-content/uploads/2022/11/2022111710353117.jpg
    //https://www.danmuxiu.cn/uploads/allimg/220325/1-220325200F9A3.jpg
    //https://ylts.org/wp-content/uploads/2023/04/6D60FB84-2B4B-4F98-B4CD-44C255F52F81-684x1024.jpeg
    //https://ylts.org/wp-content/uploads/2023/04/975C7162-25C8-419E-8F81-AB5ECCF71016-684x1024.jpeg
    //https://ylts.org/wp-content/uploads/2023/04/9DF66C1F-3424-4E2B-8CB2-91E2549554FF-603x1024.jpeg
    private String content = "<img src ='https://ylts.org/wp-content/uploads/2023/04/975C7162-25C8-419E-8F81-AB5ECCF71016-684x1024.jpeg'><br/><a href = 'http://www.missav.com'>更多妹子</a>";

//    发送带附件的邮件
    @Override
    public void sendMaill() throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //设置协议
        //multipart: 多媒体解析器
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //发件人
        helper.setFrom(from + "(HongKongDoll)");
        //收件人
        helper.setTo(to);
        //主题
        helper.setSubject(subject);
        //内容
        //第一个参数表示文本内容
        //第二个参数表示 是否用网页的方式展示
        helper.setText(content, true);
        //携带附件
        File file = new File("D:\\Java\\Springboot\\1-220325200F9A3.png");
        helper.addAttachment("HongKongDoll",file);
        //发送邮件
        javaMailSender.send(mimeMessage);
    }


    //发送富文本邮件
//    @Override
//    public void sendMaill() throws Exception {
//        //发送一个简单的右键,创建一个简单右键对象
////        SimpleMailMessage message = new SimpleMailMessage();
//        //设置content-type : application/json,设置请求头,多媒体协议, text/html application/json 支持富文本协议
//        //MIME: 表示多媒体类型
//        //获取mime的对象
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        //设置协议
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
//        //发件人
//        helper.setFrom(from + "(HongKongDoll)");
//        //收件人
//        helper.setTo(to);
//        //主题
//        helper.setSubject(subject);
//        //内容
//        //第一个参数表示文本内容
//        //第二个参数表示 是否用网页的方式展示
//        helper.setText(content, true);
//        //发送邮件
//        javaMailSender.send(mimeMessage);
//    }


    //发送简单邮件
//    @Override
//    public void sendMaill() throws Exception{
//        //发送一个简单的右键,创建一个简单右键对象
//        SimpleMailMessage message = new SimpleMailMessage();
//        //设置content-type : application/json,设置请求头,多媒体协议, text/html application/json 支持富文本协议
//        //MIME: 表示多媒体类型
////        //获取mime的对象
////        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
////        //设置协议
////        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
//        //发件人
//        message.setFrom(from + "(HongKongDoll)");
//        //收件人
//        message.setTo(to);
//        //主题
//        message.setSubject(subject);
//        //内容
//        //第一个参数表示文本内容
//        //第二个参数表示 是否用网页的方式展示
//        message.setText(content);
//        //发送邮件
//        javaMailSender.send(message);
//    }
}
