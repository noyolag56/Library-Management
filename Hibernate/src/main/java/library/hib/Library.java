package library.hib;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Librarian")

public class Library {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="Lib_id")
    private int libid;
    @Column(name = "Librarian_Name")
    private String libname;
    @OneToMany(mappedBy="lib")
    public Set<Book>books;
    @ManyToOne
    @JoinColumn(name="admin_id", nullable=false)
    private Admin admins;

    public Admin getAdmins() {
        return admins;
    }
    public void setAdmins(Admin admins) {
        this.admins = admins;
    }
    public int getLibid() {
        return libid;
    }
    public void setLibid(int libid) {
        this.libid = libid;
    }
    public String getLibname() {
        return libname;
    }
    public void setLibname(String libname) {
        this.libname = libname;
    }
    public Set<Book> getBooks() {
        return books;
    }
    public void setBooks(Set<Book> books) {
        this.books = books;
    }

}
