package persistence.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UnidirectionalOneToOneEmbeddedEntity {
    @Id
    @GeneratedValue
    private int id;

    private String nick;

    @Embedded
    private EmbeddableEntity embeddableEntity;

    public UnidirectionalOneToOneEmbeddedEntity() {
    }

    public UnidirectionalOneToOneEmbeddedEntity(String nick, EmbeddableEntity embeddableEntity) {
        this.nick = nick;
        this.embeddableEntity = embeddableEntity;
    }

    @Override
    public String toString() {
        return "UnidirectionalOneToOneEmbeddedEntity [id=" + id + ", nick=" + nick + ", embeddableEntity=" + embeddableEntity + "]";
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
            return id == ((UnidirectionalOneToOneEmbeddedEntity) obj).id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public EmbeddableEntity getEmbeddableEntity() {
        return embeddableEntity;
    }

}
