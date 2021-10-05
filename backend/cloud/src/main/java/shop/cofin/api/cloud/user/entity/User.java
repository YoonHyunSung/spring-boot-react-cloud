package shop.cofin.api.cloud.user.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;
import shop.cofin.api.cloud.board.entity.Article;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data @Component @Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue
    private long userId;
    @Column (name = "user_name") @NotNull private String userName;
    @Column @NotNull private String password;
    @Column @NotNull private String name;
    @Column @NotNull private String email;
    @Column(name = "reg_date") @NotNull private String regDate;
    @OneToMany(mappedBy = "user")
    private List<Article> articleList = new ArrayList<>();
}
