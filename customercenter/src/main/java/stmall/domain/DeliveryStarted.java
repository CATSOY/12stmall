package stmall.domain;

import java.util.*;
import lombok.Data;
import stmall.infra.AbstractEvent;

@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Integer qty;
    private Long ProductID;
    private Long CustomerID;
    private Long orderId;
    private String status;
}
