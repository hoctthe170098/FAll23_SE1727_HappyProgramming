/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.sendMail;

import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author toden
 */
public class EmailConfig {

    public static String SendEmail(String to, String messSubject, String messageTo) throws AddressException, MessagingException {
        final String username = "dungpmhe170403@fpt.edu.vn";
        final String password = "vtfc azyk kpmi mkfa";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dungpmhe170403@fpt.edu.vn"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject(messSubject);
            message.setText(messageTo);
//            message.setContent("<title>OrderLookup</title>");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return messageTo;
    }

    public static void main(String[] args) {
        EmailConfig e = new EmailConfig();
        try {
            System.out.println(SendEmail("tung020802@gmail.com", "Code reset:", e.randomCode()));
        } catch (MessagingException ex) {
            Logger.getLogger(EmailConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String randomCode() {
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000; // Generates a random number between 100000 and 999999
        return randomNumber + "";
    }
}
