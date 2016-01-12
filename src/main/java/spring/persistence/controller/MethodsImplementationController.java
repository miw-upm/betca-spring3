package spring.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.UnRelatedDao;
import spring.persistence.entities.UnRelatedEntity;

@Controller
public class MethodsImplementationController {
    @Autowired
    private UnRelatedDao unRelatedDao;

    public void process() {
        unRelatedDao.custom(new UnRelatedEntity("custom"));
        System.out.println(">>>> UnRelatedEntity Implementation...");
        System.out.println("       " + unRelatedDao.findByNick("custom"));   
    }

}
