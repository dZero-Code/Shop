package kr.co.shop.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.shop.shop.dto.CategoryDto;
import kr.co.shop.shop.dto.ColorDto;
import kr.co.shop.shop.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductMapper productMapper;
	
	@Autowired
	public ProductServiceImpl(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}
	
	/* 카테고리 검색 */
	@Override
	public List<CategoryDto> selectCategoryAll() throws Exception {
		return productMapper.selectCategoryAll();
	}
	
	/* 색상 검색 */
	@Override
	public List<ColorDto> selectColorAll() throws Exception {
		return productMapper.selectColorAll();
	}
}
