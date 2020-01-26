package kr.co.shop.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.shop.common.FileUtils;
import kr.co.shop.shop.dto.CategoryDto;
import kr.co.shop.shop.dto.ColorDto;
import kr.co.shop.shop.dto.ProductDto;
import kr.co.shop.shop.dto.ProductOptDto;
import kr.co.shop.shop.dto.ProductPhotoDto;
import kr.co.shop.shop.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductMapper productMapper;
	private final FileUtils fileUtils;
	
	@Autowired
	public ProductServiceImpl(ProductMapper productMapper, FileUtils fileUtils) {
		this.productMapper = productMapper;
		this.fileUtils = fileUtils;
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
	
	/* 상품 추가 */
	@Override
	public void insertProduct(ProductDto productDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
		// 상품 추가
		productMapper.insertProduct(productDto);
		
		ProductPhotoDto productPhoto = fileUtils.parsePhotoInfo(productDto.getProductNo(), multipartHttpServletRequest);
		
		if(productPhoto != null) {
			productPhoto.setRegPlace("main");
			productMapper.insertProductPhoto(productPhoto);
		}
	}
	
	/* 상품 전체 갯수 조회 */
	@Override
	public int countProductAll() throws Exception {
		return productMapper.countProductAll();
	}
	
	/* 상품 전체 조회 */
	@Override
	public List<ProductDto> selectProductAll(int start, int end) throws Exception {
		return productMapper.selectProductAll(start, end);
	}
	
	/* 상품 옵션 조회 */
	@Override
	public List<ProductOptDto> selectProductOpt(String productNo) throws Exception {
		return productMapper.selectProductOpt(productNo);
	}
	
	/* 상품 옵션 추가 */
	@Override
	public void insertProductOpt(ProductOptDto productOptDto) throws Exception {
		productMapper.insertProductOpt(productOptDto);
	}
}
