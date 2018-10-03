package com.itheima.ssm.service;

import com.itheima.common.utils.Page;
import com.itheima.ssm.pojo.Customer;
import com.itheima.ssm.pojo.QueryVo;

public interface CustomerService {

	public Page<Customer> selectPageByQueryVo(QueryVo vo);

	public Customer selectCustomerById(Integer id);
	
	//修改客户通过id
		public void updateCustomerById(Customer customer);
		
		//通过id删除用户
		public void deleteCustomerById(Integer id);
}
