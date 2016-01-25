package persistence.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import persistence.daos.UnRelatedDao;
import persistence.entities.UnRelatedEntity;

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
        entityList.add(new UnRelatedEntity("SQL666"));
        
        entityList.get(6).setLarge("large");
        unRelatedDao.save(entityList);
        System.out.println(">>>> UnRelatedEntity JPQL...");

        System.out.print("         select u.nick from other_name_for_unrelatedentity u where u.nick like ?1... JPQL0% >>>>>");
        for (String nick : unRelatedDao.findNickByNickLike("JPQL0%")) {
            System.out.print(" " + nick);
        }
        System.out.println();
        
        System.out.print("         select u.id from other_name_for_unrelatedentity u where u.id > ?1 and u.id < ?2... 20,25 >>>>>");
        for (Integer id : unRelatedDao.findIdByIdBetween(20, 25)) {
            System.out.print(" " + id);
        }
        System.out.println();
        
        System.out.println(">>>> UnRelatedEntity SQL...");
        System.out.print("         SELECT * FROM other_name_for_unrelatedentity WHERE KCIN = ?1... SQL666 >>>>>");
        System.out.println(" " + unRelatedDao.findByNick("SQL666"));
    }

}
