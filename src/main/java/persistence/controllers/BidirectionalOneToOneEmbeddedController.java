package persistence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import persistence.daos.BidirectionalOneToOneEmbeddedDao;
import persistence.entities.BidirectionalOneToOneEmbeddedEntity;
import persistence.entities.OneToOneEmbeddableEntity;

@Controller
public class BidirectionalOneToOneEmbeddedController {

    @Autowired
    private BidirectionalOneToOneEmbeddedDao bidirectionalOneToOneEmbeddedDao;

    public void process() {
        OneToOneEmbeddableEntity embeddable = new OneToOneEmbeddableEntity(666, "daemon");
        BidirectionalOneToOneEmbeddedEntity entity = new BidirectionalOneToOneEmbeddedEntity("Mi Nick", embeddable);
        embeddable.setBidirectionalOneToOneEmbeddedEntity(entity);
        bidirectionalOneToOneEmbeddedDao.save(entity);

        System.out.println(">>>> BidirectionalOneToOneEmbeddedEntity:  " + bidirectionalOneToOneEmbeddedDao.findOne(entity.getId()));
    }
}
