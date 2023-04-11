package renaldinumazid.pencatatan.buku;

import java.sql.SQLException;

import javax.sql.DataSource;

import renaldinumazid.pencatatan.buku.repository.BookRepository;
import renaldinumazid.pencatatan.buku.service.BookService;

import renaldinumazid.pencatatan.buku.repository.impl.BookRepositoryImpl;
import renaldinumazid.pencatatan.buku.service.impl.BookServiceImpl;
import renaldinumazid.pencatatan.buku.util.DatabaseUtil;
import renaldinumazid.pencatatan.buku.view.BookView;
public class App 
{
    public static void main( String[] args ) throws SQLException
        {
    
        // datasource
        DataSource dataSource = DatabaseUtil.getDataSource();

        //set data
        BookRepository bookRepository = new BookRepositoryImpl(dataSource);
        BookService bookService = new BookServiceImpl(bookRepository);
        

        
        //view
        BookView bookView =  new BookView(bookService);

        //show view
        bookView.showMenu();
    }
    }
