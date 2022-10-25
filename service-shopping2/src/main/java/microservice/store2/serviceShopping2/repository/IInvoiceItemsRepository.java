package microservice.store2.serviceShopping2.repository;

import microservice.store2.serviceShopping2.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}
