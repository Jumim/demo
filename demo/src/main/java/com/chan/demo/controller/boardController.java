package com.chan.demo.controller;

import com.chan.demo.vo.chattingVO;
import com.chan.demo.websocket.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chan.demo.service.boardService;
import com.chan.demo.vo.boardVO;
import com.chan.demo.service.chatService;
import com.chan.demo.websocket.ChatRoomRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class boardController {

    private final ChatRoomRepository chatRoomRepository;

    @Autowired private boardService bs;
    @Autowired private chatService cs;

    
    // 게시글 목록 페이지로 이동
    @RequestMapping(value="/board", method = RequestMethod.GET)
    public String board(Model model, HttpServletRequest request) throws Exception {

        String map = "article/list";

        map = memberInfo(model, map, request);

        return map;
    }
    
    // 게시글 목록 불러오기
    @RequestMapping(value="/boardList", method = RequestMethod.GET)
    @ResponseBody
    public List<boardVO> boardList() throws Exception {
        return bs.getBoardList();
    }

    //게시글 작성 페이지로 이동
    @RequestMapping(value="/write")
    public String write(Model model, HttpServletRequest request) throws Exception {

        String map = "article/write";

        map = memberInfo(model, map, request);

        return map;
    }
    
    // 게시글 작성하기
    @RequestMapping(value="/postWrite", method = RequestMethod.POST)
    public String postWrite(boardVO bv, HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession(); //세션 객체 가져오기

        Date toDay = new Date();

        //부족한 정보 채워넣기
        bv.setPo_mmcode((String) session.getAttribute("mm_code"));
        bv.setPo_mmname((String) session.getAttribute("mm_name"));
        bv.setPo_date(toDay);

        bs.postWrite(bv);
        
        //채팅
        ChatRoom cr = chatRoomRepository.createChatRoom(bv.getPo_name());

        String ch_code = cr.getRoomId();
        String ch_name = cr.getName();
        String ch_mmcode1 = bv.getPo_mmcode();
        String ch_mmcode2 = "-";
        int ch_postnum = 10;

        chattingVO cv = new chattingVO(ch_code,ch_name,ch_mmcode1,ch_mmcode2,ch_postnum);

        cs.setChatRoom(cv);

        return "redirect:board";
    }

    // 게시글 상세보기
    @RequestMapping(value="/postView")
    public String postView(Model model, HttpServletRequest request, @RequestParam("po_num") int po_num) throws Exception {

        // 변수 선언
        String map = "article/view";
        String po_boname = "";
        String po_caname = "";
        HttpSession session = request.getSession();

        map = memberInfo(model, map, request);

        if(map.equals("article/view")){
            //로그인o
            boardVO bv = bs.postView(po_num);   // 게시글 정보 받아오기

            // code부분 한글로 변환
            if(((String)bv.getPo_bocode()).equals("B001")){
                po_boname = "중고거래";
            }else {
                
            }

            if(Integer.valueOf(bv.getPo_cacode()) == 1){
                po_caname = "디지털/가전";
            }else if(Integer.valueOf(bv.getPo_cacode()) == 2) {
                po_caname = "가구/인테리어";
            }

            model.addAttribute("po_num", bv.getPo_num());
            model.addAttribute("po_boname", po_boname);
            model.addAttribute("po_caname", po_caname);
            model.addAttribute("po_name", bv.getPo_name());
            model.addAttribute("po_price", Integer.valueOf(bv.getPo_price()));
            model.addAttribute("po_content", bv.getPo_content());
            model.addAttribute("po_mmname", bv.getPo_mmname());

            // 삭제 버튼 활성화 or 비활성화
            if(session.getAttribute("mm_lev").equals("M")){
                model.addAttribute("po_delete", "true");
            }else {
                if( ((String)bv.getPo_mmcode()).equals(session.getAttribute("mm_code")) ){
                    model.addAttribute("po_delete", "true");
                }else {
                    model.addAttribute("po_delete", "false");
                }
            }
        }else {
            //로그인x

        }

        return map;
    }
    
    // 게시글 삭제
    @RequestMapping("/postDelete")
    public String postDelete(Model model, HttpServletRequest request, @RequestParam("po_num") int po_num){

        bs.postDelete(po_num);

        return "redirect:board";
    }

    // 회원정보 불러오는 부분
    public String memberInfo(Model model, String map, HttpServletRequest request){
        HttpSession session = request.getSession(); //세션 객체 가져오기

        //세션에 저장 된 값 받아오기
        String mm_name = (String) session.getAttribute("mm_name");
        String mm_lev = (String) session.getAttribute("mm_lev");
        
        if(mm_name == null && mm_lev == null){
            //로그인x 상태면 로그인 페이지로 리다이렉트
            
            map = "redirect:login";
        }else {
            //로그인o 상태면 해당하는 페이지로 이동
            
            //view로 값 보내주기
            model.addAttribute("mm_name", mm_name);
            model.addAttribute("mm_lev", mm_lev);

            map = map;
        }

        return map;

    }

}
