package com.example.orderTracking.Controller;

import com.example.orderTracking.Entity.Order;
import com.example.orderTracking.Entity.OrderItem;
import com.example.orderTracking.Entity.OrderItemId;
import com.example.orderTracking.Entity.Product;
import com.example.orderTracking.Repository.OrderItemRepo;
import com.example.orderTracking.Repository.OrderRepo;
import com.example.orderTracking.Repository.ProductRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;










@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
    @Autowired
    OrderItemRepo orderItemRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ProductRepo productRepo;

    @PostMapping("/add")
    public void addOrderItem(@RequestParam("orderId") int orderId,@RequestParam("prodId") int prodId,@RequestBody OrderItem orderItem){
        Order order = orderRepo.findById(orderId).get();
        Product product = productRepo.findById(prodId).get();
        OrderItemId orderItemId = new OrderItemId(order, product);
        // OrderItemId orderItemId=new OrderItemId();
        orderItem.setId(orderItemId);
        orderItemRepo.save(orderItem);
    }
    

    @GetMapping("/getAll")
    public List<OrderItem> getAllOrderItems(){
        return orderItemRepo.findAll();
    }
    // @GetMapping("/getAll/{orderId}/{proId}")
    // public List<OrderItem> getAllOrderItems(@PathVariable("orderId") int orderId,@PathVariable("proId") int proId){
    //     List<OrderItem> orderItems=orderItemRepo.findByIdOrderItemIdOrderOrderIdAndIdOrderItemIdProductProId(orderId,proId);
       
    //     return orderItems;
    // }

    @DeleteMapping("delete/{id}")
    public void deleteOrderItem(@PathVariable("id") int id){
        // List<OrderItem> orderItems=orderItemRepo.findById(id);
    }


}
