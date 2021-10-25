package shop.cofin.api.cloud.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.cofin.api.cloud.user.domain.User;
import shop.cofin.api.cloud.user.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;


    @Override
    public Optional<User> findById(long userid) {
        return userRepository.findById(userid);
    }

    @Override
    public Optional<User> login(String userName, String password) {
        return userRepository.login(userName, password);
    }
}
