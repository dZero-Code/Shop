package kr.co.shop.shop.dto;

import lombok.Data;

@Data
public class ProductDto {
	private String productNo;
	private String categoryCode;
	private String productName;
	private int productPrice;
	private int productSale;
	private int hitCnt;
	private int status;
	private String createdDatetime;
	
	private ProductPhotoDto productPhoto;
}
