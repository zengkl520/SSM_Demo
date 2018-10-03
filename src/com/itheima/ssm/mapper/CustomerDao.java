package com.itheima.ssm.mapper;

import java.util.List;

import com.itheima.ssm.pojo.BaseDict;
import com.itheima.ssm.pojo.Customer;
import com.itheima.ssm.pojo.QueryVo;

public interface CustomerDao {

	//总条数
	public Integer customerCount(QueryVo vo);
	
	//结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	
	//通过id查询用户
	public Customer selectCustomerById(Integer id);
	
	//修改客户通过id
	public void updateCustomerById(Customer customer);
	
	//通过id删除用户
	public void deleteCustomerById(Integer id);
}
