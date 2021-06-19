package com.example.demo.model;

import lombok.Data;

@Data
public class OrderDetailDivision {
	private String pre_order_number;
	private Integer order_detail_number;
	private Integer division_number;
	private String division_department_cd;
	private String stop_flag;
	private String stop_Date;
	private String delete_flag;
}
