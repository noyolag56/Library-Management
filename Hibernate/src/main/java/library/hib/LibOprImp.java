package library.hib;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;


public class LibOprImp implements LibOpr{
    private SessionFactory fact;
    private Session ses;
    private Scanner sc = new Scanner(System.in);
    private Transaction tx;


    public  LibOprImp()
    {
        fact = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Library.class).addAnnotatedClass(Book.class).
                addAnnotatedClass(Admin.class).
                buildSessionFactory();
        ses=fact.openSession();
    }

    @Override
    public void insertl(Library l) {

        tx=ses.beginTransaction();
        ses.save(l);
        tx.commit();
        System.out.println("Data Inserted");

    }

    @Override
    public void deletel(int lid) {
        Library l =  ses.get(Library.class,lid);
        tx=ses.beginTransaction();
        ses.delete(l);
        tx.commit();
        System.out.println("Data deleted");

    }

    @Override
    public void retrievel() {

        Query q = ses.createQuery(" from Library  ");
        List<Library> l1= q.list();
        for(Library ls : l1) {
            System.out.println("*** Librarian Details****");
            System.out.println(ls.getLibid() + "\t " + ls.getLibname());
            System.out.println("*** ***********************");


        }
    }

    @Override
    public void add(Book b) {

        tx=ses.beginTransaction();
        ses.save(b);
        tx.commit();
        System.out.println("Data Inserted");
    }
    public void bdelete(int bid) {

        Book b = ses.load(Book.class , bid);


        tx=ses.beginTransaction();
        ses.delete(b);
        tx.commit();
        System.out.println("Data Deleted");

    }

    @Override
    public void viewb() {
        Query q = ses.createQuery("  from Book  ");
        List<Book> b = q.list();
        System.out.println("*** Book Details****");
        for(Book bk : b) {

            System.out.println(bk.getBookid()+ "\t " + bk.getBookname()+"\t " + bk.getAuthor()+"\t " + bk.getAvailability());
        }

    }

    @Override
    public void issueb(int bid) {
        tx=ses.beginTransaction();
        Book b1=ses.get(Book.class, bid);
        b1.setAvailability(0);
        tx.commit();
        System.out.println("Book issued");

    }

    @Override
    public void returnb(int bid) {
        tx=ses.beginTransaction();
        Book b1=ses.get(Book.class, bid);
        b1.setAvailability(+1);
        tx.commit();
        System.out.println("Book Returned");

    }

    @Override
    public void adda(Admin a) {

        tx=ses.beginTransaction();
        ses.save(a);
        tx.commit();
        System.out.println("Data Inserted");
    }

    @Override
    public void remove(int aid) {
        Admin a = ses.load(Admin.class , aid);


        tx=ses.beginTransaction();
        ses.delete(a);
        tx.commit();
        System.out.println("Data Deleted");

    }

    @Override
    public void aretrieve() {
        Query q = ses.createQuery(" from Admin  ");
        List<Admin> a1= q.list();
        for(Admin as : a1) {
            System.out.println("*** Admin Details****");
            System.out.println(as.getAdmin_id()+ "\t " + as.getAdmin_name());


        }

    }

    @Override
    public void viewissued() {
        Query q = ses.createQuery("  from Book where  availability =0 ");
        List<Book> b = q.list();
        System.out.println("*** Book Details****");
        for(Book bk : b) {

            System.out.println(bk.getBookid()+ "\t " + bk.getBookname()+"\t " + bk.getAuthor()+"\t " + bk.getAvailability());
        }

    }

}