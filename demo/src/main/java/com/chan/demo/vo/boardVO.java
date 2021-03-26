package com.chan.demo.vo;

import java.util.Date;

public class boardVO {
    private Integer po_num;
    private String po_bocode;
    private String po_name;
    private String po_cacode;
    private String po_price;
    private String po_content;
    private String po_mmcode;
    private String po_mmname;
    private Date po_date;

    public Integer getPo_num() {
        return po_num;
    }

    public void setPo_num(Integer po_num) {
        this.po_num = po_num;
    }

    public String getPo_bocode() {
        return po_bocode;
    }

    public void setPo_bocode(String po_bocode) {
        this.po_bocode = po_bocode;
    }

    public String getPo_cacode() {
        return po_cacode;
    }

    public void setPo_cacode(String po_cacode) {
        this.po_cacode = po_cacode;
    }

    public String getPo_content() {
        return po_content;
    }

    public void setPo_content(String po_content) {
        this.po_content = po_content;
    }

    public Date getPo_date() {
        return po_date;
    }

    public void setPo_date(Date po_date) {
        this.po_date = po_date;
    }

    public String getPo_mmcode() {
        return po_mmcode;
    }

    public void setPo_mmcode(String po_mmcode) {
        this.po_mmcode = po_mmcode;
    }

    public String getPo_mmname() {
        return po_mmname;
    }

    public void setPo_mmname(String po_mmname) {
        this.po_mmname = po_mmname;
    }

    public String getPo_name() {
        return po_name;
    }

    public void setPo_name(String po_name) {
        this.po_name = po_name;
    }

    public String getPo_price() {
        return po_price;
    }

    public void setPo_price(String po_price) {
        this.po_price = po_price;
    }

    public boardVO(Integer po_num, String po_bocode, String po_name, String po_cacode, String po_price, String po_content, String po_mmcode, String po_mmname, Date po_date){
        super();
        this.po_num = po_num;
        this.po_bocode = po_bocode;
        this.po_name = po_name;
        this.po_cacode = po_cacode;
        this.po_price = po_price;
        this.po_content = po_content;
        this.po_mmcode = po_mmcode;
        this.po_mmname = po_mmname;
        this.po_date = po_date;
    }
}
