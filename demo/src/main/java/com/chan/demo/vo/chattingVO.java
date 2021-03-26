package com.chan.demo.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class chattingVO {

    private String ch_code;
    private String ch_name;
    private String ch_mmcode1;
    private String ch_mmcode2;
    private int ch_postnum;

    public chattingVO(String ch_code, String ch_name, String ch_mmcode1, String ch_mmcode2, int ch_postnum){
        super();
        this.ch_code = ch_code;
        this.ch_name = ch_name;
        this.ch_mmcode1 = ch_mmcode1;
        this.ch_mmcode2 = ch_mmcode2;
        this.ch_postnum = ch_postnum;
    }

}
