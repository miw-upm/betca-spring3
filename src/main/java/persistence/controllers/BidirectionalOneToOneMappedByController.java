package persistence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import persistence.daos.BidirectionalOneToOneMappedByDao;
import persistence.entities.BidirectionalOneToOneMappedByEntity;
import persistence.entities.OneToOneJoinColumnEntity;

@Controller
public class BidirectionalOneToOneMappedByController {

    @Autowired
    private BidirectionalOneToOneMappedByDao bidirectionalOneToOneMappedByDao;

    public void process() {
        OneToOneJoinColumnEntity joinColumn = new OneToOneJoinColumnEntity("daemon");
        BidirectionalOneToOneMappedByEntity entity = new BidirectionalOneToOneMappedByEntity("Mi Nick", joinColumn);
        joinColumn.setBidirectionalOneToOneMappedByEntity(entity);
        bidirectionalOneToOneMappedByDao.save(entity);

        System.out.println(">>>> BidirectionalOneToOneMappedByEntity:  " + bidirectionalOneToOneMappedByDao.findOne(entity.getId()));
    }
}
