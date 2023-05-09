package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Integer qty;
    private Long productId;
    private Long customerId;
    private Long orderId;
    private String status;
}
