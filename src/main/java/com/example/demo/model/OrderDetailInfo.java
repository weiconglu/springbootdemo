package com.example.demo.model;

import java.util.List;

import lombok.Data;

@Data
public class OrderDetailInfo {
	private String pre_order_number;
	private Integer order_detail_number;
	private Integer sort_number;
	private String order_detail_name;
	private String sales_department_cd;
	private String business_item_cd;
	private String start_scheduled_ymd;
	private String end_scheduled_ymd;
	private Double estimate_count;
	private String unit_name;
	private Integer order_price;
	private List<OrderDetailDivision> order_detail_division;
}
