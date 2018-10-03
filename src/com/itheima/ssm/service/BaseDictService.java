package com.itheima.ssm.service;

import java.util.List;

import com.itheima.ssm.pojo.BaseDict;

public interface BaseDictService {

	public List<BaseDict> selectBaseDictListByCode(String code);
}
