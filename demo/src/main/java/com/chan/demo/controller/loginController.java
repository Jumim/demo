package com.chan.demo.controller;

import com.chan.demo.service.loginService;
import com.chan.demo.vo.loginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class loginController {

    @Autowired
    private loginService ms;

    //로그인 페이지로 이동
    @RequestMapping("/login")
    public String getLogin() throws Exception {
        return "article/login";
    }

    //로그인 페이지에서 로그인 실행
    @RequestMapping(value = "/loginGo", method = RequestMethod.POST)
    public String getLoginGo(loginVO mv, HttpServletRequest request, Model model) throws Exception {

        String map = null;

        HttpSession session = request.getSession();

        loginVO vo = ms.login(mv);

        if(vo == null){
            session.setAttribute("mm_name", null);
            session.setAttribute("mm_lev", null);
            session.setAttribute("mm_code", null);

            map = "redirect:login";
        }else {

            //System.out.println(vo.getMm_name());
            //System.out.println(vo.getMm_lev());

            //세션에 저장이 안되는데영,,
            //세션에 저장
            session.setAttribute("mm_name", vo.getMm_name());
            session.setAttribute("mm_lev", vo.getMm_lev());
            session.setAttribute("mm_code", vo.getMm_code());

            map = "redirect:board";
        }

        return map;
    }

    @RequestMapping(value = "/logout")
    public String pageLogin(HttpSession session) throws Exception {

        ms.logout(session);

        return "redirect:login";
    }

}
