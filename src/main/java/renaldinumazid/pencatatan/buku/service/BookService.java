package renaldinumazid.pencatatan.buku.service;

import renaldinumazid.pencatatan.buku.entity.Book;

public interface BookService {
    //add
    public void add(String title, String author, Integer year);    
    //getAll
    public void getAll();
    //get by id
    public Book getById(Integer id);
    //update
    public void update(Integer id,String title,String author,Integer year);
    //delete
    public void delete(Integer id);
}

