package ma.mthymleaf.customerfrontthymleaf.web;
import lombok.AllArgsConstructor;
import ma.mthymleaf.customerfrontthymleaf.entities.Customer;
import ma.mthymleaf.customerfrontthymleaf.repository.CustomerRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerController {
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public String customers(Model model){
        List<Customer> customerList=customerRepository.findAll();
        model.addAttribute("customersList",customerList);
        return "customersView";
    }

    @GetMapping("/products")
    public String products(Model model){
        return "products";
    }

    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
