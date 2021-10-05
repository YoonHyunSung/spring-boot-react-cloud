package shop.cofin.api.cloud.item.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;
import shop.cofin.api.cloud.board.entity.Article;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data @Component @Entity
@Table(name = "items")
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue
    private Long itemId;

    @Column(name = "item_brand") @NotNull private String itemBrand;
    @Column(name = "item_Name") @NotNull private String itemName;
    @Column(name = "item_color") @NotNull private String itemColor;
    @Column(name = "released_date") @NotNull private String releasedDate;

    @OneToMany(mappedBy = "item")
    private List<Article> articleList = new ArrayList<>();

}
