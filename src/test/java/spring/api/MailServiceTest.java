package spring.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestMailConfiguration.class})
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSendMail() {
        mailService.sendMail("nyuron.art83@gmail.com", "jbernal@etsisi.upm.es", "Saludos", "Mail Service test");
    }
}
