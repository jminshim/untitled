package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.StoreApplication;
import untitled.domain.CookFinished;
import untitled.domain.CookStated;
import untitled.domain.Rejeted;

@Entity
@Table(name = "Cook_table")
@Data
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String food;

    @PostPersist
    public void onPostPersist() {
        Rejeted rejeted = new Rejeted(this);
        rejeted.publishAfterCommit();

        CookStated cookStated = new CookStated(this);
        cookStated.publishAfterCommit();

        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    public void comfimYesOrNo(ComfimYesOrNoCommand comfimYesOrNoCommand) {
        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();
    }

    public static void loadOrderInfo(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

    }
}
