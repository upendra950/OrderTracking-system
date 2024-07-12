package com.example.orderTracking.Controller;

import com.example.orderTracking.Entity.Product;
import com.example.orderTracking.Repository.ProductRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        productRepo.save(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
}
