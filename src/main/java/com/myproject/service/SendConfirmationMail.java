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
        msg.setText("Hello, " + reservationForm.getFirstName() + " " + reservationForm.getLastName() + "!\n"
                + "Your reservation has successfully been submitted. Reservation details:\n"
                + "Start date: " + reservationForm.getStartDate() + "\n"
                + "End date: " + reservationForm.getEndDate() + "\n"
                + "Room capacity: " + reservationForm.getCapacity() + "\n"
                + "First name: " + reservationForm.getFirstName() + "\n"
                + "Last name: " + reservationForm.getLastName() + "\n"
                + "Phone number: " + reservationForm.getPhoneNumber() + "\n"
                + "Email: " + reservationForm.getEmail() + "\n"
                + "\n"
                + "Please do not hesitate to contact us if you have any further questions at: \n"
                + "hotelbook.customerservice@gmail.com");
        try{
            this.mailSender.send(msg);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
