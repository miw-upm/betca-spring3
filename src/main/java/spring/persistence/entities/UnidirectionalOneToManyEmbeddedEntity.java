package spring.persistence.entities;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UnidirectionalOneToManyEmbeddedEntity {

    @Id
    @GeneratedValue
    private int id;

    private String nick;

    private AnyClass[] anyClassArray;

    public UnidirectionalOneToManyEmbeddedEntity() {
    }

    public UnidirectionalOneToManyEmbeddedEntity(String nick, AnyClass[] anyClassArray) {
        this.nick = nick;
        this.anyClassArray = anyClassArray;
    }

    @Override
    public String toString() {
        return "UnidirectionalOneToManyEmbeddedEntity [id=" + id + ", nick=" + nick + ", anyClassArray=" + Arrays.toString(anyClassArray)
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
            UnidirectionalOneToManyEmbeddedEntity other = (UnidirectionalOneToManyEmbeddedEntity) obj;
            return id == other.id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public AnyClass[] getAnyClassArray() {
        return anyClassArray;
    }

}
