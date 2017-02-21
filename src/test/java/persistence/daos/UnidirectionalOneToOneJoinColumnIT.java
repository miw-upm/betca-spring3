package persistence.daos;

import static org.junit.Assert.assertNotNull;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import persistence.entities.AnyEntity;
import persistence.entities.UnidirectionalOneToOneJoinColumnEntity;
import config.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class UnidirectionalOneToOneJoinColumnIT {

    @Autowired
    private UnidirectionalOneToOneJoinColumnDao unidirectionalOneToOneJoinColumnDao;
    

    @Test
    public void testFindOne() {
        AnyEntity anyEntity = new AnyEntity("daemon");
        UnidirectionalOneToOneJoinColumnEntity entity = new UnidirectionalOneToOneJoinColumnEntity("Mi Nick", anyEntity);
        unidirectionalOneToOneJoinColumnDao.save(entity);
        assertNotNull(unidirectionalOneToOneJoinColumnDao.findOne(entity.getId()).getAnyEntity());
    }

    @After
    public void deleteAll() {
        unidirectionalOneToOneJoinColumnDao.deleteAll();
    }

}
