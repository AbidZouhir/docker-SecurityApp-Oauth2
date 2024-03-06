package ma.mthymleaf.customerfrontthymleaf.web;
import lombok.AllArgsConstructor;
import ma.mthymleaf.customerfrontthymleaf.entities.Customer;
import ma.mthymleaf.customerfrontthymleaf.repository.CustomerRepository;
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
}
