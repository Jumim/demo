package com.chan.demo.service;

import com.chan.demo.vo.chattingVO;
import com.chan.demo.mapper.chatMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class chatService {

    @Autowired
    private chatMapper cm;

    public void setChatRoom(@Valid chattingVO cv) {
        cm.setChatRoom(cv);
    }

}
