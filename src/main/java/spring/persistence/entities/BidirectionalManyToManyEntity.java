package spring.persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class BidirectionalManyToManyEntity {

    @Id
    @GeneratedValue
    private int id;

    private String nick;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ManyToManyMappedByEntity> manyToManyMappedByEntityList;

    public BidirectionalManyToManyEntity() {
    }

    public BidirectionalManyToManyEntity(String nick, List<ManyToManyMappedByEntity> manyToManyMappedByEntityList) {
        this.nick = nick;
        this.manyToManyMappedByEntityList = manyToManyMappedByEntityList;
    }

    @Override
    public String toString() {
        return "BidirectionalManyToManyEntity [id=" + id + ", nick=" + nick + ", manyToManyMappedByEntityList="
                + manyToManyMappedByEntityList + "]";
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
            BidirectionalManyToManyEntity other = (BidirectionalManyToManyEntity) obj;
            return id == other.id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public List<ManyToManyMappedByEntity> getManyToManyMappedByEntityList() {
        return manyToManyMappedByEntityList;
    }
}
