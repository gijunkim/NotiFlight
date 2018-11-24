/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notiflight.Classes;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author GJKOfficial
 */
public class EmailNotification {
    
    public static void Email() {

    final String username = "noreply.notiflight@gmail.com";
    final String password = "notiflight123";

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("noreply.notiflight@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(userProfile.email));
        message.setSubject("There has been a change to your flight schedule!");
        message.setText("Check your flight account immediately!");

        Transport.send(message);


    } catch (MessagingException e) {
        e.printStackTrace();
    }
    
}
}
