package spring.persistence.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.UnRelatedDao;
import spring.persistence.entities.UnRelatedEntity;

@Controller
public class JpaRepositoryController {
    @Autowired
    private UnRelatedDao unRelatedDao;

    public void process() {
        List<UnRelatedEntity> entitylist = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            entitylist.add(new UnRelatedEntity("Nick" + i));
        }
        unRelatedDao.save(entitylist);
        System.out.println(">>>> UnRelatedEntity...");
        
        System.out.println("         count:  " + unRelatedDao.count());
        
        System.out.print("         findAll (ids)...");
        for (UnRelatedEntity unRelatedEntity : unRelatedDao.findAll()) {
            System.out.print(" " + unRelatedEntity.getId());
        }
        System.out.println();
        
        System.out.println("         findOne(3):  " + unRelatedDao.findOne(3));
        
        int page = 2;// empieza en 0
        int size = 10;// tamaño de la página
        System.out.println("         findAll(page "+ page + "):  ");
        for (UnRelatedEntity unRelatedEntity : unRelatedDao.findAll(new PageRequest(page, size))) {
            System.out.println("             " + unRelatedEntity.toString());
        }
    }

}
