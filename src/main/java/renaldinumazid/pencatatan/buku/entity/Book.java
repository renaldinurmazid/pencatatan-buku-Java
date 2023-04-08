package renaldinumazid.pencatatan.buku.entity;

public class Book {

    private String title;
    private String author;
    private Integer id; 
    private Integer year;

    //Constructur
    public Book() {

    }

    public Book(Integer id,String title, String author, Integer year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        
    }
    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
        
    }

    //Getter
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public Integer getYear() {
        return year;
    }
    public String getAuthor() {
        return author;
    }

    //getter for update book
    // public Book getUpdateBook(String newTitle, String newAuthor, int newYear) {
    //     return new Book(id, newTitle, newAuthor, newYear);
    // }

    //Setter
    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title =  title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    
}
