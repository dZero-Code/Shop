package kr.co.shop.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.shop.shop.dto.UserDto;

@Mapper
public interface UserMapper {
	void insertUser(UserDto userDto) throws Exception;
	UserDto selectUser(@Param("userid") String userid, @Param("passwd") String passwd) throws Exception;
	List<UserDto> selectUserAll() throws Exception;
}
