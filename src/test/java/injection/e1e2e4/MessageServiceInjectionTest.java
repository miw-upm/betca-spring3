package injection.e1e2e4;

import static org.junit.Assert.assertEquals;
import injection.e1e2e4.MessageService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.E1Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = E1Config.class)
public class MessageServiceInjectionTest {

    @Autowired
    private MessageService messageService;
    
    @Test
    public void testAddMessage() {
        messageService.add("1", "uno");
        assertEquals("uno", messageService.message("1"));
    }

    @Test
    public void testKey() {
        messageService.add("2", "dos");
        messageService.add("3", "tres");
        messageService.add("4", "cuatro");
        assertEquals("2", messageService.key("dos"));
        assertEquals("4", messageService.key("cuatro"));
    }

}
