package spring.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.BidirectionalOneToOneJoinColumnDao;
import spring.persistence.entities.BidirectionalOneToOneJoinColumnEntity;
import spring.persistence.entities.OneToOneMappedByEntity;

@Controller
public class BidirectionalOneToOneJoinColumnController {

    @Autowired
    private BidirectionalOneToOneJoinColumnDao bidirectionalOneToOneJoinColumnDao;

    public void process() {
        OneToOneMappedByEntity mappedBy = new OneToOneMappedByEntity("daemon");
        BidirectionalOneToOneJoinColumnEntity entity = new BidirectionalOneToOneJoinColumnEntity("Mi Nick", mappedBy);
        mappedBy.setBidirectionalOneToOneJoinColumnEntity(entity);
        bidirectionalOneToOneJoinColumnDao.save(entity);

        System.out.println(">>>> BidirectionalOneToOneJoinColumnEntity:  " + bidirectionalOneToOneJoinColumnDao.findOne(entity.getId()));
    }
}
