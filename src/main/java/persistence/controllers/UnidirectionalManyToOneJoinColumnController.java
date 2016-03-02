package persistence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import persistence.daos.AnyDao;
import persistence.daos.UnidirectionalManyToOneJoinColumnDao;
import persistence.entities.AnyEntity;
import persistence.entities.UnidirectionalManyToOneJoinColumnEntity;

@Controller
public class UnidirectionalManyToOneJoinColumnController {

    @Autowired
    private UnidirectionalManyToOneJoinColumnDao unidirectionalManyToOneJoinColumnDao;
    
    @Autowired
    private AnyDao anyDao;

    public void process() {
        AnyEntity anyEntity = new AnyEntity("daemon");
        anyDao.save(anyEntity);
        
        UnidirectionalManyToOneJoinColumnEntity entity = new UnidirectionalManyToOneJoinColumnEntity("Mi Nick", anyEntity);
        unidirectionalManyToOneJoinColumnDao.save(entity);
        
        UnidirectionalManyToOneJoinColumnEntity entity2 = new UnidirectionalManyToOneJoinColumnEntity("Mi Nick 2", anyEntity);
        unidirectionalManyToOneJoinColumnDao.save(entity2);

        System.out.println(">>>> UnidirectionalManyToOneJoinColumnEntity:  " + unidirectionalManyToOneJoinColumnDao.findOne(entity.getId()));
        System.out.println(">>>> UnidirectionalManyToOneJoinColumnEntity:  " + unidirectionalManyToOneJoinColumnDao.findOne(entity2.getId()));
    }
}
