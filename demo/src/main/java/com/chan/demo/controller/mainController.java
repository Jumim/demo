package com.chan.demo.controller;

import com.chan.demo.vo.mainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ExecutionException;

@Controller
public class mainController {

    @RequestMapping("/")
    public String test(Model model, HttpServletRequest request) throws Exception {
        String map = "";
        HttpSession session = request.getSession();

        //1. 세션 확인
        String mm_name = (String) session.getAttribute("mm_name");
        String mm_lev = (String) session.getAttribute("mm_lev");

        try {
            if(mm_name == null && mm_lev == null){
                //2 세션 없으면 로그인 페이지로 이동

                map = "redirect:login";

            }else {
                //3. 세션 있으면 게시판 리스트로 이동
                
                map = "redirect:board";

            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

}
