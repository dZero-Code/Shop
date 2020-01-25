package kr.co.shop.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.shop.shop.dto.UserDto;
import kr.co.shop.shop.service.UserService;

@Controller
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	/*- 로그인 화면으로 이동 -*/
	@GetMapping("login")
	public String openLogin() throws Exception{
		
		return "/user/login";
	}
	
	/*- 로그인 -*/
	@PostMapping("login")
	public ModelAndView login(String userid, String passwd, HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView();
	
		UserDto userDto = userService.selectUser(userid, passwd);
		
		if(userDto != null) {	// 객체가 존재 → 로그인
			session.setAttribute("userId", userDto.getUserid());		// 세션 생성
			view.setViewName("redirect:/");
		}else {
			view.setViewName("/user/login");
		}
		
		return view;
	}

	/*- 회원가입 화면으로 이동 -*/
	@GetMapping("signup")
	public String openSignup() throws Exception{
		return "/user/signup";
	}
	
	/*- 회원가입 -*/
	@PostMapping("signup")
	public ModelAndView signup(@Validated UserDto userDto, BindingResult result) throws Exception{
		ModelAndView view = new ModelAndView();
		
		userDto.setRank("bronze");
		
		/* 유효성 검증 */
		if(result.hasErrors()) {						// 유효성 검증시 오류 발생 여부 (true, false)
			//System.out.println("유효성 실패");
			view.setViewName("/user/signup");
		}else {
			//System.out.println("유효성 성공");
			view.setViewName("redirect:/welcome");
			userService.insertUser(userDto);
		}
		
		return view;
	}
	

	/* 회원가입 성공 페이지 */
	@GetMapping("welcome")
	public String openWelcome() throws Exception{
		return "/user/welcome";
	}
}
