package renaldinumazid.pencatatan.buku.entity;

public class User {
    private Integer id;
    private String username;
    private String name;
    private String password;
    private Role role;

    public enum Role {
        Admin,
        User
    }

    public User(Integer id, String username, String name, String password, Role role) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

