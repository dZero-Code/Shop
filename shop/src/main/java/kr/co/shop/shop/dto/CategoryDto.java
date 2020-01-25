package kr.co.shop.shop.dto;

import lombok.Data;

@Data
public class CategoryDto {
	private String categoryCode;		// 분류코드
	private String category1;			// 대분류
	private String category2;			// 중분류
}
