package library.hib;

import javax.persistence.*;

@Entity
@Table(name="Book")

public class Book {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name="book_id")
    private int  bookid;
    @Column(name="Bookname")
    private String bookname;
    @Column(name="Author")
    private String author;
    @Column(name="Availability")
    private int  availability;
    @ManyToOne
    @JoinColumn(name="libid", nullable=false)

    private Library lib;


    public int getBookid() {
        return bookid;
    }
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getAvailability() {
        return availability;
    }
    public void setAvailability(int availability) {
        this.availability = availability;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Library getLib() {
        return lib;
    }
    public void setLib(Library lib) {
        this.lib = lib;
    }

    public Book(){}

    public Book(int  bookid, String bookname, String author, Library l){
        this.bookid=bookid;
        this.bookname=bookname;
        this.author=author;
        this.lib=l;
    }

}
