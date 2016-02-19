package injection.e1e2e4;

import static org.junit.Assert.assertEquals;
import injection.e1e2e4.MessageManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.start.E1Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = E1Config.class)
public class MessageManagerIntegrationTest {

    @Autowired
    private MessageManager manager;

    @Test
    public void testAddFindMessage() {
        manager.addMessage("1", "uno");
        manager.addMessage("2", "dos");
        manager.addMessage("3", "tres");
        assertEquals("uno", manager.findMessage("1"));
        assertEquals("tres", manager.findMessage("3"));
    }

}
