package com.fb.entity;

/**
 * Created by Demos on 2016/8/22.
 */
public class SysMenu {
    public SysMenu() {

    }

    private String f_menu_id_parent = null;    // 表字段名称为:f_menu_id_parent 相应注释为:父模块。
    private String p_id = null;    // 表字段名称为:p_id 相应注释为:ID。
    private String s_desc = null;    // 表字段名称为:s_desc 相应注释为:菜单描述。
    private String s_full_url = null;    // 表字段名称为:s_full_url 相应注释为:菜单地址。
    private String s_name = null;    // 表字段名称为:s_name 相应注释为:菜单名称。
    private String s_status = null;    // 表字段名称为:s_status 相应注释为:状态。
    private String s_type = null;    // 表字段名称为:s_type 相应注释为:菜单类型。

    public String getF_menu_id_parent() {
        return f_menu_id_parent;
    }

    public void setF_menu_id_parent(String f_menu_id_parent) {
        this.f_menu_id_parent = f_menu_id_parent;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getS_desc() {
        return s_desc;
    }

    public void setS_desc(String s_desc) {
        this.s_desc = s_desc;
    }

    public String getS_full_url() {
        return s_full_url;
    }

    public void setS_full_url(String s_full_url) {
        this.s_full_url = s_full_url;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_status() {
        return s_status;
    }

    public void setS_status(String s_status) {
        this.s_status = s_status;
    }

    public String getS_type() {
        return s_type;
    }

    public void setS_type(String s_type) {
        this.s_type = s_type;
    }
    public SysMenu( String  f_menu_id_parent, String  p_id, String  s_desc, String  s_full_url, String  s_name, String  s_status, String  s_type){
        this.f_menu_id_parent = f_menu_id_parent;
        this.p_id = p_id;
        this.s_desc = s_desc;
        this.s_full_url = s_full_url;
        this.s_name = s_name;
        this.s_status = s_status;
        this.s_type = s_type;
    }
}
