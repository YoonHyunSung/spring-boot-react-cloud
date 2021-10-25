package shop.cofin.api.cloud.user.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Component;
import shop.cofin.api.cloud.board.entity.Article;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Component @Table(name = "users") @Proxy(lazy = false)
@Entity
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name = "user_name") @NotNull private String userName;
    @Column @NotNull private String password;
    @Column @NotNull private String name;
    @Column @NotNull private String email;
    @Column(name = "reg_date") @NotNull private String regDate;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Article> articleList = new ArrayList<>();
}
