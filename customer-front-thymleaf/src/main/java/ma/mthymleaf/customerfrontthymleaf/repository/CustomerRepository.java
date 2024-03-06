package ma.mthymleaf.customerfrontthymleaf.repository;

import ma.mthymleaf.customerfrontthymleaf.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
