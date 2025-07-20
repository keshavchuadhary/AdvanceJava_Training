import java.io.Serializable;

public class UserBean implements Serializable {
    // Private properties
    private String name;
    private int age;
    private boolean active;

    // 1. Public no-arg constructor
    public UserBean() {}

    // 2. Getter/setter methods following naming conventions
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Boolean getter uses "is" instead of "get"
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}