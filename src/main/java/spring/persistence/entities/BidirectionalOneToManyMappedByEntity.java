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
    private List<ManyToOneJoinColumnEntity> manyToOneJoinColumnEntityList;

    public BidirectionalOneToManyMappedByEntity() {
    }

    public BidirectionalOneToManyMappedByEntity(String nick, List<ManyToOneJoinColumnEntity> manyToOneJoinColumnEntityList) {
        this.nick = nick;
        this.manyToOneJoinColumnEntityList = manyToOneJoinColumnEntityList;
    }

    @Override
    public String toString() {
        return "BidirectionalOneToManyMappedByEntity [id=" + id + ", nick=" + nick + ", manyToOneJoinColumnEntity="
                + manyToOneJoinColumnEntityList + "]";
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
            return id == ((BidirectionalOneToManyMappedByEntity) obj).id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public List<ManyToOneJoinColumnEntity> getManyToOneJoinColumnEntityList() {
        return manyToOneJoinColumnEntityList;
    }

}
