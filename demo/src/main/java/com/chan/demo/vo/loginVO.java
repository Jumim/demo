package com.chan.demo.vo;

public class loginVO {
    private String mm_name;
    private String mm_id;
    private String mm_pwd;
    private String mm_lev;
    private String mm_code;

    public String getMm_pwd() {
        return mm_pwd;
    }

    public void setMm_pwd(String mm_pwd) {
        this.mm_pwd = mm_pwd;
    }

    public String getMm_id() {
        return mm_id;
    }

    public void setMm_id(String mm_id) {
        this.mm_id = mm_id;
    }

    public String getMm_name() {
        return mm_name;
    }

    public void setMm_name(String mm_name) {
        this.mm_name = mm_name;
    }

    public void setMm_lev(String mm_lev) {
        this.mm_lev = mm_lev;
    }

    public String getMm_lev() {
        return mm_lev;
    }

    public void setMm_code(String mm_code) {
        this.mm_code = mm_code;
    }

    public String getMm_code() {
        return mm_code;
    }

    public loginVO(String mm_name, String mm_id, String mm_pwd, String mm_lev){
        super();
        this.mm_name = mm_name;
        this.mm_id = mm_id;
        this.mm_pwd = mm_pwd;
        this.mm_lev = mm_lev;
    }

}
