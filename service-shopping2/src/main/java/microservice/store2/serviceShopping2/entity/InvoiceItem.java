package microservice.store2.serviceShopping2.entity;

import lombok.Data;
import microservice.store2.serviceShopping2.model.ProductModel;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Data
@Table(name = "invoce_items")
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive(message = "El stock debe ser mayor que cero")
    private Double quantity;
    private Double  price;

    @Column(name = "product_id")
    private Long productId;


    @Transient  //Esto lo que hace es decirle que tenga presente este valor pero no lo pona en la BD's
    private Double subTotal;

    @Transient
    private ProductModel productModel;

    public Double getSubTotal(){
        if (this.price >0  && this.quantity >0 ){
            return this.quantity * this.price;
        }else {
            return (double) 0;
        }
    }
    public InvoiceItem(){
        this.quantity=(double) 0;
        this.price=(double) 0;

    }

}
