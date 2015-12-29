package spring.persistence.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.AnyDao;
import spring.persistence.daos.UnidirectionalManyToManyDao;
import spring.persistence.entities.AnyEntity;
import spring.persistence.entities.UnidirectionalManyToManyEntity;

@Controller
public class UnidirectionalManyToManyController {

    @Autowired
    private UnidirectionalManyToManyDao unidirectionalManyToManyDao;
    
    @Autowired
    private AnyDao anyDao;

    public void process() {
        AnyEntity[] array = {new AnyEntity("uno"), new AnyEntity("dos"), new AnyEntity("tres")};
        AnyEntity[] array2 = {new AnyEntity("cuatro"), new AnyEntity("cinco")};
        anyDao.save(Arrays.asList(array));
        anyDao.save(Arrays.asList(array2));
        UnidirectionalManyToManyEntity entity = new UnidirectionalManyToManyEntity("Mi Nick", Arrays.asList(array));
        unidirectionalManyToManyDao.save(entity);

        System.out.println(">>>> UnidirectionalManyToManyEntity:  " + unidirectionalManyToManyDao.findOne(entity.getId()));
    }
}
