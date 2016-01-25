package persistence.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class UnidirectionalManyToManyEntity {

    @Id
    @GeneratedValue
    private int id;

    private String nick;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AnyEntity> anyEntityList;

    public UnidirectionalManyToManyEntity() {
    }

    public UnidirectionalManyToManyEntity(String nick, List<AnyEntity> anyEntityList) {
        this.nick = nick;
        this.anyEntityList = anyEntityList;
    }

    @Override
    public String toString() {
        return "UnidirectionalManyToManyEntity [id=" + id + ", nick=" + nick + ", anyEntityList=" + anyEntityList + "]";
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
            return id == ((UnidirectionalManyToManyEntity) obj).id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public List<AnyEntity> getAnyEntityList() {
        return anyEntityList;
    }
}
