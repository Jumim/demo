package com.chan.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.chan.demo.vo.boardVO;

import javax.validation.Valid;
import java.util.List;

@Repository("boardMapper")
@Mapper
public interface boardMapper {
    public List<boardVO> getBoardList();
    public void postWrite(@Valid boardVO bv);
    public boardVO postView(int po_num);
    public void postDelete(int po_num);
    public String getPostNum();
}
