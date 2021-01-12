package library.hib;

import java.util.*;

public class Main {
    static Library l2 = new Library();


    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Admin a1 = new Admin();
        LibOprImp k = new LibOprImp();
        int n=0;int n1= 0; int n2= 0;
        while (n!=3) {
            System.out.println("Enter choice of action:"+"\n" + "1.Admin:" +"\n" + "2.Librarian:"+"\n"+"3.Exit:");
            n= sc.nextInt();

            if (n==1) {
                while(n1!=5)
                {
                    System.out.println("Hello Admin! what would you like to do today?");
                    System.out.println("*** ********************************");
                    System.out.println("Options"+ "\n"+ "1.Add Admin:"+"\n"+"2.Add Librarian:"+"\n"+"3.Remove Librarian:"+"\n"+"4.view Librarian:"+"\n"+"5.logout:");
                    n1= sc.nextInt();
                    if (n1 ==1) {
                        System.out.println("Enter Admin ID");
                        a1.setAdmin_id(sc.nextInt());
                        System.out.println("Enter Admin Name");
                        a1.setAdmin_name(sc.next());
                        k.adda(a1);
                    }
                    else if (n1 ==2) {
                        System.out.println("Enter Librarian ID");
                        l2.setLibid(sc.nextInt());
                        System.out.println("Enter Librarian Name");
                        l2.setLibname(sc.next());
                        l2.setAdmins(a1);
                        k.insertl(l2);

                    }
                    else if (n1== 3) {
                        System.out.println("Enter Librarian ID to delete");
                        int del=sc.nextInt();
                        k.deletel(del);

                    }
                    else if(n1== 4) {
                        k.retrievel();
                    }
                    else if (n1 == 5) {
                        System.out.println("*******************");
                        System.out.println("Logged out of Admin");
                        System.out.println("*******************");
                    }

                    else {System.out.println("Number of of range");
                    }
                }
            }
            if(n == 2)
            {

                while(n2 != 6) {
                    System.out.println("Hello Librarian! what would you like to do today?");
                    System.out.println("*************************************");
                    System.out.println("Options"+"\n"+"1.Add Books:"+"\n"+"2.View Books:"+"\n"+"3.Issue Book:"+"\n"+"4.View Issued Books:"+"\n"+"5.Return Books:"+"\n"+"6.Logout:");
                    n2 =sc.nextInt();
                    if(n2 ==1) {
                        System.out.println("Enter number of books");
                        int noofbooks = sc.nextInt();
                        for(int x=1; x<= noofbooks; x++) {
                            Book b1 = new Book();
                            System.out.println("Enter Book ID");
                            b1.setBookid(sc.nextInt());
                            System.out.println("Enter Book Name");
                            b1.setBookname(sc.next());
                            System.out.println("Enter Book Author");
                            b1.setAuthor(sc.next());
                            System.out.println("Enter Book Availability");
                            b1.setAvailability(sc.nextInt());
                            b1.setLib(l2);
                            Set<Book>bkset= new HashSet<Book>();
                            bkset.add(b1);
                            l2.setBooks(bkset);
                            k.add(b1);
                        }
                    }
                    if(n2 ==2) {
                        k.viewb();
                    }

                    if(n2 ==3) {
                        System.out.println("choose ID from Books");
                        k.viewb();
                        System.out.println("Enter Book ID to be issued");
                        int bid= sc.nextInt();

                        k.issueb(bid);
                        k.viewb();
                    }
                    if(n2 ==4) {
                        k.viewissued();
                    }
                    if(n2==5) {
                        System.out.println("choose ID from Books");
                        k.viewb();
                        System.out.println("Enter Book ID to be returned");
                        int bid= sc.nextInt();
                        k.returnb(bid);
                    }
                    if(n2 ==6) {
                        System.out.println("*******************");
                        System.out.println("Librarian Logged out");
                        System.out.println("*******************");
                    }

                }
            }
            else if (n==3) {
                break;
            }

        }
    }
}


