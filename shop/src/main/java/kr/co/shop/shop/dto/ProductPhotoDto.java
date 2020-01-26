package kr.co.shop.shop.dto;

import lombok.Data;

@Data
public class ProductPhotoDto {
	private int idx;
	private String productNo;
	private String photoName;
	private String photoPath;
	private String regPlace;
}
