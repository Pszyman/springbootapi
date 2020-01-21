package homework.customer.repository;
import homework.customer.models.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String>{
	
	public Customer findByCreditId(int creditid);
}
