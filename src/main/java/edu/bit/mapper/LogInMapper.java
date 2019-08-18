package edu.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import edu.bit.ex.vo.MemberVO;


public interface LogInMapper {

	@Select("select * from login where id = #{id} and pw = #{pw}")
	public MemberVO logInMember(@Param("id") String id,@Param("pw") String pw);
	
}
