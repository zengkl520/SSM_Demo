package com.itheima.ssm.mapper;

import java.util.List;

import com.itheima.ssm.pojo.BaseDict;

public interface BaseDictDao {

	public List<BaseDict> selectBaseDictListByCode(String code);
}
