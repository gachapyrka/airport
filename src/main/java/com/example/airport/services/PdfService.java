package com.example.airport.services;

import com.example.airport.Application;
import com.example.airport.domain.BoughtTicket;
import com.ibm.icu.text.Transliterator;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.*;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

import java.io.IOException;
import java.util.Objects;
@Service
public class PdfService {

    final UserService userService;

    public PdfService(UserService userService) {
        this.userService = userService;
    }

    private String transliteration(String strInCyrillic) {

        String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        return toLatinTrans.transliterate(strInCyrillic);
    }

    public String createQR(String content, Long id){
        try {
            Document document = new Document(new Rectangle(135, 135));
            String filename = "src/main/java/com/example/airport/static/qr" + id + ".pdf";
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            BarcodeQRCode my_code = new BarcodeQRCode(content, 1, 1, null);
            Image qr_image = my_code.getImage();
            qr_image.setAlignment(Element.ALIGN_CENTER);
            document.add(qr_image);
            document.close();
            return filename;
        } catch (Exception e) {
        }
        return "";
    }

    public String createText(String content, Long id){
        try {
            Document document = new Document(new Rectangle(135, 135));
            String filename = "src/main/java/com/example/airport/static/text" + id + ".pdf";
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            document.addTitle(content);
            document.addSubject(content);
            document.close();
        } catch (Exception e) {
        }
        return "";
    }
    public String createContent(BoughtTicket ticket) {

        if (ticket == null) return "";
        BaseFont baseFont=null;
        try {
            baseFont = BaseFont.createFont(Objects.requireNonNull(Application.class.getResource(
                            "/fonts/ChampagneAndLimousinesBoldItalic-dqex.ttf")).toString(),
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.YYYY");

        String content = "Ticket #" + ticket.getId() + '\n' +
                "From: Minsk, Belarus" + '\n' +
                "To: " + ticket.getTicket().getRaise().getTo().getName() + '\n' +
                "Date:" + fmt.format(ticket.getTicket().getRaise().getDate()) + '\n' +
                "Plane number: " + ticket.getTicket().getRaise().getNumber() + '\n' +
                "Cost: " + (ticket.getTicket().getCount() * (100.0 - userService.calculateDiscount(ticket.getTicket().getClientInfo())) /100.0
                * ticket.getTicket().getRaise().getCost()) + '\n' +
                "Count: " + ticket.getTicket().getCount() + '\n' +
                "Passenger : " + ticket.getCredentials()  + '\n' +
                "Passport id : " + ticket.getPassportId();

        content = transliteration(content);

        return content;
    }
}
