package stmall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmall.OrderApplication;
import stmall.domain.OrderCancled;
import stmall.domain.OrderPlaced;

@Entity
@Table(name = "ProductOrder_table")
@Data
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;

    private Long customerId;

    private Integer qty;

    private String address;

    private String productname;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        OrderCancled orderCancled = new OrderCancled(this);
        orderCancled.publishAfterCommit();
    }

    public static ProductOrderRepository repository() {
        ProductOrderRepository productOrderRepository = OrderApplication.applicationContext.getBean(
            ProductOrderRepository.class
        );
        return productOrderRepository;
    }

    public static void notifyToWaitingUser(StockUpdated stockUpdated) {
        /** Example 1:  new item 
        ProductOrder productOrder = new ProductOrder();
        repository().save(productOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(stockUpdated.get???()).ifPresent(productOrder->{
            
            productOrder // do something
            repository().save(productOrder);


         });
        */

    }

    public static void updateStatus(Deliverycancled deliverycancled) {
        /** Example 1:  new item 
        ProductOrder productOrder = new ProductOrder();
        repository().save(productOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliverycancled.get???()).ifPresent(productOrder->{
            
            productOrder // do something
            repository().save(productOrder);


         });
        */

    }

    public static void updateStatus(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        ProductOrder productOrder = new ProductOrder();
        repository().save(productOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(productOrder->{
            
            productOrder // do something
            repository().save(productOrder);


         });
        */

    }
}
