package com.jmy.easweb;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

//发送邮件
public class EmailTest {

    public static void main(String[] args) throws EmailException {
        //创建一个HtmlEmail实例对象
        HtmlEmail email=new HtmlEmail();
        //邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com
        email.setHostName("smtp.qq.com");
        //设置发送的字符类型
        email.setCharset("utf-8");
        //设置收件人
        email.addTo("840823499@qq.com");
        email.setSSLOnConnect(true);
        email.setSmtpPort(465);
        //发送人的邮箱为自己的，用户名可以随便填
        email.setFrom("691467408@qq.com","aa");
         //设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
        email.setAuthentication("691467408@qq.com","nhdxohpfjwqsbbeg");
        String s = "Hey KrisJiang1!\n" +
                "\n" +
                "A third-party OAuth application (Microsoft-Corporation) with read:user and user:email scopes was recently authorized to access your account.\n" +
                "Visit https://github.com/settings/connections/applications/e37ffdec11c0245cb2e0 for more information.\n" +
                "\n" +
                "To see this and other security events for your account, visit https://github.com/settings/security-log\n" +
                "\n" +
                "If you run into problems, please contact support by visiting https://github.com/contact\n" +
                "\n" +
                "Thanks,\n" +
                "The GitHub Team";
        email.setSubject("测试");//设置发送主题
        email.setMsg(s);//设置发送内容
        email.send();

    }
}
