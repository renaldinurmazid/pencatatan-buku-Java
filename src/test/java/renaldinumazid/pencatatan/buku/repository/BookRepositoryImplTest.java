package renaldinumazid.pencatatan.buku.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

import renaldinumazid.pencatatan.buku.entity.Book;
import renaldinumazid.pencatatan.buku.repository.impl.BookRepositoryImpl;
import renaldinumazid.pencatatan.buku.util.DatabaseUtil;
public class BookRepositoryImplTest {
    //Datasource
    private static HikariDataSource dataSource;

    //Book repo
    private BookRepository bookRepository;

    @BeforeEach 
    void setupDB(){
        dataSource =  DatabaseUtil.getDataSource();
        bookRepository = new BookRepositoryImpl(dataSource);
    }

    @Test
    void testAddBook(){
        Book book = new Book();

        //set value
        book.setTitle("Cahaya Ilahi");
        book.setAuthor("Pandu Islami");
        book.setYear(2022);

        //add book
        bookRepository.add(book);

}
    @Test
    void testGetAllBook() {
        Book[] list = bookRepository.getAll();
    }

    @AfterEach
        void tearDown(){
            dataSource.close();
        }

}

