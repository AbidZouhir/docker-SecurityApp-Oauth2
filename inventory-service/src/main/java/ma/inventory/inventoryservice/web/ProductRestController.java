package ma.inventory.inventoryservice.web;

import lombok.AllArgsConstructor;
import ma.inventory.inventoryservice.entities.Product;
import ma.inventory.inventoryservice.repository.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductRestController {
    private ProductRepository productRepository;
    @GetMapping("/products")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<Product> products(){
        return productRepository.findAll();
    }
}
