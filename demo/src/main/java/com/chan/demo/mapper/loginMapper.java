package com.chan.demo.mapper;

import com.chan.demo.vo.loginVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;

@Repository("loginMapper")
@Mapper
public interface loginMapper {

    //1. 로그인
    public loginVO login(loginVO mv) throws Exception;

    //3. 로그아웃
    public void logout(HttpSession session);

}
