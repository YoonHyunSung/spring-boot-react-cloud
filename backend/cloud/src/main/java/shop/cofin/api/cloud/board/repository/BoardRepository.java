package shop.cofin.api.cloud.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.cofin.api.cloud.board.entity.Article;

@Repository
public interface BoardRepository extends JpaRepository<Article, Long> {
}
