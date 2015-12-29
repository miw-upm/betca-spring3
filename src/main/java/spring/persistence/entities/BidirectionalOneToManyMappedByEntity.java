package spring.persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BidirectionalOneToManyMappedByEntity {

    @Id
    @GeneratedValue
    private int id;

    private String nick;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "bidirectionalOneToManyMappedByEntity")
    private List<ManyToOneJoinColumnEntity> manyToOneJoinColumnEntity;

    public BidirectionalOneToManyMappedByEntity() {
    }

    public BidirectionalOneToManyMappedByEntity(String nick, List<ManyToOneJoinColumnEntity> manyToOneJoinColumnEntity) {
        this.nick = nick;
        this.manyToOneJoinColumnEntity = manyToOneJoinColumnEntity;
    }

    @Override
    public String toString() {
        return "BidirectionalOneToManyMappedByEntity [id=" + id + ", nick=" + nick + ", manyToOneJoinColumnEntity=" + manyToOneJoinColumnEntity
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
            BidirectionalOneToManyMappedByEntity other = (BidirectionalOneToManyMappedByEntity) obj;
            return id == other.id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public List<ManyToOneJoinColumnEntity> getManyToOneJoinColumnEntity() {
        return manyToOneJoinColumnEntity;
    }

}
