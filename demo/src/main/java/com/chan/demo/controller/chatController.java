package com.chan.demo.controller;

import com.chan.demo.websocket.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chan.demo.websocket.ChatRoom;
import com.chan.demo.websocket.ChatRoomForm;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class chatController {
    private final ChatRoomRepository chatRoomRepository;

    @GetMapping("/chatOpen")
    public String rooms(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();

        session.setAttribute("mm_name1", session.getAttribute("mm_name"));

        model.addAttribute("rooms",chatRoomRepository.findAllRoom());
        model.addAttribute("mm_name1", session.getAttribute("mm_name") );

        return "article/rooms";
    }

    @GetMapping("/rooms/{id}")
    public String room(@PathVariable String id, Model model, HttpServletRequest request){

        HttpSession session = request.getSession();

        ChatRoom room = chatRoomRepository.findRoomById(id);
        model.addAttribute("room",room);
        model.addAttribute("mm_name", (String) session.getAttribute("mm_name1") );
        return "article/room";
    }

}
