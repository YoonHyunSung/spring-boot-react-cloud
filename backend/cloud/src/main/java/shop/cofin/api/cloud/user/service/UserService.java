package shop.cofin.api.cloud.user.service;

import shop.cofin.api.cloud.user.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(long userId);
    Optional<User> login(String userName, String password);
}
