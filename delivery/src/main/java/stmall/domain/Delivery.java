package stmall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmall.DeliveryApplication;
import stmall.domain.DeliveryStarted;
import stmall.domain.Deliverycancled;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;

    private Integer qty;

    private String address;

    private Long customerId;

    private Long orderId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        Deliverycancled deliverycancled = new Deliverycancled(this);
        deliverycancled.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void deliveryStart(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        DeliveryStarted deliveryStarted = new DeliveryStarted(delivery);
        deliveryStarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliveryStarted deliveryStarted = new DeliveryStarted(delivery);
            deliveryStarted.publishAfterCommit();

         });
        */

    }

    public static void deliveryCancle(OrderCancled orderCancled) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        Deliverycancled deliverycancled = new Deliverycancled(delivery);
        deliverycancled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancled.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            Deliverycancled deliverycancled = new Deliverycancled(delivery);
            deliverycancled.publishAfterCommit();

         });
        */

    }
}
