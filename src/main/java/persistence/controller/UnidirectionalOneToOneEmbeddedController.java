package persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import persistence.daos.UnidirectionalOneToOneEmbeddedDao;
import persistence.entities.EmbeddableEntity;
import persistence.entities.UnidirectionalOneToOneEmbeddedEntity;

@Controller
public class UnidirectionalOneToOneEmbeddedController {

    @Autowired
    private UnidirectionalOneToOneEmbeddedDao unidirectionalOneToOneEmbeddedDao;

    public void process() {
        EmbeddableEntity embeddable = new EmbeddableEntity(666, "daemon");
        UnidirectionalOneToOneEmbeddedEntity entity = new UnidirectionalOneToOneEmbeddedEntity("Mi Nick", embeddable);
        unidirectionalOneToOneEmbeddedDao.save(entity);

        System.out.println(">>>> UnidirectionalOneToOneEmbeddedEntity:  " + unidirectionalOneToOneEmbeddedDao.findOne(entity.getId()));
    }
}
