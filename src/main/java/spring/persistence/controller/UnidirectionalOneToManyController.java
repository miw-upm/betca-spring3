package spring.persistence.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.UnidirectionalOneToManyDao;
import spring.persistence.entities.AnyEntity;
import spring.persistence.entities.UnidirectionalOneToManyEntity;

@Controller
public class UnidirectionalOneToManyController {

    @Autowired
    private UnidirectionalOneToManyDao unidirectionalOneToManyDao;

    public void process() {
        AnyEntity[] array = {new AnyEntity("uno"), new AnyEntity("dos"), new AnyEntity("tres")};
        UnidirectionalOneToManyEntity entity = new UnidirectionalOneToManyEntity("Mi Nick",Arrays.asList(array));
        unidirectionalOneToManyDao.save(entity);
        System.out.println(">>>> UnidirectionalOneToManyEntity:  " + unidirectionalOneToManyDao.findOne(entity.getId()));
    }
}
