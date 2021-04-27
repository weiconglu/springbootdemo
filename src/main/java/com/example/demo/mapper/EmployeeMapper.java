package com.example.demo.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.Employee;

public interface EmployeeMapper extends BaseMapper<Employee> {

	Integer updateByMap(Map<String, Object> map);

}
