package Emailsending.com;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        System.out.println("sending");
        String message = "Hello, there";
        String subject = "CodersArea : confirmation";
        String to = "Receiver emailID";
        String from = "Sender emailID";

        sendEmail(message,subject,to,from);
    }

    private static void sendEmail(String message, String subject, String to, String from) {
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("EmailId", "EmailId password");
            }

        });

        session.setDebug(true);

        MimeMessage m = new MimeMessage(session);
        try {
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(subject);
            m.setText(message);
            Transport.send(m);

            System.out.println("Sent");
        }catch (Exception e){
            System.err.println(e);
        }


    }

}
