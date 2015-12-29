package spring.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.BidirectionalOneToOneMappedByDao;
import spring.persistence.entities.BidirectionalOneToOneMappedByEntity;
import spring.persistence.entities.OneToOneJoinColumnEntity;

@Controller
public class BidirectionalOneToOneMappedByController {

    @Autowired
    private BidirectionalOneToOneMappedByDao bidirectionalOneToOneMappedByDao;

    public void process() {
        OneToOneJoinColumnEntity joinColumn = new OneToOneJoinColumnEntity(666, "daemon");
        BidirectionalOneToOneMappedByEntity entity = new BidirectionalOneToOneMappedByEntity("Mi Nick", joinColumn);
        joinColumn.setBidirectionalOneToOneMappedByEntity(entity);
        bidirectionalOneToOneMappedByDao.save(entity);

        System.out.println(">>>> BidirectionalOneToOneMappedByEntity:  " + bidirectionalOneToOneMappedByDao.findOne(entity.getId()));
    }
}
