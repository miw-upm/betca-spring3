package spring.persistence.controller;

import java.util.Arrays;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.UnRelatedDao;
import spring.persistence.entities.Gender;
import spring.persistence.entities.UnRelatedEntity;

@Controller
public class UnRelatedController {

    @Autowired
    private UnRelatedDao unRelatedDao;

    public void process() {
        String[] list = {"0", "1", "2", "3", "4"};
        UnRelatedEntity entity = new UnRelatedEntity("Mi Nick", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                Arrays.asList(list), "no persistence");
        unRelatedDao.save(entity);
        System.out.println(">>>> UnRelatedEntity:  " + entity);
    }
}
