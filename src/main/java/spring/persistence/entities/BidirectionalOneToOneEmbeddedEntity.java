package spring.persistence.entities;

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
    private BidirectionalOneToOneEmbeddableEntity bidirectionalOneToOneEmbeddableEntity;

    public BidirectionalOneToOneEmbeddedEntity() {
    }

    public BidirectionalOneToOneEmbeddedEntity(String nick, BidirectionalOneToOneEmbeddableEntity bidirectionalOneToOneEmbeddableEntity) {
        this.nick = nick;
        this.bidirectionalOneToOneEmbeddableEntity = bidirectionalOneToOneEmbeddableEntity;
    }


    @Override
    public String toString() {
        return "BidirectionalOneToOneEmbeddedEntity [id=" + id + ", nick=" + nick + ", bidirectionalOneToOneEmbeddableEntity="
                + bidirectionalOneToOneEmbeddableEntity + "]";
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
            BidirectionalOneToOneEmbeddedEntity other = (BidirectionalOneToOneEmbeddedEntity) obj;
            return id == other.id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public BidirectionalOneToOneEmbeddableEntity getBidirectionalOneToOneEmbeddableEntity() {
        return bidirectionalOneToOneEmbeddableEntity;
    }

}
