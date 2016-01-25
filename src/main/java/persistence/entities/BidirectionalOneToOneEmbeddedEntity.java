package persistence.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BidirectionalOneToOneEmbeddedEntity {
    @Id
    @GeneratedValue
    private int id;

    private String nick;

    @Embedded
    private OneToOneEmbeddableEntity oneToOneEmbeddableEntity;

    public BidirectionalOneToOneEmbeddedEntity() {
    }

    public BidirectionalOneToOneEmbeddedEntity(String nick, OneToOneEmbeddableEntity bidirectionalOneToOneEmbeddableEntity) {
        this.nick = nick;
        this.oneToOneEmbeddableEntity = bidirectionalOneToOneEmbeddableEntity;
    }

    @Override
    public String toString() {
        return "BidirectionalOneToOneEmbeddedEntity [id=" + id + ", nick=" + nick + ", oneToOneEmbeddableEntity="
                + oneToOneEmbeddableEntity + "]";
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            return id == ((BidirectionalOneToOneEmbeddedEntity) obj).id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public OneToOneEmbeddableEntity getOneToOneEmbeddableEntity() {
        return oneToOneEmbeddableEntity;
    }

}
