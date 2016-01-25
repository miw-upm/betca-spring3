package persistence.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BidirectionalOneToOneJoinColumnEntity {

    @Id
    @GeneratedValue
    private int id;

    private String nick;

    @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn
    private OneToOneMappedByEntity oneToOneMappedByEntity;

    public BidirectionalOneToOneJoinColumnEntity() {
    }

    public BidirectionalOneToOneJoinColumnEntity(String nick, OneToOneMappedByEntity oneToOneMappedByEntity) {
        this.nick = nick;
        this.oneToOneMappedByEntity = oneToOneMappedByEntity;
    }

    @Override
    public String toString() {
        return "BidirectionalOneToOneJoinColumnEntity [id=" + id + ", nick=" + nick + ", OneToOneMappedByEntity=" + oneToOneMappedByEntity
                + "]";
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
            return id == ((BidirectionalOneToOneJoinColumnEntity) obj).id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public OneToOneMappedByEntity getOneToOneMappedByEntity() {
        return oneToOneMappedByEntity;
    }

}
