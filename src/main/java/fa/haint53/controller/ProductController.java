package fa.haint53.controller;


import fa.haint53.entities.Product;
import fa.haint53.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;


    //Post mapping to create product.
    @RequestMapping(method = RequestMethod.POST, value = "")
    public HttpHeaders createProduct(@RequestBody Product productParam) {
        Product product = this.productRepository.insert(productParam);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(linkTo(ProductController.class).slash(product.getId()).toUri());
        return httpHeaders;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    Optional<Product> showProduct(@PathVariable("id") String id) {
        Optional<Product> product
                = productRepository.findById(id);
        return product;
    }

    @RequestMapping(method = RequestMethod.GET, value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<Product> showProduct() {
        List<Product> products = productRepository.findAll();
        return products;
    }

}
