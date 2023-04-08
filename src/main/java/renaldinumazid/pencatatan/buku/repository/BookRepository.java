package renaldinumazid.pencatatan.buku.repository;

import renaldinumazid.pencatatan.buku.entity.Book;

public interface BookRepository {
    
    //add
    public void add(Book book);
    //Get all
    public Book[] getAll();
    //Get by id
    public Book getById(Integer id);
    //update
    public boolean update(Book book);
    //Delete
    public boolean delete(Integer id);


}
