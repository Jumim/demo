package com.chan.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chan.demo.mapper.boardMapper;
import com.chan.demo.vo.boardVO;

import java.util.List;

@Service
public class boardService {

    @Autowired private boardMapper bm;

    // 게시글 목록 불러오기
    public List<boardVO> getBoardList(){
        return bm.getBoardList();
    }

    // 게시글 작성
    public void postWrite(boardVO bv){
        bm.postWrite(bv);
    }

    // 게시글 상세보기
    public boardVO postView(int po_num){
        return bm.postView(po_num);
    }

    // 게시글 삭제
    public void postDelete(int po_num){
        bm.postDelete(po_num);
    }

    public String getPostNum() {
        return bm.getPostNum();
    }

}
