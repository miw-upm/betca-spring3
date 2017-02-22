package persistence.daos.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import persistence.daos.library.BookDao;
import config.PersistenceConfig;
import config.TestsPersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class LibraryIT {

    @Autowired
    private DaosLibraryServiceIntegrationTest daosLibraryServiceIntegrationTest;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private StyleDao styleDao;

    @Before
    public void populate() {
        daosLibraryServiceIntegrationTest.populate();
    }

    @Test
    public void testPopulate() {
        assertTrue(3 == bookDao.count());
    }

    @Test
    public void testFindByStyle() {
        assertEquals(2, authorDao.findByStyle(styleDao.findByNameIgnoreCase("Infantil")).size());
    }

    @Test
    public void testFindNameByStyleName() {
        assertEquals(2, authorDao.findNameByStyleName("Infantil").size());
        assertArrayEquals(new String[] {"Jesús", "Cris"}, authorDao.findNameByStyleName("Infantil").toArray());
    }
    
    @Test
    public void testFindDistinctNameByAnyBook(){
        assertEquals(3, authorDao.findDistinctNameByAnyBook().size());
        assertArrayEquals(new String[] {"Jesús", "Cris","Ana"}, authorDao.findDistinctNameByAnyBook().toArray());
    }
    
    @Test
    public void testFindNameByThemeName(){
        assertEquals(2, authorDao.findNameByThemeName("Suspense").size());
        assertArrayEquals(new String[] {"Cris","Ana"}, authorDao.findNameByThemeName("Suspense").toArray());
    }

    @After
    public void deleteAll() {
        daosLibraryServiceIntegrationTest.deleteAll();
    }

}
