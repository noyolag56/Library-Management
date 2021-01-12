package library.hib;

public interface LibOpr {
    public void adda(Admin a);
    public void aretrieve();
    public void remove (int aid);
    public void insertl(Library l);
    public void deletel(int lid);
    public void retrievel();
    public void add(Book b);
    public void bdelete(int bid);
    public void viewb ();
    public void issueb(int bid);
    public void returnb(int bid);
    public void viewissued();

}