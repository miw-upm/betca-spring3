package spring.injection.annotation.e1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.configuration.TestsConfigE1;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestsConfigE1.class)
public class MessagePrinterTest {

    @Autowired
    private MessagePrinter messagePrinter;

    @Test
    public void testMessage() {
        messagePrinter.print();
    }

}
