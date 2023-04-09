package renaldinumazid.pencatatan.buku.view;

import java.util.Scanner;
import renaldinumazid.pencatatan.buku.service.UserService;
import renaldinumazid.pencatatan.buku.entity.User;


public class LoginView {
    private final UserService userService;

    public LoginView(UserService userService) {
        this.userService = userService;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        User user = userService.login(username, password);
        if (user != null) {
            System.out.println("Welcome, " + user.getName() + "!");
            // TODO: show main menu or navigate to next page
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}