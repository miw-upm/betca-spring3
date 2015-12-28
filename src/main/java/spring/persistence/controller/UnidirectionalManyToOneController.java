package spring.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.AnyDao;
import spring.persistence.daos.UnidirectionalManyToOneDao;
import spring.persistence.entities.AnyEntity;
import spring.persistence.entities.UnidirectionalManyToOneEntity;

@Controller
public class UnidirectionalManyToOneController {

    @Autowired
    private UnidirectionalManyToOneDao unidirectionalManyToOneDao;
    
    @Autowired
    private AnyDao anyDao;

    public void process() {
        AnyEntity anyEntity = new AnyEntity(666, "daemon");
        anyDao.save(anyEntity);
        
        UnidirectionalManyToOneEntity entity = new UnidirectionalManyToOneEntity("Mi Nick", anyEntity);
        unidirectionalManyToOneDao.save(entity);
        
        UnidirectionalManyToOneEntity entity2 = new UnidirectionalManyToOneEntity("Mi Nick 2", anyEntity);
        unidirectionalManyToOneDao.save(entity2);

        System.out.println(">>>> UnidirectionalManyToOneEntity:  " + unidirectionalManyToOneDao.findOne(entity.getId()));
        System.out.println(">>>> UnidirectionalManyToOneEntity:  " + unidirectionalManyToOneDao.findOne(entity2.getId()));
    }
}
