package com.hand.api.service;

import com.hand.domain.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    List<Integer> login(Map<String ,Object> map) throws Exception;

    //新增用户
    int addCustomer(Map<String ,Object> map) throws Exception;

    //更新用户
    Customer updateCustomer(Map<String ,Object> map) throws Exception;

    //删除用户
    int deleteCustomer(Integer id) throws Exception;
}
