package stmall.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stmall.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "productOrders",
    path = "productOrders"
)
public interface ProductOrderRepository
    extends PagingAndSortingRepository<ProductOrder, Long> {}
