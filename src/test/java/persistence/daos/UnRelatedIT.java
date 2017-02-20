package persistence.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import persistence.entities.Gender;
import persistence.entities.UnRelatedEntity;
import config.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class UnRelatedIT {

    @Autowired
    private UnRelatedDao unRelatedDao;

    @Before
    public void populate() {
        String[] list = {"0", "1"};
        for (int i = 0; i < 4; i++) {
            unRelatedDao.save(new UnRelatedEntity("nick" + i, Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                    Arrays.asList(list), "no persistence"));
        }
    }

    @Test
    public void testCount() {
        assertEquals(4, unRelatedDao.count());
    }

    @Test
    public void testFindOne() {
        UnRelatedEntity unRelatedEntity = new UnRelatedEntity("unNick", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...",
                new String[] {}, Arrays.asList(new String[] {}), "no persistence");
        unRelatedDao.save(unRelatedEntity);
        assertEquals("unNick", unRelatedDao.findOne(unRelatedEntity.getId()).getNick());
    }

    @Test
    public void testFindFirst3ByNickStartingWith() {
        assertEquals(0, unRelatedDao.findFirst3ByNickStartingWith("no").size());
        assertEquals(3, unRelatedDao.findFirst3ByNickStartingWith("ni").size());
    }

    @Test
    public void testFindByNick() {
        assertEquals("nick1", unRelatedDao.findByNick("nick1").getNick());
    }

    @Test
    public void testDeleteByNick() {
        assertNotNull(unRelatedDao.findByNick("nick0"));
        unRelatedDao.deleteByNick("nick0");
        assertNull(unRelatedDao.findByNick("nick0"));
    }

    @Test
    public void testDeleteByIdGreaterThan() {
        assertEquals(4, unRelatedDao.deleteByIdGreaterThan(0));
        assertEquals(0, unRelatedDao.deleteByIdGreaterThan(Integer.MAX_VALUE));
    }

    @Test
    public void testDeleteByNickQuery() {
        UnRelatedEntity unRelatedEntity = new UnRelatedEntity("unNick", Gender.MALE, new GregorianCalendar(1901, 11, 31), "...",
                new String[] {}, Arrays.asList(new String[] {}), "no persistence");
        unRelatedDao.save(unRelatedEntity);
        assertNotNull(unRelatedDao.findByNick("unNick"));
        unRelatedDao.deleteByNickQuery("unNick");
        assertNull(unRelatedDao.findByNick("unNick"));
    }

    @After
    public void deleteAll() {
        unRelatedDao.deleteAll();
    }

}
