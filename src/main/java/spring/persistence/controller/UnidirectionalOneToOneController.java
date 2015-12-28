package spring.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.UnidirectionalOneToOneDao;
import spring.persistence.entities.AnyEntity;
import spring.persistence.entities.UnidirectionalOneToOneEntity;

@Controller
public class UnidirectionalOneToOneController {

    @Autowired
    private UnidirectionalOneToOneDao unidirectionalOneToOneDao;

    public void process() {
        AnyEntity anyEntity = new AnyEntity(666, "daemon");
        UnidirectionalOneToOneEntity entity = new UnidirectionalOneToOneEntity("Mi Nick", anyEntity);
        unidirectionalOneToOneDao.save(entity);

        System.out.println(">>>> UnidirectionalOneToOneEntity:  " + unidirectionalOneToOneDao.findOne(entity.getId()));
    }
}
