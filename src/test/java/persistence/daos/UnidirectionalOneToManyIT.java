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
import persistence.entities.UnidirectionalOneToManyEntity;
import config.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class UnidirectionalOneToManyIT {

    @Autowired
    private UnidirectionalOneToManyDao unidirectionalOneToManyDao;
    

    @Test
    public void testFindOne() {
        AnyEntity[] array = {new AnyEntity("uno"), new AnyEntity("dos"), new AnyEntity("tres")};
        UnidirectionalOneToManyEntity entity = new UnidirectionalOneToManyEntity("Mi Nick",Arrays.asList(array));
        unidirectionalOneToManyDao.save(entity);
        assertEquals(3,unidirectionalOneToManyDao.findOne(entity.getId()).getAnyEntityList().size());
    }

    @After
    public void deleteAll() {
        unidirectionalOneToManyDao.deleteAll();
    }

}
