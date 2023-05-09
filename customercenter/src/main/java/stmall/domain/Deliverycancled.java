package stmall.domain;

import java.util.*;
import lombok.Data;
import stmall.infra.AbstractEvent;

@Data
public class Deliverycancled extends AbstractEvent {

    private Long id;
    private Long ProductID;
    private Integer qty;
    private String address;
    private Long CustomerID;
    private Long orderId;
    private String status;
}
