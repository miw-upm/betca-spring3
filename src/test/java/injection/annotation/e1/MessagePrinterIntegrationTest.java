package injection.annotation.e1;

import static org.junit.Assert.assertEquals;
import injection.annotation.e1.MessageManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.start.AnnotationE1Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AnnotationE1Config.class)
public class MessagePrinterIntegrationTest {

    @Autowired
    private MessageManager manager;

    @Test
    public void testAddFindMessage() {
        manager.addMessage("1", "uno");
        manager.addMessage("2", "dos");
        manager.addMessage("3", "tres");
        assertEquals("uno(2016)", manager.findMessage("1"));
        assertEquals("tres(2016)", manager.findMessage("3"));
    }

}
