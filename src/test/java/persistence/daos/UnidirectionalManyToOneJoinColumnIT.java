package persistence.daos;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import persistence.entities.AnyEntity;
import persistence.entities.UnidirectionalManyToOneJoinColumnEntity;
import config.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class UnidirectionalManyToOneJoinColumnIT {

    @Autowired
    private UnidirectionalManyToOneJoinColumnDao unidirectionalManyToOneJoinColumnDao;
    
    @Autowired
    private AnyDao anyDao;  

    @Test
    public void testFindOne() {
        AnyEntity anyEntity = new AnyEntity("daemon");
        anyDao.save(anyEntity);
        
        UnidirectionalManyToOneJoinColumnEntity entity = new UnidirectionalManyToOneJoinColumnEntity("Mi Nick", anyEntity);
        unidirectionalManyToOneJoinColumnDao.save(entity);
        
        UnidirectionalManyToOneJoinColumnEntity entity2 = new UnidirectionalManyToOneJoinColumnEntity("Mi Nick 2", anyEntity);
        unidirectionalManyToOneJoinColumnDao.save(entity2);
        
        assertEquals(anyEntity,unidirectionalManyToOneJoinColumnDao.findOne(entity.getId()).getAnyEntity());
        assertEquals(anyEntity,unidirectionalManyToOneJoinColumnDao.findOne(entity2.getId()).getAnyEntity());
    }

    @After
    public void deleteAll() {
        unidirectionalManyToOneJoinColumnDao.deleteAll();
        anyDao.deleteAll();
    }

}
