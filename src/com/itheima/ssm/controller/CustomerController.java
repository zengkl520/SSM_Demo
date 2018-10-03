package com.itheima.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.ssm.pojo.BaseDict;
import com.itheima.ssm.pojo.Customer;
import com.itheima.ssm.pojo.QueryVo;
import com.itheima.ssm.service.BaseDictService;
import com.itheima.ssm.service.CustomerService;

/**
 * 客户管理
 */
@Controller
public class CustomerController {

	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	
	//注入在成员变量上
	@Value("${fromType.code}")
	private String fromTypeCode;
	
	@RequestMapping(value ="/customer/list")
	public String list(QueryVo vo,Model model){
		
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
		
		model.addAttribute("fromType",fromType);
		model.addAttribute("industryType",industryType);
		model.addAttribute("levelType",levelType);
		
		//通过四个条件查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page",page);
		model.addAttribute("custName",vo.getCustName());
		model.addAttribute("custSource",vo.getCustSource());
		model.addAttribute("custIndustry",vo.getCustIndustry());
		model.addAttribute("custLevel",vo.getCustLevel());
		
		
		return "customer";
	}
	
	
	//去修改界面
	@RequestMapping(value ="/customer/edit.action")
	public @ResponseBody
	Customer edit(Integer id){
		return customerService.selectCustomerById(id);
		
	}
	
	//更新用户
	@RequestMapping(value ="/customer/update.action")
	public @ResponseBody
	String update(Customer customer){
		customerService.updateCustomerById(customer);
		return "OK";
		
	}
	
	//更新用户
		@RequestMapping(value ="/customer/delete.action")
		public @ResponseBody
		String delete(Integer id){
		//	customerService.updateCustomerById(customer);
			customerService.deleteCustomerById(id);
			return "OK";
			
		}
	
	
	
	
}
