package com.myproject.service;

import com.myproject.util.ReservationForm;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SendConfirmationMail {

    private MailSender mailSender;
    private SimpleMailMessage templateMessage;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    public void sendConfirmationMail(ReservationForm reservationForm) {
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(reservationForm.getEmail());
        msg.setText("Yay" );
        try{
            this.mailSender.send(msg);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
