package com.wzportal.app.service.impl;

import com.wzportal.app.service.MailService;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.StringWriter;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail(Map<String, Object> data) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("jiang@jiang.com");
        mimeMessageHelper.setTo("jiang@jiang.com");
        mimeMessageHelper.setSubject("富文本邮件主题");
        mimeMessageHelper.setText(merge(data), true);
        // 附件 设置内嵌元素 cid，第一个参数表示内联图片的标识符，第二个参数标识资源引用
        // mimeMessageHelper.addInline("boot", new ClassPathResource("public/images/boot.png"));
        javaMailSender.send(mimeMessage);
    }

    private String merge(Map<String, Object> data) {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        // 载入（获取）模板对象
        Template t = ve.getTemplate("mail/Reminder.vm");
        VelocityContext ctx = new VelocityContext();
        // 域对象加入参数值
        ctx.put("data", data);
        StringWriter sw = new StringWriter();
        t.merge(ctx, sw);
        return sw.toString();
    }
}
