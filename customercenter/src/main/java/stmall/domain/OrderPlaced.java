package stmall.domain;

import java.util.*;
import lombok.Data;
import stmall.infra.AbstractEvent;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Long productID;
    private Long CustomerID;
    private Integer qty;
    private String address;
    private String productname;
}
