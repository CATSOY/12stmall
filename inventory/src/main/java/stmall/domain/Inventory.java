package stmall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmall.InventoryApplication;
import stmall.domain.StockDecreased;
import stmall.domain.StockUpdated;

@Entity
@Table(name = "Inventory_table")
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productname;

    private String stock;

    @PostUpdate
    public void onPostUpdate() {
        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();

        StockUpdated stockUpdated = new StockUpdated(this);
        stockUpdated.publishAfterCommit();
    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    public static void stockreduce(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        StockDecreased stockDecreased = new StockDecreased(inventory);
        stockDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            StockDecreased stockDecreased = new StockDecreased(inventory);
            stockDecreased.publishAfterCommit();

         });
        */

    }

    public static void stockupdate(Deliverycancled deliverycancled) {
        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        StockUpdated stockUpdated = new StockUpdated(inventory);
        stockUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliverycancled.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            StockUpdated stockUpdated = new StockUpdated(inventory);
            stockUpdated.publishAfterCommit();

         });
        */

    }
}
