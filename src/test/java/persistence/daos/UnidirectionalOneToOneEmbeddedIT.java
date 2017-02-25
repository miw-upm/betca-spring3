package persistence.daos;

import static org.junit.Assert.assertNotNull;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import persistence.entities.EmbeddableEntity;
import persistence.entities.UnidirectionalOneToOneEmbeddedEntity;
import config.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class UnidirectionalOneToOneEmbeddedIT {

    @Autowired
    private UnidirectionalOneToOneEmbeddedDao unidirectionalOneToOneEmbeddedDao;
    

    @Test
    public void testFindOne() {
        EmbeddableEntity embeddable = new EmbeddableEntity(666, "daemon");
        UnidirectionalOneToOneEmbeddedEntity entity = new UnidirectionalOneToOneEmbeddedEntity("Nick", embeddable);
        unidirectionalOneToOneEmbeddedDao.save(entity);
        assertNotNull(unidirectionalOneToOneEmbeddedDao.findOne(entity.getId()).getEmbeddableEntity());
    }

    @After
    public void deleteAll() {
        unidirectionalOneToOneEmbeddedDao.deleteAll();
    }

}
