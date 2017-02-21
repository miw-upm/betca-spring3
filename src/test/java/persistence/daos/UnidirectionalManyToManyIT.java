package persistence.daos;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import persistence.entities.AnyEntity;
import persistence.entities.UnidirectionalManyToManyEntity;
import config.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class UnidirectionalManyToManyIT {

    @Autowired
    private UnidirectionalManyToManyDao unidirectionalManyToManyDao;
    
    @Autowired
    private AnyDao anyDao;
    

    @Test
    public void testFindOne() {
        AnyEntity[] array = {new AnyEntity("uno"), new AnyEntity("dos"), new AnyEntity("tres")};
        AnyEntity[] array2 = {new AnyEntity("cuatro"), new AnyEntity("cinco")};
        anyDao.save(Arrays.asList(array));
        anyDao.save(Arrays.asList(array2));
        UnidirectionalManyToManyEntity entity = new UnidirectionalManyToManyEntity("Mi Nick", Arrays.asList(array));
        unidirectionalManyToManyDao.save(entity);
        assertEquals(3,unidirectionalManyToManyDao.findOne(entity.getId()).getAnyEntityList().size());
    }

    @After
    public void deleteAll() {
        unidirectionalManyToManyDao.deleteAll();
        anyDao.deleteAll();
    }

}
