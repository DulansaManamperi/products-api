package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;

@RestController
@RequestMapping("/products")
public class ProductController {

    //Spring creates the ProductService and hands it over
    @Autowired
    private ProductService productService;

   @GetMapping("/products")
   public List<Product> getProducts() {
       return productService.getAllProducts();
   }

   @GetMapping ("/products/{id}")
    public Product getProductBtId(@PathVariable Long id){
       return productService.getProductById(id).orElse(null);
   }

   @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
       return productService.addProduct(product);
    }

    @DeleteMapping ("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
       productService.deleteProduct(id);
    }

    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name){
       return productService.findByName(name);
    }
}


