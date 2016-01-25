package persistence.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import persistence.daos.UnRelatedDao;
import persistence.entities.UnRelatedEntity;

@Controller
public class QueryMethodsController {
    @Autowired
    private UnRelatedDao unRelatedDao;

    public void process() {
        List<UnRelatedEntity> entityList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if (i < 10) {
                entityList.add(new UnRelatedEntity("Query0" + i));
            } else {
                entityList.add(new UnRelatedEntity("Query" + i));
            }
        }
        entityList.get(6).setLarge("large");
        unRelatedDao.save(entityList);
        System.out.println(">>>> UnRelatedEntity QueryMethods...");

        System.out.println("         findByNickIgnoreCase (\"query05\")..." + unRelatedDao.findByNickIgnoreCase("query05"));

        System.out.print("         findFirst3ByNickStartingWith (\"Query0\")...");
        for (UnRelatedEntity unRelatedEntity : unRelatedDao.findFirst3ByNickStartingWith("Query0")) {
            System.out.print(" " + unRelatedEntity);
        }
        System.out.println();

        System.out.print("         findByNickOrLargeOrderByIdDesc (\"Query5\",\"large\")...");
        for (UnRelatedEntity unRelatedEntity : unRelatedDao.findByNickOrLargeOrderByIdDesc("Query5", "large")) {
            System.out.print(" " + unRelatedEntity);
        }
        System.out.println();

        System.out.print("         findByIdGreaterThan(90,new PageRequest(1, 5))...");
        for (UnRelatedEntity unRelatedEntity : unRelatedDao.findByIdGreaterThan(90, new PageRequest(1, 5))) {
            System.out.print(" " + unRelatedEntity);
        }
        System.out.println();

        System.out.print("         findByIdIn(Arrays.asList(new Integer[] {7,8,9}))...");
        for (UnRelatedEntity unRelatedEntity : unRelatedDao.findByIdIn(Arrays.asList(new Integer[] {7,8,9}))) {
            System.out.print(" " + unRelatedEntity);
        }
        System.out.println();

    }

}
