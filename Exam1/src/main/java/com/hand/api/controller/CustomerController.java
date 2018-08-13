package com.hand.api.controller;

import com.hand.api.service.CustomerService;
import com.hand.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    Cookie cookie = new Cookie("id","0");

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody Map<String ,Object> map) {
        List<Integer> list = null;
        try {
            list = customerService.login(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list.size() == 0) {
            return "Login Fail !";
        }
        return "Login Success !";
    }

    @RequestMapping(value = "/addCustomer",method = RequestMethod.PUT)
    public int addCustomer(@RequestBody Map<String ,Object> map){
        int result = 0;
        try {
            result = customerService.addCustomer(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        cookie.setValue(String.valueOf(result));
        return result;
    }

    @RequestMapping(value = "/updateCustomer",method = RequestMethod.POST)
    public Customer updateCustomer(@RequestBody Map<String ,Object> map){
        map.put("id",cookie.getValue());
        Customer customer = new Customer();
        try {
            customer = customerService.updateCustomer(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    }

    @RequestMapping(value = "/deleteCustomer",method = RequestMethod.DELETE)
    public void deleteCustomer(){
        Integer id = Integer.parseInt(cookie.getValue());
        try {
            int result = customerService.deleteCustomer(id);
            if(result != 1){
                throw new RuntimeException("Delete Fail !");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
