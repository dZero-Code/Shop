package kr.co.shop.shop.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.shop.shop.dto.CategoryDto;
import kr.co.shop.shop.dto.ColorDto;
import kr.co.shop.shop.dto.ProductDto;
import kr.co.shop.shop.dto.ProductOptDto;

public interface ProductService {
	// 카테고리 검색
	List<CategoryDto> selectCategoryAll() throws Exception;
	
	// 색상 검색
	List<ColorDto> selectColorAll() throws Exception;
	
	// 상품 추가
	void insertProduct(ProductDto productDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
	
	// 상품 전체 갯수 조회
	int countProductAll() throws Exception;
	
	// 상품 전체 조회
	List<ProductDto> selectProductAll(int start, int end) throws Exception;
	
	// 상품 옵션 조회
	List<ProductOptDto> selectProductOpt(String productNo) throws Exception;
	
	// 상품 옵션 추가
	void insertProductOpt(ProductOptDto productOptDto) throws Exception;
}
