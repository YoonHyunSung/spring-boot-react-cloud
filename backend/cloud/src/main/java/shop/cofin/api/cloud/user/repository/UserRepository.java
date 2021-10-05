package shop.cofin.api.cloud.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.cofin.api.cloud.user.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}