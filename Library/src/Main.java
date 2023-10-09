
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> books = new TreeSet<>(new OrderNameComparator());
        books.add(new Book("Eylul", 200, "Mehmet Rauf", 1901));
        books.add(new Book("Mai ve Siyah", 328, "Halit Ziya Uşaklıgil", 1897));
        books.add(new Book("Uc Istanbul", 350, "Mithat Cemal Kuntay", 1938));
        books.add(new Book("Calikusu", 409, "Reşat Nuri Güntekin", 1922));
        books.add(new Book("Gece", 232, "Bilge Karasu", 1985));

        for (Book book : books){
            System.out.println(book.getName() + " " + book.getPageNumber());
        }
        System.out.println("---------------");
        TreeSet<Book> booksNumb = new TreeSet<>(new OrderPageNumberComparator());
        booksNumb.add(new Book("Eylul", 200, "Mehmet Rauf", 1901));
        booksNumb.add(new Book("Mai ve Siyah", 328, "Halit Ziya Uşaklıgil", 1897));
        booksNumb.add(new Book("Uc Istanbul", 350, "Mithat Cemal Kuntay", 1938));
        booksNumb.add(new Book("Calikusu", 409, "Reşat Nuri Güntekin", 1922));
        booksNumb.add(new Book("Gece", 232, "Bilge Karasu", 1985));

        for (Book page : booksNumb){
            System.out.println(page.getName() + " " + page.getPageNumber());
        }



    }
}
