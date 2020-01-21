package homework.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import homework.product.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

}
