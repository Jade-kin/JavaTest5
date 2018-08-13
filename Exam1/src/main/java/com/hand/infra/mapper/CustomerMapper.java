package com.hand.infra.mapper;

import com.hand.domain.entity.Customer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface CustomerMapper extends Mapper<Customer> {

    List<Integer> login(Map<String ,Object> map);

    int getIdByName(String firstName);

    Customer getById(Integer id);

    //新增用户
    int addCustomer(Map<String ,Object> map);

    Integer getAddressId(String address);

    //更新用户
    int updateCustomer(Map<String ,Object> map);

    //删除用户
    int deleteCustomer(Integer id);

}