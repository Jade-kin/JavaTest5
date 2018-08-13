package com.hand.api.service.impl;

import com.hand.api.service.CustomerService;
import com.hand.domain.entity.Customer;
import com.hand.infra.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Integer> login(Map<String ,Object> map) throws Exception {
        return customerMapper.login(map);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addCustomer(Map<String ,Object> map) throws Exception {
        String address = map.get("address").toString();
        Integer addressId = customerMapper.getAddressId(address);
        if(addressId != null){
            map.put("addressId",addressId);
        }else {
            throw new RuntimeException("Address not Exist !");
        }
        int result = customerMapper.addCustomer(map);
        if(result != 1){
            throw new RuntimeException("Insert Fail !");
        }
        return customerMapper.getIdByName(map.get("firstName").toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Customer updateCustomer(Map<String ,Object> map) throws Exception {
        String address = map.get("address").toString();
        Integer addressId = customerMapper.getAddressId(address);
        if(addressId != null){
            map.put("addressId",addressId);
            map.put("lastUpdate",new Date());
        }else {
            throw new RuntimeException("Address not Exist !");
        }
        int result = customerMapper.updateCustomer(map);
        if(result != 1){
            throw new RuntimeException("Update Fail !");
        }
        return customerMapper.getById(Integer.parseInt(map.get("id").toString()));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteCustomer(Integer id) throws Exception {
        return customerMapper.deleteCustomer(id);
    }
}
