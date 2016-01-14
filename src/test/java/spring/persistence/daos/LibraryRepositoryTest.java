package spring.persistence.daos;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.configuration.SpringTestPersistenceConfiguration;
import spring.configurationMain.PersistenceConfiguration;
import spring.persistence.daos.library.BookDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfiguration.class, SpringTestPersistenceConfiguration.class})
public class LibraryRepositoryTest {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookDao bookDao;

    @Test
    public void testPopulate() {
        libraryRepository.populate();
        assertTrue(3 == bookDao.count());
    }

    @After
    public void deleteAll() {
        libraryRepository.deleteAll();
    }

}