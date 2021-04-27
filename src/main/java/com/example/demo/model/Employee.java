package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Builder;
import lombok.Data;

@TableName(value = "tb_t_employee") // <------ 指定实体关联的数据库表
@Data // <------ lombok 注解
@Builder
//@ToString(exclude = {"password","salary"}) // <------ 属性排除，不在toString()方法中打印
public class Employee {

	/*
	 * 定义JavaBean中成员变量时使用的数据类型：使用包装类型 因为每个基本数据类型都有一个默认值： int --> 0 boolean --> false
	 */

	@TableId(value = "id", type = IdType.AUTO) // <------主键注解，指定主键生成策略
	private Integer id;

	/*
	 * value 数据库字段值
	 * 
	 * • 当  com.baomidou.mybatisplus.core.MybatisConfiguration.mapUnderscoreToCamelCase 为  true 时,(mp下默认是true,mybatis默认是false), 
	 * 数据库字段值.replace("_","").toUpperCase() ==  实体属性名.toUpperCase()
	 *  • 当 com.baomidou.mybatisplus.core.MybatisConfiguration.mapUnderscoreToCamelCase 为 false 时, 
	 *  数据库字段值.toUpperCase() == 实体属性名.toUpperCase()
	 * 
	 */
	@TableField(value = "last_name") // <------ 字段注解(非主键)
	private String lastName;

//	@TableField(exist = false) // <------ exist属性标识是否为数据库表字段，默认 true 存在，false 不存在
//	private String password;
	
//	@TableField(exist = false)
//	@Setter(value = AccessLevel.NONE) // <------ 不生成相应的set get 方法
//	@Getter(value = AccessLevel.NONE)
//	private Double salary;

	/*
	 * 默认会为各个字段添加@TableField注解，故一般只需要标识出主键及不属于数据表的字段即可
	 */
	private String email;
	private Integer gender;
	private Integer age;

}
