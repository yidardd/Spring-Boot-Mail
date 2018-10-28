package net.rdd.spring.impl;

import net.rdd.spring.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by 东东 on 2018/10/28.
 */
@Service
public class MailServiceImpl implements MailService {

    //这个是发送人的用户名，如siertou@qq.com
    @Value("${spring.mail.username}")
    private String from;

    //用来发送邮件
    @Autowired
    private JavaMailSender mailSender;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailSender.send(mailMessage);
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);

            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            //将content里面的标签进行处理,否则为正常的文本处理
            messageHelper.setText(content, true);
        } catch (MessagingException e) {
            logger.error("something wrong...");
            e.printStackTrace();
        }
        mailSender.send(message);

    }

    @Override
    public void sendAttachmentMail(String to, String subject, String content, String filePath) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            //带上附件传true,否则会报错.
            //Not in multipart mode - create an appropriate MimeMessageHelper via a constructor that takes a 'multipart' flag if you need to set alternative texts or add inline elements or attachments.
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom(from);

            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content);

            //设置附件
            FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
            String filename = fileSystemResource.getFilename();
            messageHelper.addAttachment(filename, fileSystemResource);
        } catch (MessagingException e) {
            logger.error("something wrong...");
            e.printStackTrace();
        }
        mailSender.send(mimeMessage);
    }

    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            //带上附件传true,否则会报错.
            //Not in multipart mode - create an appropriate MimeMessageHelper via a constructor that takes a 'multipart' flag if you need to set alternative texts or add inline elements or attachments.
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content,true);
            //构造邮件内部的图片
            FileSystemResource file = new FileSystemResource(new File(rscPath));
            //对应的图片src路径，我就简单写一下。。。
            messageHelper.addInline("img", file);
        } catch (MessagingException e) {
            logger.error("something wrong...");
            e.printStackTrace();
        }
        mailSender.send(mimeMessage);

    }

}
