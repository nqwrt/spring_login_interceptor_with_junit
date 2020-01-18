package edu.bit.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import edu.bit.ex.vo.MemberVO;
import edu.bit.ex.vo.UserVO;


public interface LogInMapper {

	@Select("select * from login where id = #{id} and pw = #{pw}")
	public MemberVO logInMember(@Param("id") String id,@Param("pw") String pw);
	
	@Select("select * from users where username = #{username} and password = #{password}")
	public UserVO logInUser(@Param("username") String username,@Param("password") String password);
	
}
