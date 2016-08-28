package com.fb.entity;

/**
 * Created by FB on 2016/7/26.
 */
public class User {
    private String p_id;
    private String s_name;
    private String s_psw;
    private String s_province;
    private String s_city;
    private String s_area;
    private String s_email;
    private String s_create_time;
    private String s_update_time;

    public User() {
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_psw() {
        return s_psw;
    }

    public void setS_psw(String s_psw) {
        this.s_psw = s_psw;
    }

    public String getS_province() {
        return s_province;
    }

    public void setS_province(String s_province) {
        this.s_province = s_province;
    }

    public String getS_city() {
        return s_city;
    }

    public void setS_city(String s_city) {
        this.s_city = s_city;
    }

    public String getS_area() {
        return s_area;
    }

    public void setS_area(String s_area) {
        this.s_area = s_area;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    public String getS_create_time() {
        return s_create_time;
    }

    public void setS_create_time(String s_create_time) {
        this.s_create_time = s_create_time;
    }

    public String getS_update_time() {
        return s_update_time;
    }

    public void setS_update_time(String s_update_time) {
        this.s_update_time = s_update_time;
    }

    public User(String p_id, String s_name, String s_psw, String s_province, String s_city, String s_area, String s_email, String s_create_time, String s_update_time) {
        this.p_id = p_id;
        this.s_name = s_name;
        this.s_psw = s_psw;
        this.s_province = s_province;
        this.s_city = s_city;
        this.s_area = s_area;
        this.s_email = s_email;
        this.s_create_time = s_create_time;
        this.s_update_time = s_update_time;
    }
}
