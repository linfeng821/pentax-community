package com.pentax.community;



import com.pentax.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class MailTest {

    @Autowired
    MailClient mailClient;


    @Autowired
    TemplateEngine templateEngine;

    @Test
    public void   testTextMail(){
        mailClient.sendMail("582984022@qq.com","test","hello");
    }

    @Test
    public void testHtmlMail(){
        Context context = new Context();
        context.setVariable("username","林枫");
        String content = templateEngine.process("/mail/demo", context);
        mailClient.sendMail("582984022@qq.com","html",content);
    }

}