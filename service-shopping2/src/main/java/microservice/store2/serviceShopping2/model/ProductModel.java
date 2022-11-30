package microservice.store2.serviceShopping2.model;

import lombok.Data;

@Data
public class ProductModel {

    private Long id;
    private String name;
    private Double stock;
    private String description;
    private Double price;
    private String status;
    //private Date createAt;

    private CategoryModel category;
}
