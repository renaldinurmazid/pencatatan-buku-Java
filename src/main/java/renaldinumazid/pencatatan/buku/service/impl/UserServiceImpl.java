package renaldinumazid.pencatatan.buku.service.impl;

import renaldinumazid.pencatatan.buku.repository.UserRepository;
import renaldinumazid.pencatatan.buku.service.UserService;
import renaldinumazid.pencatatan.buku.entity.User;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
