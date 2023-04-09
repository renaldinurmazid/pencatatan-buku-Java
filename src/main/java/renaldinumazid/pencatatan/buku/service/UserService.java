package renaldinumazid.pencatatan.buku.service;

import renaldinumazid.pencatatan.buku.entity.User;

public interface UserService {
    User login(String username, String password);
}
