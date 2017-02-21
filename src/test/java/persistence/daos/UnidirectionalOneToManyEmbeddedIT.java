package persistence.daos;

import static org.junit.Assert.assertEquals;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import persistence.entities.AnyClass;
import persistence.entities.UnidirectionalOneToManyEmbeddedEntity;
import config.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class UnidirectionalOneToManyEmbeddedIT {

    @Autowired
    private UnidirectionalOneToManyEmbeddedDao unidirectionalOneToManyEmbeddedDao;
    

    @Test
    public void testFindOne() {
        AnyClass[] array = {new AnyClass(0,"cero"), new AnyClass(1,"uno"), new AnyClass(2,"dos"), new AnyClass(3,"tres")};
        UnidirectionalOneToManyEmbeddedEntity entity = new UnidirectionalOneToManyEmbeddedEntity("Mi Nick",array);
        unidirectionalOneToManyEmbeddedDao.save(entity);
        assertEquals(4,unidirectionalOneToManyEmbeddedDao.findOne(entity.getId()).getAnyClassArray().length);
    }

    @After
    public void deleteAll() {
        unidirectionalOneToManyEmbeddedDao.deleteAll();
    }

}
