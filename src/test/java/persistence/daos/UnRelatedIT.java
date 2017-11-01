package persistence.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
            unRelatedDao.save(new UnRelatedEntity("nick" + i, Gender.MALE, new GregorianCalendar(1964, 11, 31), "Large...", list,
                    Arrays.asList(list), "no persistence"));
        }
    }
    
    //CRUD
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
    public void testFindByNickIgnoreCase() {
        assertNotNull(unRelatedDao.findByNickIgnoreCase("NICK1"));
    }

    @Test
    public void testFindFirst3ByNickStartingWith() {
        assertEquals(0, unRelatedDao.findFirst3ByNickStartingWith("no").size());
        assertEquals(3, unRelatedDao.findFirst3ByNickStartingWith("ni").size());
    }

    @Test
    public void testFindByNickOrLargeOrderByIdDesc() {
        assertTrue(unRelatedDao.findByNickOrLargeOrderByIdDesc("NoNick", "Large...").get(0).getId() > unRelatedDao
                .findByNickOrLargeOrderByIdDesc("NoNick", "Large...").get(1).getId());
        assertEquals(4, unRelatedDao.findByNickOrLargeOrderByIdDesc("NoNick", "Large...").size());
    }

    @Test
    public void testFindByIdGreaterThan() {
        assertEquals(2, unRelatedDao.findByIdGreaterThan(0, new PageRequest(0, 2)).size());
        assertEquals(1, unRelatedDao.findByIdGreaterThan(0, new PageRequest(1, 3)).size());
    }

    @Test
    public void testFindByNickIn() {
        assertEquals(2, unRelatedDao.findByNickIn(Arrays.asList(new String[] {"nick1", "nick2"})).size());
    }

    //JPQL
    @Test
    public void testFindNickByNickLike() {
        assertEquals(0, unRelatedDao.findNickByNickLike("i%").size());
        assertEquals(4, unRelatedDao.findNickByNickLike("n%").size());
    }

    @Test
    public void testFindIdByIdBetween() {
        int id = unRelatedDao.findByNickIgnoreCase("nick1").getId();
        assertEquals(2, unRelatedDao.findIdByIdBetween(id - 1, id + 2).size());
    }

    //SQL
    @Test
    public void testFindByNick() {
        assertEquals("nick1", unRelatedDao.findByNick("nick1").getNick());
    }

    //BORRADO
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
    
    @Test
    public void testCustom(){
        unRelatedDao.custom(new UnRelatedEntity("custom"));
        assertNotNull(unRelatedDao.findByNickIgnoreCase("custom"));
    }

    @After
    public void deleteAll() {
        unRelatedDao.deleteAll();
    }

}
