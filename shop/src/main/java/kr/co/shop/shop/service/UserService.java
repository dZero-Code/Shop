package kr.co.shop.shop.service;

import java.util.List;

import kr.co.shop.shop.dto.UserDto;

public interface UserService {
	// 사용자 추가
	void insertUser(UserDto userDto) throws Exception;
	
	// 유저 조회 (아이디, 패스워드)
	UserDto selectUser(String userid, String passwd) throws Exception;
	
	// 전체 유저 조회
	List<UserDto> selectUserAll() throws Exception;
}
