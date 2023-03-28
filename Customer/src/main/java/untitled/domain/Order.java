package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.CustomerApplication;
import untitled.domain.OrderCanceled;
import untitled.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String food;

    private String status;

    private String address;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = CustomerApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void updateStatus(CookStated cookStated) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStated.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void updateStatus(DeliveryComfirmed deliveryComfirmed) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryComfirmed.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
