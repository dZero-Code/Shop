package kr.co.shop.shop.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.shop.shop.dto.CategoryDto;
import kr.co.shop.shop.service.ProductService;

@Controller
public class AdminController {
	private final ProductService productService;
	
	@Autowired
	public AdminController(ProductService productService) {
		this.productService = productService;
	}
	
	
	/* 상품추가 페이지 */
	@GetMapping("/admin/product/insert")
	public ModelAndView openProductInsert() throws Exception{
		ModelAndView view = new ModelAndView("/admin/product_insert");

		Iterable<CategoryDto> categoryList = productService.selectCategoryAll();
		
		String temp="";
		ArrayList<String> category1List = new ArrayList<String>();
		
		for(CategoryDto dto : categoryList) {
			if(!temp.equals(dto.getCategory1())) {
				temp = dto.getCategory1();
				category1List.add(dto.getCategory1());
			}
		}
		
		view.addObject("categoryList", categoryList);
		view.addObject("category1List", category1List);
		
		return view;
	}
	
	/* 상품추가 */
	@PostMapping("/admin/product/insert")
	public ModelAndView productInsert() throws Exception{
		return new ModelAndView("/admin/product_insert");
	}
}
