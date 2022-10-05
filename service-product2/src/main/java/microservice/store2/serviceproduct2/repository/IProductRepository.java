package microservice.store2.serviceproduct2.repository;

import microservice.store2.serviceproduct2.entity.Category;
import microservice.store2.serviceproduct2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);
}
