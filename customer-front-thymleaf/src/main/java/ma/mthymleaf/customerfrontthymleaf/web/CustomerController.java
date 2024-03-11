package ma.mthymleaf.customerfrontthymleaf.web;
import lombok.AllArgsConstructor;
import ma.mthymleaf.customerfrontthymleaf.entities.Customer;
import ma.mthymleaf.customerfrontthymleaf.repository.CustomerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class CustomerController {
    private CustomerRepository customerRepository;
    private ClientRegistrationRepository clientRegistrationRepository;

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @ResponseBody
    public Authentication authentication(Authentication authentication){
        return authentication;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/notAuthorized")
    public String notAuthorized(){

        return "notAuthorized";
    }
    @GetMapping("/oauth2Login")
    public String oauth2Login(Model model){
        String authorizationRequestBaseUri = "oauth2/authorization";
        Map<String, String> oauth2AuthenticationUrls = new HashMap();
        Iterable<ClientRegistration> clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;;
        clientRegistrations.forEach(registration ->{
            oauth2AuthenticationUrls.put(registration.getClientName(),
                    authorizationRequestBaseUri + "/" + registration.getRegistrationId());
        });

        oauth2AuthenticationUrls.forEach(
                (key,value)-> System.out.println(key + "||||" + value)
        );
        model.addAttribute("urls", oauth2AuthenticationUrls);
        return "oauth2Login";
    }
}

