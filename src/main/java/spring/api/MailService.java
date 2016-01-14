package spring.api;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    // Login to Gmail
    // Access the URL as https://www.google.com/settings/security/lesssecureapps
    // Select "Turn on"
    @Autowired
    private MailSender mailSender;

    public void sendMail(String from, String to, String subject, String msg) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(msg);
        try {
            mailSender.send(simpleMailMessage);
            LogManager.getLogger(this.getClass()).info("  MAIL to: " + to + ", msg:" + msg);
        } catch (Exception e) {
            LogManager.getLogger(this.getClass()).error("MailSender: " + e.getMessage());
        }
    }
}
