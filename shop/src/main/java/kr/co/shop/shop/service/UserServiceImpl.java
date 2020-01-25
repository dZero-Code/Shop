package kr.co.shop.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.co.shop.shop.dto.UserDto;
import kr.co.shop.shop.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	/* 사용자 추가 */
	@Override
	public void insertUser(UserDto userDto) throws Exception {
		userMapper.insertUser(userDto);
	}
	
	/* 사용자아이디와 패스워드로 사용자 조회 */
	@Override
	public UserDto selectUser(String userid, String passwd) throws Exception {
		return userMapper.selectUser(userid, passwd);
	}
	
	
	/* 전체 사용자 조회 */
	@Override
	public List<UserDto> selectUserAll() throws Exception {
		return userMapper.selectUserAll();
	}
}
