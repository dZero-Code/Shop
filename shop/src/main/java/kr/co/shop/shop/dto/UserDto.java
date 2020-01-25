package kr.co.shop.shop.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserDto {
	// 사용자의 아이디
	@NotEmpty(message="아이디를 입력해주세요.")
	@Pattern(regexp = "((?=.*[0-9])(?=.*[a-zA-Z]).{4,12})", 
			message = "아이디는 4~12자리로 숫자와 영문으로 구성해주세요.")
	private String userid;
	
	// 사용자의 비밀번호
	@NotEmpty(message="비밀번호를 입력해주세요.")
	@Pattern(regexp = "((?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-]).{8,16})", 
			 message = "비밀번호는 8~16자리로 숫자와 특수 문자가 포함된 영문으로 구성해주세요.")
	private String passwd;
	
	// 사용자의 이름
	@NotEmpty(message="이름을 입력해주세요.")
	private String name;
	
	// 사용자의 주민등록번호 앞자리
	@NotEmpty(message="주민등록번호 앞자리를 입력해주세요.")
	private String birth;
	
	// 사용자의 이메일
	@NotEmpty(message="이메일을 입력해주세요.")
	@Email(message="이메일 형식에 맞게 입력해주세요.")
	private String email;
	
	// 사용자의 핸드폰 번호
	@NotEmpty(message="핸드폰 번호를 입력해주세요.")
	@Pattern(regexp = "[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}",
			message="핸드폰 형식에 맞게 입력해주세요.")
	private String phone;
	
	// 사용자의 등급
	private String rank;
	
	// 사용자의 등록일
	private String createdDatetime;
}
