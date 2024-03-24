public class Book {
    public String name;
    private int pageNumber;


public Book (String nm, int pgNumber){
    this.name = nm;
    if (pgNumber < 0){
        pgNumber = 0;
    }
    this.pageNumber = pgNumber;
}
public int showPageNumber (){
return this.pageNumber;

}
}
