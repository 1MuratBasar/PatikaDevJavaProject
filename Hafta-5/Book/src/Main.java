import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> books = new TreeSet<>(new OrderByNameComparator());

        books.add(new Book("Yüzüklerin Efendisi" , 890, "JK R.", "01.01.2000"));
        books.add(new Book("Otomaik Portakal" , 300, "AB. C.", "01.01.1950"));
        books.add(new Book("Hayvan Çiftliği" , 480, "G. O.", "01.01.1950"));
        books.add(new Book("Hayvan Mezarlığı" , 450, "S. K.", "01.01.1960"));
        books.add(new Book("İvan İlyiç in Ölümü" , 250, "T.", "01.01.1955"));

        for (Book book : books) {
           System.out.println(book.getBookName());
       }

        TreeSet<Book> books2 = new TreeSet<>(new OrderByPageNumberComparator());

        books2.add(new Book("Yüzüklerin Efendisi" , 890, "JK R.", "01.01.2000"));
        books2.add(new Book("Otomaik Portakal" , 300, "AB. C.", "01.01.1950"));
        books2.add(new Book("Hayvan Çiftliği" , 480, "G. O.", "01.01.1950"));
        books2.add(new Book("Hayvan Mezarlığı" , 450, "S. K.", "01.01.1960"));
        books2.add(new Book("İvan İlyiç in Ölümü" , 250, "T.", "01.01.1955"));

        for (Book book2 : books2) {
           System.out.println(book2.getPageNumber());
        }
    }
}