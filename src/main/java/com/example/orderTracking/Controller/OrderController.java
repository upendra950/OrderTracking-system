package com.example.orderTracking.Controller;

import com.example.orderTracking.Entity.Customer;
import com.example.orderTracking.Entity.Order;
import com.example.orderTracking.Repository.CustomerRepo;
import com.example.orderTracking.Repository.OrderRepo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;










@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CustomerRepo customerRepo;

    @PostMapping("/add")
    public void addOrder(@RequestParam("customerId") int customerId,@RequestBody Order order){
        Customer c = customerRepo.findById(customerId).get();
        order.setCustomer(c);
        orderRepo.save(order);
    }

    @GetMapping("/getAll")
    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }
    @DeleteMapping("delete/{id}")
    public void deleteorder(@PathVariable("id") int id){
        try{
        List<Order> o=orderRepo.findByOrderId(id);
        if(o!=null){
            orderRepo.deleteById(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id not found");
        }
    }
    catch(Exception e){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id not found");
    }
    }
}
