 package renaldinumazid.pencatatan.buku.repository.impl;

 import java.sql.Connection;
 import java.sql.SQLException;
 import java.sql.ResultSet;
 import java.util.ArrayList;
 import java.sql.Statement;
 import java.util.List;

//import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

 ///import com.mysql.cj.xdevapi.Statement;

 import java.sql.PreparedStatement;

 //import com.mysql.cj.Query;
 //import com.mysql.cj.xdevapi.PreparableStatement;

 import renaldinumazid.pencatatan.buku.entity.Book;
 import renaldinumazid.pencatatan.buku.repository.BookRepository;


public class BookRepositoryImpl implements BookRepository{

    private DataSource dataSource;

    public BookRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public void add(Book book) {
     
        //query
        String sql = "INSERT INTO book (title, author, year) VALUES (?,?,?)";

        //excute
        try (Connection connection = dataSource.getConnection(); 
        PreparedStatement statement = connection.prepareStatement(sql)) {
        
            //set value
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());
            // execute
            statement.executeUpdate();

        } catch (SQLException e) {       
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book[] getAll() {
        //query
        String query = "SELECT id, title, author, year FROM book";
        //execute
        try (Connection connection = dataSource.getConnection(); 
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)){
        
            
            //initialize
            List<Book> list = new ArrayList<Book>();

            while (resultSet.next()) {
                //initialize
                Book book = new Book();

                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setYear(resultSet.getInt("year"));

                //add book
                list.add(book);
            }
            //return
            return list.toArray(new Book[] {});

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book getById(Integer id) {

        //query
        String query = "SELECT id, title, author,year FROM book WHERE id = ?";

        //execute
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){

            //set value
            statement.setInt(1, id);

            try(ResultSet resultSet = statement.executeQuery();) {
            
                //initialize
            Book book = new Book();
            
            while (resultSet.next()){
                //set value
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("Author"));
                book.setYear(resultSet.getInt("Year"));
            }

            //return
            return book;
                
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Book book) {
        //query
        String query = "UPDATE book SET title = ?, author = ?, year = ? WHERE id = ?";

        //execute
        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(query)){

            //set value
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());
            statement.setInt(4, book.getId());

            //execute
            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;
            // try(ResultSet resultSet = statement.executeQuery()){
             
            //     if (resultSet.next()){
            //         return true;
            //     }

            //         return false;
            // }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        String query = "DELETE FROM book WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;
            // try(ResultSet resultSet = statement.executeQuery()){
            //     if(resultSet.next()){
            //         return true;
            //     }
            //     return false;
            // }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
