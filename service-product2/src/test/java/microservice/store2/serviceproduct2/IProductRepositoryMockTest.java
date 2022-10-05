package microservice.store2.serviceproduct2;

import microservice.store2.serviceproduct2.entity.Category;
import microservice.store2.serviceproduct2.entity.Product;
import microservice.store2.serviceproduct2.repository.IProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class IProductRepositoryMockTest {

    @Autowired
    private IProductRepository productRepository;

    @Test
    public void whenFindCategory_thenReturnListProduct(){

        Product product01 = Product.builder()
                .nameProduct("Computer")
                .category(Category.builder().idCategory(1L).build())
                .descriptionProduct("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("123.99"))
                .status("created")
                .createAt(new Date()).build();
        productRepository.save(product01);

        List<Product> founds = productRepository.findByCategory(product01.getCategory());

        Assertions.assertThat(founds.size()).isEqualTo(3);
    }
}
