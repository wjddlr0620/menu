package coffee;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Menu_table")
public class Menu {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY ) //변경 GenerationType.AUTO -> IDENTITY  로 중복값만 안생기게함. auto 채번은 db에서 autoincrease로 동작함
    private Long menuId;
    private String menuName;
    private Long price;
    private String abailable;

    @PostPersist
    public void onPostPersist(){
        MenuRegisted menuRegisted = new MenuRegisted();
        BeanUtils.copyProperties(this, menuRegisted);
        menuRegisted.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        MenuUpdate menuUpdate = new MenuUpdate();
        BeanUtils.copyProperties(this, menuUpdate);
        menuUpdate.publishAfterCommit();


    }


    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
    public String getAbailable() {
        return abailable;
    }

    public void setAbailable(String abailable) {
        this.abailable = abailable;
    }




}
