package persistence.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BidirectionalOneToOneMappedByEntity {

    @Id
    @GeneratedValue
    private int id;

    private String nick;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bidirectionalOneToOneMappedByEntity")
    private OneToOneJoinColumnEntity oneToOneJoinColumnEntity;

    public BidirectionalOneToOneMappedByEntity() {
    }

    public BidirectionalOneToOneMappedByEntity(String nick, OneToOneJoinColumnEntity oneToOneJoinColumnEntity) {
        this.nick = nick;
        this.oneToOneJoinColumnEntity = oneToOneJoinColumnEntity;
    }

    @Override
    public String toString() {
        return "BidirectionalOneToOneMappedByEntity [id=" + id + ", nick=" + nick + ", OneToOneJoinColumnEntity="
                + oneToOneJoinColumnEntity + "]";
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
            return id == ((BidirectionalOneToOneMappedByEntity) obj).id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public OneToOneJoinColumnEntity getOneToOneJoinColumnEntity() {
        return oneToOneJoinColumnEntity;
    }

}
