package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.RiderApplication;
import untitled.domain.DeliveryComfirmed;
import untitled.domain.FoodPicked;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    @PostPersist
    public void onPostPersist() {
        FoodPicked foodPicked = new FoodPicked(this);
        foodPicked.publishAfterCommit();

        DeliveryComfirmed deliveryComfirmed = new DeliveryComfirmed(this);
        deliveryComfirmed.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void loadDeliveryInfo(CookStated cookStated) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStated.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }

    public static void loadDeliveryInfo(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }
}
