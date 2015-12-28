package spring.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UnidirectionalManyToOneEntity {
    
    @Id
    @GeneratedValue
    private int id;

    private String nick;

    @ManyToOne
    private AnyEntity anyEntity;

    public UnidirectionalManyToOneEntity() {
    }

    public UnidirectionalManyToOneEntity(String nick, AnyEntity anyEntity) {
        this.nick = nick;
        this.anyEntity = anyEntity;
    }

    @Override
    public String toString() {
        return "UnidirectionalOneToOneEntity [id=" + id + ", nick=" + nick + ", anyEntity=" + anyEntity + "]";
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
            UnidirectionalManyToOneEntity other = (UnidirectionalManyToOneEntity) obj;
            return id == other.id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public AnyEntity getAnyEntity() {
        return anyEntity;
    }

}
