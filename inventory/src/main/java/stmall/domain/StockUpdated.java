package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class StockUpdated extends AbstractEvent {

    private Long id;
    private String productname;
    private String stock;

    public StockUpdated(Inventory aggregate) {
        super(aggregate);
    }

    public StockUpdated() {
        super();
    }
}
