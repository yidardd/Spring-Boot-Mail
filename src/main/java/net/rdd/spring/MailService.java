package net.rdd.spring;

import javax.mail.MessagingException;

/**
 * Created by 东东 on 2018/10/28.
 *
 * @Description 发送邮件部分接口
 */
public interface MailService {

    /**
     * @Description //TODO 发送简单的文本文件，to:收件人 subject:主题 content:内容
     * @Param [to, subject, content]
     **/
    public void sendSimpleMail(String to, String subject, String content);

    /**
     * @Description //TODO 发送html，to:收件人 subject:主题 content:内容
     * @Param [to, subject, content]
     **/
    public void sendHtmlMail(String to, String subject, String content);

    /**
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @throws MessagingException
     * @Description //TODO 发送一个带附件的邮件，to:收件人，subject:主题，content:主题，filePath:附件的路径
     */
    public void sendAttachmentMail(String to, String subject, String content, String filePath);


    public void sendInlineResourceMail(String to, String subject, String content, String rscPath);
}
