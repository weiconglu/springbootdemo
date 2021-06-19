package com.example.demo.model;

import java.util.List;

import lombok.Data;

@Data
public class OrderInfo {
	private String pre_order_number;
	private String order_apply_type;
	private String project_number;
	private String project_name;
	private String project_short_name;
	private String order_status;
	private String order_status_name;
	private String order_number;
	private String order_name;
	private String order_department_cd;
	private String contract_cd;
	private List<OrderDetailInfo> order_detail_info;
}
