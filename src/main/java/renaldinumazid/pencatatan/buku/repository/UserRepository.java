package renaldinumazid.pencatatan.buku.repository;

import renaldinumazid.pencatatan.buku.entity.User;

public interface UserRepository {
    User findByUsername(String username);
}
