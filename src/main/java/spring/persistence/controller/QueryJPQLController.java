package spring.persistence.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.UnRelatedDao;
import spring.persistence.entities.UnRelatedEntity;

@Controller
public class QueryJPQLController {
    @Autowired
    private UnRelatedDao unRelatedDao;

    public void process() {
        List<UnRelatedEntity> entityList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if (i < 10) {
                entityList.add(new UnRelatedEntity("JPQL0" + i));
            } else {
                entityList.add(new UnRelatedEntity("JPQL" + i));
            }
        }
        entityList.get(6).setLarge("large");
        unRelatedDao.save(entityList);
        System.out.println(">>>> UnRelatedEntity JPQL...");

        System.out.print("         select u.nick from other_name_for_unrelatedentity u where u.nick like ?1... JPQL0%");
        for (String nick : unRelatedDao.findNickByNickLike("JPQL0%")) {
            System.out.print(" " + nick);
        }
        System.out.println();
        
        System.out.print("         select u.id from other_name_for_unrelatedentity u where u.id > ?1 and u.id < ?2... 20,25");
        for (Integer id : unRelatedDao.findIdByIdBetween(20, 25)) {
            System.out.print(" " + id);
        }
        System.out.println();
        

    }

}
