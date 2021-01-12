package library.hib;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Administrator")
public class Admin {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Admin_id")
    private int admin_id;

    @Column(name = "Admin_name")
    private String admin_name;

    @OneToMany(mappedBy = "admins", cascade = CascadeType.ALL,  orphanRemoval = true)
    private Set<Library> libs;
    public int getAdmin_id() {
        return admin_id;
    }
    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
    public String getAdmin_name() {
        return admin_name;
    }
    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }
    public Set<Library> getLibs() {
        return libs;
    }
    public void setLibs(Set<Library> libs) {
        this.libs = libs;
    }

}

