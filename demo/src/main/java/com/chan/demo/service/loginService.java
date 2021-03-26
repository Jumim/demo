package com.chan.demo.service;

import com.chan.demo.mapper.loginMapper;
import com.chan.demo.vo.loginVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class loginService {

    @Autowired
    private loginMapper lm;
    private SqlSession sqlSession;
    
    //로그인
    public loginVO login(loginVO lv) throws Exception {
        return lm.login(lv);
    }

    //로그아웃
    public void logout(HttpSession session){
        session.invalidate();   //세션 초기화
    }

}
