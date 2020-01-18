package edu.bit.ex.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.bit.ex.vo.MemberVO;
import edu.bit.ex.vo.UserVO;
import edu.bit.mapper.LogInMapper;


@Service
public class LoginService {
	
	@Inject
	LogInMapper logInMapper;
	
	public MemberVO logInMember(String id,String pw) throws Exception {
			return logInMapper.logInMember(id,pw) ;
   }
	
	public UserVO logInUser(String id,String pw)  {
		return logInMapper.logInUser(id,pw) ;
	}

}
