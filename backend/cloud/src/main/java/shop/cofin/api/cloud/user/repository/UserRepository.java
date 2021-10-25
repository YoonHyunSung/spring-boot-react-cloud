package shop.cofin.api.cloud.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.cofin.api.cloud.user.domain.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Query(value = "select u.user_name userName, u.user_id userId, u.name, u.email,u.reg_date regDate,u.password " +
            "from users u where u.user_name=:userName and u.password=:password",
            nativeQuery = true)
    Optional<User> login(@Param("userName") String userName, @Param("password") String password);
}
