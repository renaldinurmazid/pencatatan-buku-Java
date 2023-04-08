package renaldinumazid.pencatatan.buku.service.impl;

import renaldinumazid.pencatatan.buku.entity.Book;
import renaldinumazid.pencatatan.buku.repository.BookRepository;
import renaldinumazid.pencatatan.buku.service.BookService;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    
    @Override
    public void add(String title, String author, Integer year) {
        Book book = new Book(title, author, year);
       
        //add book
        bookRepository.add(book);

        //return
        System.out.println("Book Added Succecfully : " + book.getTitle());
    }

    @Override
    public void getAll() {

        Book[] list = bookRepository.getAll();

        //return
        for (Book book : list) {

            //1. Nanti kita Cerita hari ini ..(Orang - 2022)
        System.out.println(String.format("%d. %s -- (%s - %d)", book.getId(), book.getTitle(), book.getAuthor(),
            book.getYear()));
        }
    }

    @Override
    public Book getById(Integer id) {
        //get data
        Book book = bookRepository.getById(id);

        //return
        System.out.println(String.format("%d. %s -- (%s - %d)", book.getId(), book.getTitle(), book.getAuthor(),
        book.getYear()));
        return book;
    }

    @Override
    //     public boolean update(Integer id, String title, String author, Integer year) {
            
    //         return bookRepository.update(book);
    // }
    public void update(Integer id, String title, String author, Integer year) {
        //initialize
        Book book = new Book(title, author, year);

        //update
        bookRepository.update(book);

        //return
        System.out.println("Book Update Succesfully : " + book.getTitle());

        
    }

    @Override
    public void delete(Integer id) {

        //Update Data
        boolean succes = bookRepository.delete(id);//true or false
        
        if (succes){
        System.out.println("Book deleted succesfully :" + id);
        }else {
            System.out.println("Book deleted notsuccesfully :" + id);

        }
    }
    
}
