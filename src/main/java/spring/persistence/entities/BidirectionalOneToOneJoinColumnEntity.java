package spring.persistence.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BidirectionalOneToOneJoinColumnEntity {

    @Id
    @GeneratedValue
    private int id;

    private String nick;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private OneToOneMappedByEntity OneToOneMappedByEntity;

    public BidirectionalOneToOneJoinColumnEntity() {
    }

    public BidirectionalOneToOneJoinColumnEntity(String nick, OneToOneMappedByEntity OneToOneMappedByEntity) {
        this.nick = nick;
        this.OneToOneMappedByEntity = OneToOneMappedByEntity;
    }

    @Override
    public String toString() {
        return "BidirectionalOneToOneJoinColumnEntity [id=" + id + ", nick=" + nick + ", OneToOneMappedByEntity="
                + OneToOneMappedByEntity + "]";
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
            BidirectionalOneToOneJoinColumnEntity other = (BidirectionalOneToOneJoinColumnEntity) obj;
            return id == other.id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public OneToOneMappedByEntity getOneToOneMappedByEntity() {
        return OneToOneMappedByEntity;
    }
    
}
