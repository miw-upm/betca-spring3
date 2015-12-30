package spring.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BidirectionalManyToOneJoinColumnEntity {

    @Id
    @GeneratedValue
    private int id;

    private String nick;

    @ManyToOne
    // Not cascade
    @JoinColumn
    private OneToManyMappedByEntity oneToManyMappedByEntity;

    public BidirectionalManyToOneJoinColumnEntity() {
    }

    public BidirectionalManyToOneJoinColumnEntity(String nick, OneToManyMappedByEntity oneToManyMappedByEntity) {
        this.nick = nick;
        this.oneToManyMappedByEntity = oneToManyMappedByEntity;
    }

    @Override
    public String toString() {
        return "BidirectionalManyToOneJoinColumnEntity [id=" + id + ", nick=" + nick + ", oneToManyMappedByEntityId="
                + oneToManyMappedByEntity.getId() + "]";
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
            return id == ((BidirectionalManyToOneJoinColumnEntity) obj).id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public OneToManyMappedByEntity getOneToManyMappedByEntity() {
        return oneToManyMappedByEntity;
    }

}
