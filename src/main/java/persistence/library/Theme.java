package persistence.library;

public class Theme {

    private int id;

    private String name;

    public Theme() {
    }
    
    public Theme(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Theme [id=" + id + ", name=" + name + "]";
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
            return id == ((Theme) obj).id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

}
