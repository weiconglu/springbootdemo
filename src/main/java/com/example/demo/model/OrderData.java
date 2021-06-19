package com.example.demo.model;

import lombok.Data;

/*

{
	"order_number" : "0000009995",
	"send_time" : "2021/04/01 12:00:00",
	"order_info" : {
		"pre_order_number" : "0000011128",
		"order_apply_type" : "2",
		"project_number" : "0000004377",
		"project_name" : "プロジェクト名(試験名)11",
		"project_short_name" : "プロジェクト名略称（試験名略称）",
		"order_status" : "2",
		"order_status_name" : "本受注",
		"order_number" : "0000009995",
		"order_name" : "サンプル作成業務",
		"order_department_cd" : "21000",
		"contract_cd" : "b10007",
		"order_detail_info" : [ {
			"pre_order_number" : "0000011128",
			"order_detail_number" : 1,
			"sort_number" : 10,
			"order_detail_name" : "サンプル詳細名1",
			"sales_department_cd" : "cs3",
			"business_item_cd" : "1",
			"start_scheduled_ymd" : "20210115",
			"end_scheduled_ymd" : "20211231",
			"estimate_count" : 10.00,
			"unit_name" : "人日",
			"order_price" : 80800,
			"estimate_amount" : 808000,
			"order_detail_division" : [ {
				"pre_order_number" : "0000011128",
				"order_detail_number" : 1,
				"division_number" : 0,
				"division_department_cd" : "21000",
				"stop_flag" : "0",
				"stop_Date" : "",
				"delete_flag" : "0"
			}
			]
		}

		]
	}
}


 */

@Data
public class OrderData {
	private String order_number;
	private String send_time;
	private OrderInfo order_info;
}
