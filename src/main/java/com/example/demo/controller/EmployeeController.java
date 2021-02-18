package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.JsonResult;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeMapper employeeMapper;

	@ApiOperation(value = "插入200条测试数据到数据表中") // <------ API中描述摘要
	@GetMapping("insertTestData")
	public JsonResult insertTestData() {

		Employee employee = Employee.builder().build();
		String gender = null;
		Integer age = null;

		Random random = new Random(); // <------ 随机数生成类
		for (int i = 1; i < 201; i++) {
			gender = Integer.toString(random.nextInt(2)); // <------ 使用random随机生成 0或1
			age = (int) (Math.random() * 100 + 1); // <------ 使用Math.random()方法生成一个1~100的随机数

			employee.setLastName("Tom" + i);
			employee.setEmail("tom" + i + "@test.com");
			employee.setGender(gender);
			employee.setAge(age);

			employeeMapper.insert(employee);
		}

		return JsonResult.ok();
	}

	@PostMapping("add")
	public JsonResult add(@ApiParam(value = "姓名", example = "张三") @RequestParam("lastName") String lastName,
			@ApiParam(value = "邮箱", example = "zs@test.com") @RequestParam("email") String email,
			@ApiParam(value = "性别", example = "1") @RequestParam("gender") String gender,
			@ApiParam(value = "年龄", example = "18") @RequestParam("age") Integer age) {

		// 使用lombok的builder()来生成对象
		Employee employee = Employee.builder().lastName(lastName).email(email).gender(gender).age(age).build();
//		employee.setLastName(lastName);
//		employee.setEmail(email);
//		employee.setGender(gender);
//		employee.setAge(age);

//		employee.setPassword("******"); // <------ 表中不存在的字段

		System.out.println("employee id -> " + employee.getId());
		Integer resultInteger = employeeMapper.insert(employee); // <------ mybatisplus自动将主键值回写到实体类
		System.out.println("employee id -> " + employee.getId());

		if (resultInteger == 1) {
			return JsonResult.ok();
		}

		return JsonResult.error();
	}

	@PostMapping("update")
	public JsonResult update(@ApiParam(value = "姓名", example = "张三") @RequestParam("lastName") String lastName,
			@ApiParam(value = "邮箱", example = "zs@test.com") @RequestParam("email") String email,
			@ApiParam(value = "性别", example = "1") @RequestParam("gender") String gender,
			@ApiParam(value = "年龄", example = "18") @RequestParam("age") Integer age) {

		Employee employee = Employee.builder().lastName(lastName).email(email).gender(gender).age(age).build();
		employee.setId(1); // <------ 指定要更新的实体在数据表中的id

		System.out.println("employee id -> " + employee.getId());
		Integer resultInteger = employeeMapper.updateById(employee); // <------ updateById 更新
		System.out.println("employee id -> " + employee.getId());

		if (resultInteger == 1) {
			return JsonResult.ok();
		}

		return JsonResult.error();
	}

	@GetMapping("select/{id}")
	public JsonResult select(@PathVariable Integer id) {

		Employee employee = employeeMapper.selectById(id);
		if (null != employee) {
			JsonResult result = JsonResult.ok();
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("employee entity", employee);
			return result.setResult(resultMap);
		}

		return JsonResult.error();
	}

	@ApiOperation(value = "根据Map来查询")
	@GetMapping("selectByMap")
	public JsonResult selectByMap() {

		Map<String, Object> map = new HashMap<String, Object>(); // <------ 表字段 map 对象
		map.put("last_name", "Tom2"); // <------ 这里要将数据表中的字段名put进去，而不是实体类中的属性名

		List<Employee> list = employeeMapper.selectByMap(map);
		if (list.size() != 0) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("Employees", list);

			return JsonResult.ok().setResult(resultMap);
		}

		return JsonResult.error();
	}

	@ApiOperation(value = "分页查询示例")
	@PostMapping("selectPage")
	public JsonResult selectPage(@RequestParam Integer pageNum, @RequestParam Integer size) {

		// 分页查询，必须先在MybatisPlusConfig.java类中添加分页插件的配置后才能使用
		List<Employee> list = employeeMapper.selectPage(new Page<Employee>(pageNum, size), null)
				.getRecords();

		if (list.size() != 0) {
			
			// 数据库中总记录数查询出来返回
			Integer totalSize = employeeMapper.selectCount(null);
			
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("totalSize", totalSize);
			resultMap.put("Employees", list);

			return JsonResult.ok().setResult(resultMap);
		}

		return JsonResult.error();
	}

	@GetMapping("delete")
	public JsonResult delete() {
//		Integer integerResult = employeeMapper.deleteById(1); // <------ 根据id删除

		Map<String, Object> map = new HashMap<String, Object>(); // <------ 表字段 map 对象
		map.put("last_name", "Tom3"); // <------ 这里要将数据表中的字段名put进去，而不是实体类中的属性名

		Integer integerResult = employeeMapper.deleteByMap(map);
		if (integerResult != 0) {
			return JsonResult.ok("DELETED SUCESS");
		}

		return JsonResult.error();
	}
	
	@GetMapping("deleteAll")
	public JsonResult deleteAll() {
		
		employeeMapper.delete(new QueryWrapper<Employee>().last("")); // <------ 传入个null或者传入这个就是：DELETE FROM tb_t_employee
		
		return JsonResult.ok();
	}

	@ApiOperation(value = "分页查询第pageNum页的size个数据，tb_t_employee表中姓名中含有Tom”且年龄在18~50之间的男性")
	@PostMapping("test01")
	public JsonResult test01(@RequestParam Integer pageNum, @RequestParam Integer size) {

		// SELECT * FROM tb_t_employee WHERE last_name LIKE '%Tom%' AND gender='1' AND
		// age BETWEEN 18 AND 50 limit (pageNum -1)*size,size

		QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>();
		queryWrapper.like("last_name", "Tom").eq("gender", "1").between("age", 18, 50); // <------
																						// 条件构造器，注意方法中的column是数据库表中的字段
		List<Employee> list = employeeMapper.selectPage(new Page<Employee>((pageNum - 1) * size, size), queryWrapper)
				.getRecords(); // <------查询时传入queryWrapper条件构造器对象

		if (list.size() != 0) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("Employees", list);

			return JsonResult.ok().setResult(resultMap);
		}

		return JsonResult.error();
	}

	@ApiOperation(value = "根据性别进行查询")
	@PostMapping("test02")
	public JsonResult test02(@ApiParam(allowableValues = "0,1", required = true) @RequestParam String gender) {

		// SELECT * FROM tb_t_employee WHERE gender='1'

		QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>();
		queryWrapper.eq("gender", gender); // <------ 条件构造器 or() 与 orNew()比较 后者会重新将生成的条件括起来，这里不再示例
		List<Employee> list = employeeMapper.selectList(queryWrapper); // <------ 传入条件构造器
		if (list.size() != 0) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("Employees", list);

			return JsonResult.ok().setResult(resultMap);
		}

		return JsonResult.error();
	}

}
