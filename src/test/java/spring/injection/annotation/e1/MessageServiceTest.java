package spring.injection.annotation.e1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.configurationMain.AnnotationE1Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AnnotationE1Config.class)
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void testMessage() {
        System.out.println(messageService.message());
        System.out.println(messageService.message());
    }

}
