package persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UnidirectionalOneToManyEntity {

    @Id
    @GeneratedValue
    private int id;

    private String nick;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AnyEntity> anyEntityList;

    public UnidirectionalOneToManyEntity() {
    }

    public UnidirectionalOneToManyEntity(String nick, List<AnyEntity> anyEntityList) {
        this.nick = nick;
        this.anyEntityList = anyEntityList;
    }

    @Override
    public String toString() {
        return "UnidirectionalOneToManyEntity [id=" + id + ", nick=" + nick + ", anyEntityList=" + anyEntityList + "]";
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
            return id == ((UnidirectionalOneToManyEntity) obj).id;
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
