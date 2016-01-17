package spring.restApi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.configuration.TestsMailConfiguration;
import spring.restApi.MailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestsMailConfiguration.class})
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSendMail() {
        mailService.sendMail("nyuron.art83@gmail.com", "jbernal@etsisi.upm.es", "Saludos", "Mail Service test");
    }
}
