package microservice.store2.serviceShopping2.repository;

import microservice.store2.serviceShopping2.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
    public List<Invoice> findByCustomerId(Long customerId );
    public Invoice findByNumberInvoice(String numberInvoice);
}
