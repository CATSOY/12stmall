package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class Deliverycancled extends AbstractEvent {

    private Long id;
    private Long productId;
    private Integer qty;
    private String address;
    private Long customerId;
    private Long orderId;
    private String status;
}
