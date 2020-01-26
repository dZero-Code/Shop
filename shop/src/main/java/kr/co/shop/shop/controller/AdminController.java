package kr.co.shop.shop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.shop.common.Pagination;
import kr.co.shop.shop.dto.CategoryDto;
import kr.co.shop.shop.dto.ColorDto;
import kr.co.shop.shop.dto.ProductDto;
import kr.co.shop.shop.dto.ProductOptDto;
import kr.co.shop.shop.service.ProductService;

@Controller
public class AdminController {
	private final ProductService productService;
	
	@Autowired
	public AdminController(ProductService productService) {
		this.productService = productService;
	}
	
	/* 상품 관리 페이지 */
	@GetMapping("/admin/product")
	public ModelAndView openProduct(@RequestParam(value="page", required=false) String page) throws Exception{
		ModelAndView view = new ModelAndView("/admin/product/list");
		
		Pagination pagination = new Pagination(productService.countProductAll(), Integer.parseInt(page));
		Iterable<ProductDto> productList = productService.selectProductAll(pagination.getStart(), pagination.getCntPerPage());

		view.addObject("productList", productList);
		view.addObject("paging", pagination);
		
		return view;
	}
	
	/* 상품추가 페이지 */
	@GetMapping("/admin/product/insert")
	public ModelAndView openProductInsert() throws Exception{
		ModelAndView view = new ModelAndView("/admin/product/insert");

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
	public String productInsert(ProductDto productDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
		productService.insertProduct(productDto, multipartHttpServletRequest);

		return "redirect:/admin/product/insert";
	}
	
	/* 상품 옵션추가 페이지 */
	@GetMapping("/admin/product/opt")
	public ModelAndView openProductOptInsert(@RequestParam(value="productNo", required=false) String productNo) throws Exception{
		ModelAndView view = new ModelAndView("/admin/product/opt1");
		
		Iterable<ProductOptDto> productOptList = productService.selectProductOpt(productNo);
		Iterable<ColorDto> colorList = productService.selectColorAll();
		
		view.addObject("productOptList", productOptList);
		view.addObject("colorList", colorList);
		view.addObject("productNo", productNo);
		
		return view;
	}
	
	/* 상품 옵션추가*/
	@PostMapping("/admin/product/opt")
	public String productOptInsert(ProductOptDto productOptDto) throws Exception{
		productService.insertProductOpt(productOptDto);

		return "redirect:/admin/product/opt?productNo="+productOptDto.getProductNo();
	}
	
}
