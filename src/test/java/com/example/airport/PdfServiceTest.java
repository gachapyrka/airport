package com.example.airport;

import com.example.airport.domain.*;
import com.example.airport.services.PdfService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.regex.Matcher;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PdfServiceTest {

    @Autowired
    PdfService pdfService;

    @Test
    public void createContentAny()
    {
        BoughtTicket ticket = new BoughtTicket();
        ticket.setCredentials("fio");
        ticket.setPassportId("pasport");
        ticket.setBuyDate(new Date());
        ticket.setTicket(new Ticket(new ClientInfo("login", "password", Role.USER, true, null, null),
                new Raise(new Place("Minsk", "null", null), new Date(), "number", 30.0, 22, null),
                null, 1));

        Assert.assertNotEquals(0, pdfService.createContent(ticket).length());
    }

    @Test
    public void createContentValue()
    {
        BoughtTicket ticket = new BoughtTicket();
        ticket.setCredentials("fio");
        ticket.setPassportId("pasport");
        ticket.setBuyDate(new Date());
        ticket.setTicket(new Ticket(new ClientInfo("login", "password", Role.USER, true, null, null),
                new Raise(new Place("Minsk", "null", null), new Date(), "number", 30.0, 22, null),
                null, 1));

        Assert.assertThat(pdfService.createContent(ticket), Matchers.containsString("Minsk"));
        Assert.assertThat(pdfService.createContent(ticket), Matchers.containsString("pasport"));
        Assert.assertThat(pdfService.createContent(ticket), Matchers.containsString("fio"));
        Assert.assertThat(pdfService.createContent(ticket), Matchers.containsString("number"));
        Assert.assertThat(pdfService.createContent(ticket), Matchers.containsString("1"));
        Assert.assertThat(pdfService.createContent(ticket), Matchers.containsString("30"));
    }
    @Test
    public void createQR()
    {
        Assert.assertThat(pdfService.createQR("123", 1L), Matchers.containsString("src/main/java/com/example/airport/static/qr1.pdf"));
    }
}
