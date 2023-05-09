package com.example.airport;

import com.example.airport.domain.*;
import com.example.airport.services.PdfService;
import com.example.airport.services.UserService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void calculateDiscount(){
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setId(1L);

        Assert.assertEquals((Double)0.0, userService.calculateDiscount(clientInfo));
    }
}
