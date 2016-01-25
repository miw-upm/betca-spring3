package persistence.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import persistence.daos.UnidirectionalOneToManyDao;
import persistence.entities.AnyEntity;
import persistence.entities.UnidirectionalOneToManyEntity;

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
