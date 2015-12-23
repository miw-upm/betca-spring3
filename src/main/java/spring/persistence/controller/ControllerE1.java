package spring.persistence.controller;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.UnRelatedDao;
import spring.persistence.entities.Gender;
import spring.persistence.entities.UnRelatedEntity;

@Controller
public class ControllerE1 {

    @Autowired
    private UnRelatedDao unRelatedDao;

    public void process() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }
        UnRelatedEntity uno = new UnRelatedEntity("Mi Nick", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...",
                list.toArray(new String[0]), list, "no persistence");
        unRelatedDao.save(uno);
        System.out.println(">>>> uno:  " + uno);
    }
}
