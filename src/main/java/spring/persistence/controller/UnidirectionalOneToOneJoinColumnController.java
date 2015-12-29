package spring.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.UnidirectionalOneToOneJoinColumnDao;
import spring.persistence.entities.AnyEntity;
import spring.persistence.entities.UnidirectionalOneToOneJoinColumnEntity;

@Controller
public class UnidirectionalOneToOneJoinColumnController {

    @Autowired
    private UnidirectionalOneToOneJoinColumnDao unidirectionalOneToOneJoinColumnDao;

    public void process() {
        AnyEntity anyEntity = new AnyEntity(666, "daemon");
        UnidirectionalOneToOneJoinColumnEntity entity = new UnidirectionalOneToOneJoinColumnEntity("Mi Nick", anyEntity);
        unidirectionalOneToOneJoinColumnDao.save(entity);

        System.out.println(">>>> UnidirectionalOneToOneJoinColumnEntity:  " + unidirectionalOneToOneJoinColumnDao.findOne(entity.getId()));
    }
}
