package microservice.store2.serviceShopping2.service;

import lombok.extern.slf4j.Slf4j;
import microservice.store2.serviceShopping2.client.ICustomerClient;
import microservice.store2.serviceShopping2.client.IProductClient;
import microservice.store2.serviceShopping2.entity.Invoice;
import microservice.store2.serviceShopping2.entity.InvoiceItem;
import microservice.store2.serviceShopping2.model.CustomerModel;
import microservice.store2.serviceShopping2.model.ProductModel;
import microservice.store2.serviceShopping2.repository.IInvoiceItemsRepository;
import microservice.store2.serviceShopping2.repository.IInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InvoiceServiceImpl implements IInvoiceService {

        @Autowired
        IInvoiceRepository invoiceRepository;

        @Autowired
        IInvoiceItemsRepository invoiceItemsRepository;

        @Autowired
        ICustomerClient iCustomerClient;

        @Autowired
        IProductClient iProductClient;

        @Override
        public List<Invoice> findInvoiceAll() {
            return  invoiceRepository.findAll();
        }


        @Override
        public Invoice createInvoice(Invoice invoice) {
            Invoice invoiceDB = invoiceRepository.findByNumberInvoice ( invoice.getNumberInvoice () );
            if (invoiceDB !=null){
                return  invoiceDB;
            }
            invoice.setState("CREATED");
            invoiceDB = invoiceRepository.save(invoice);
            invoiceDB.getItems().forEach( invoiceItem ->  {
                iProductClient.updateStockProduct(invoiceItem.getProductId(), invoiceItem.getQuantity() * -1);
            });

            return invoiceDB;
        }


        @Override
        public Invoice updateInvoice(Invoice invoice) {
            Invoice invoiceDB = getInvoice(invoice.getId());
            if (invoiceDB == null){
                return  null;
            }
            invoiceDB.setCustomerId(invoice.getCustomerId());
            invoiceDB.setDescription(invoice.getDescription());
            invoiceDB.setNumberInvoice(invoice.getNumberInvoice());
            invoiceDB.getItems().clear();
            invoiceDB.setItems(invoice.getItems());
            return invoiceRepository.save(invoiceDB);
        }


        @Override
        public Invoice deleteInvoice(Invoice invoice) {
            Invoice invoiceDB = getInvoice(invoice.getId());
            if (invoiceDB == null){
                return  null;
            }
            invoiceDB.setState("DELETED");
            return invoiceRepository.save(invoiceDB);
        }

        @Override
        public Invoice getInvoice(Long id) {
           Invoice invoice =  invoiceRepository.findById(id).orElse(null);
           if(null != invoice){
               CustomerModel customerModel = iCustomerClient.getCustomers(invoice.getCustomerId()).getBody();
               invoice.setCustomerModel(customerModel);
               List<InvoiceItem> listItems = invoice.getItems().stream().map(invoiceItem -> {
                   ProductModel productModel = iProductClient.getProduct(invoiceItem.getProductId()).getBody();
                   invoiceItem.setProductModel(productModel);
                   return invoiceItem;
               }).collect(Collectors.toList());
               invoice.setItems(listItems);
           }
               return invoice;
        }
}
