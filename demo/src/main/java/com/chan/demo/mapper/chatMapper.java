package com.chan.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.chan.demo.vo.chattingVO;

import javax.validation.Valid;

@Repository("chattingMapper")
@Mapper
public interface chatMapper {

    public void setChatRoom(@Valid chattingVO cv);
    public String getChCode(int ch_postnum);

}
