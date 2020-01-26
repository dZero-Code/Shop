package kr.co.shop.shop.dto;

import lombok.Data;

@Data
public class ProductOptDto {
	private String productCode;
	private String productNo;
	private String productSize;
	private String productColor;
	private int inventory;			// 재고량
	private int surcharge;			// 추가비용
}
