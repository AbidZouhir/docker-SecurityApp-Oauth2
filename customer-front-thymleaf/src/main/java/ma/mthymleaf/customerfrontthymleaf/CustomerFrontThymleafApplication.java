package ma.mthymleaf.customerfrontthymleaf;

import ma.mthymleaf.customerfrontthymleaf.entities.Customer;
import ma.mthymleaf.customerfrontthymleaf.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerFrontThymleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerFrontThymleafApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("ilyass").email("ilyass1@gmail.com").build());
            customerRepository.save(Customer.builder().name("khalid").email("khalid1@gmail.com").build());
            customerRepository.save(Customer.builder().name("taha").email("taha1@gmail.com").build());
            customerRepository.save(Customer.builder().name("mourad").email("mourad1@gmail.com").build());
        };
    }

}
