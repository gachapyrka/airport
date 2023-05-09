package com.example.airport;

import com.example.airport.domain.ClientInfo;
import com.example.airport.services.MailService;
import com.example.airport.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    MailService mailService;

    @Test
    public void sendEmail(){
        Assert.assertEquals(true, mailService.send("test", "test", "felixfelicis19954@gmail.com", null));
    }
}
