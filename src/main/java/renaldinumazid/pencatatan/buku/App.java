package renaldinumazid.pencatatan.buku;

import java.sql.SQLException;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

import javax.sql.DataSource;

// import renaldinumazid.pencatatan.buku.repository.BookRepository;
// import renaldinumazid.pencatatan.buku.service.BookService;

// import renaldinumazid.pencatatan.buku.repository.impl.BookRepositoryImpl;
// import renaldinumazid.pencatatan.buku.service.impl.BookServiceImpl;
import renaldinumazid.pencatatan.buku.util.DatabaseUtil;
//import renaldinumazid.pencatatan.buku.view.BookView;

//import renaldinumazid.pencatatan.buku.entity.User;
import renaldinumazid.pencatatan.buku.repository.UserRepository;
import renaldinumazid.pencatatan.buku.repository.impl.UserRepositoryImpl;
import renaldinumazid.pencatatan.buku.service.UserService;
import renaldinumazid.pencatatan.buku.service.impl.UserServiceImpl;
import renaldinumazid.pencatatan.buku.view.LoginView;

public class App 
{
    public static void main( String[] args ) throws SQLException
        {
    
        // datasource
        DataSource dataSource = DatabaseUtil.getDataSource();

        //set data
        // BookRepository bookRepository = new BookRepositoryImpl(dataSource);
        // BookService bookService = new BookServiceImpl(bookRepository);
        UserRepository userRepository = new UserRepositoryImpl(dataSource.getConnection());
        UserService userService = new UserServiceImpl(userRepository);
        LoginView loginView = new LoginView(userService);

        
        //view
        //BookView bookView =  new BookView(bookService);

        //show view
        //bookView.showMenu();
        loginView.show();
    }
    }
