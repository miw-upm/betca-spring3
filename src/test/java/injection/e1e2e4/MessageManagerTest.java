package injection.e1e2e4;

import static org.junit.Assert.assertEquals;
import injection.e1e2e4.MessageManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestsE1Config;

//S utilizan Mocks
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestsE1Config.class)
public class MessageManagerTest {

    @Autowired
    private MessageManager manager;

    @Autowired
    private MessageServiceMock service;

    @Test
    public void testAddMessage() {
        manager.addMessage("1", "uno");
        assertEquals("1", service.getKey());
        assertEquals("uno", service.getMessage());
    }

    @Test
    public void testFindMessage() {
        service.setKey("1");
        service.setMessage("mock");
        assertEquals("mock",manager.findMessage("1"));
    }
}
