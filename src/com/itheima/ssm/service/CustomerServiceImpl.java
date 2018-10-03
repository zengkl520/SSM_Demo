package com.itheima.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.ssm.mapper.CustomerDao;
import com.itheima.ssm.pojo.Customer;
import com.itheima.ssm.pojo.QueryVo;

/**
 * 客户管理 
 * @author zeng
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	//通过四个条件查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo){
		Page<Customer> page = new Page<Customer>();
		
		page.setSize(5);
		vo.setSize(5);
		//判断当前页
		if(null!=vo){
		   if(null!=vo.getPage()){
			  page.setPage(vo.getPage());
			  vo.setStartRow((vo.getPage()-1)*vo.getSize());
		   }
		   if(null!=vo.getCustName()&&!"".equals(vo.getCustName().trim())){
			   vo.setCustName(vo.getCustName().trim());
		   }
		   if(null!=vo.getCustSource()&&!"".equals(vo.getCustSource().trim())){
			   vo.setCustSource(vo.getCustSource().trim());
		   }
		   if(null!=vo.getCustIndustry()&&!"".equals(vo.getCustIndustry().trim())){
			   vo.setCustIndustry(vo.getCustIndustry().trim());
		   }
		   if(null!=vo.getCustLevel()&&!"".equals(vo.getCustLevel().trim())){
			   vo.setCustLevel(vo.getCustLevel().trim());
		   }
		   
		   page.setTotal(customerDao.customerCount(vo));
		   page.setRows(customerDao.selectCustomerListByQueryVo(vo));
		   
		}
		return page;
		
		
		
	}

	@Override
	public Customer selectCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.selectCustomerById(id);
	}

	@Override
	public void updateCustomerById(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.updateCustomerById(customer);
	}

	@Override
	public void deleteCustomerById(Integer id) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomerById(id);
	}
}
