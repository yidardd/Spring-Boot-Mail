package net.rdd.testMail;

import net.rdd.spring.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


/**
 * Created by 东东 on 2018/10/28.
 */

public class MailSendTest extends MainTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine engine;

    @Test
    public void test01() {
        String to ="13707259624@163.com";
        String content = "大家好,这是一个简单的文本发送";
        //主题
        String subject = "来了,小老弟";

        mailService.sendSimpleMail(to,subject,content);

    }

    @Test
    public void test02() {
        String to ="13707259624@163.com";
        String content = "<html> <h1 style=\"color:red \" >大家好,这是一个简单的html发送</h1></html>";
        //主题
        String subject = "来了,小老弟";

        mailService.sendHtmlMail(to,subject,content);

    }

    @Test
    //发送html文件
    public void test03() {
        String to ="13707259624@163.com";
        //org.thymeleaf.context.Context;thymeleaf模板的context
        Context context = new Context();
        context.setVariable("id",1);
        String content = engine.process("MailTest", context);
        //主题
        String subject = "来了,小老弟";

        mailService.sendHtmlMail(to,subject,content);

    }

    @Test
    public void test04() {
        String to ="13707259624@163.com";
        String content = "大家好,这是一个简单的带附件发送";
        //主题
        String subject = "来了,小老弟";

        String filePath = "C:\\Users\\东东\\Downloads\\aaa.docx";
        mailService.sendAttachmentMail(to,subject,content,filePath);

    }

    @Test
    //发送图片
    public void test05() {
        String to ="13707259624@163.com";
        //src对应img
        String content = "<html><body>大家好,这是一个简单的图片发送：<img src=\'cid:img" + "\'></img></body></html>";
        //主题
        String subject = "来了,小老弟";
        //图片地址
        String filePath = "C:\\Users\\东东\\Pictures\\307826854021937449.jpg";
        mailService.sendInlineResourceMail(to,subject,content,filePath);

    }



}
