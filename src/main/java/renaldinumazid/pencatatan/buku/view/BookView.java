package renaldinumazid.pencatatan.buku.view;

import java.util.Scanner;
import renaldinumazid.pencatatan.buku.util.InputUtil;
import renaldinumazid.pencatatan.buku.entity.Book;
import renaldinumazid.pencatatan.buku.service.BookService;

public class BookView {
    //   Book Service
    private BookService bookService;

    public BookView(BookService bookService){
        this.bookService = bookService;
    }

    //show menu
    public void showMenu(){
        while (true) {
            System.out.println("============ MAIN MENU ===========");
            System.out.println("1.Insert Data");
            System.out.println("2.Update Data");
            System.out.println("3.Show Data");
            System.out.println("4.Show Data By ID");
            System.out.println("5.Delete Data");
            System.out.println("X.Exit");

            String input = InputUtil.input("Choose >");
        
            if(input.equals("1")) {
                insertData();
            }else if (input.equals("3")) {
                showData();
            }else if (input.equals("2")) {
                updateData();
            }else if (input.equals("4")) {
                showDataById();
            }else if(input.equals("X")) {
                break;
            }else if(input.equals("5")) {
                deleteData();
            }else {
                 System.out.println("Option Tidak ada dalam pilihan");
            }
        }
    }

    //insert data
    public void insertData(){
        System.out.println("========== INSERT DATA ===========");

        //get data input
        String title = InputUtil.input("Title");
        String author = InputUtil.input("Author");
        String year = InputUtil.input("Year");
    
        //add data
        bookService.add(title, author, Integer.valueOf(year));
    }
    //update data
    public void updateData() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Masukan ID Book: ");
    
        Integer id = scanner.nextInt();

        Book book = bookService.getById(id);
    
        scanner.nextLine(); // Consume newline left-over
    
        System.out.print("Enter new title: ");
    
        String title = scanner.nextLine();
    
        System.out.print("Enter new author: ");
    
        String author = scanner.nextLine();
    
        System.out.print("Enter new year: ");
    
        Integer year = scanner.nextInt();
    
        bookService.update(id, title, author, year);
    
        System.out.println("Book updated successfully.");
        // System.out.println("======== UPDATE DATA =========");
        // System.out.println("------------------------------");
        // try (Scanner scanner = new Scanner(System.in)) {
        //     System.out.print("Masukan Book ID to Update: ");
        //     int id = scanner.nextInt();
   
        //     // get book by id
        //     Book book = bookService.getById(id);
   
        //     if (book == null) {
        //         System.out.println("Book with ID " + id + " Tidak Tersedia");
        //     } else {
        //         System.out.print("Masukan Nama Buku: ");
        //         String title = scanner.next();
   
        //         System.out.print("Masukan Nama Penulis: ");
        //         String author = scanner.next();
   
        //         System.out.print("Masukan Tahun Terbit: ");
        //         int year = scanner.nextInt();
   
        //         // update book
        //         bookService.update(id, title, author, year);
        //         System.out.println("Book data updated successfully");
        //     }
        // }
    }
    //show data
    public void showData(){

        System.out.println("========== SHOW DATA ===========");

        //show
        bookService.getAll();
    }
    //delete data
    public void deleteData(){

        System.out.println("========== DELETE DATA ===========");

        String id = InputUtil.input("Id");

        //show
        bookService.delete(Integer.valueOf(id));
    }
    //show data byid
    public void showDataById(){

        System.out.println("========== SHOW DATA By ID ===========");

        String id = InputUtil.input("Id");

        //show
        bookService.getById(Integer.valueOf(id));
    }
}
