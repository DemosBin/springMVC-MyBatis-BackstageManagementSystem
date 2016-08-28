package com.fb.vo;

import java.util.List;

/**
 * Created by Demos on 2016/8/22.
 */
public class SysMenuVo{
    public SysMenuVo() {

    }
    private String parentMenuId = null;    // 表字段名称为:f_menu_id_parent 相应注释为:父模块。
    private String id = null;    // 表字段名称为:p_id 相应注释为:ID。
    private String fullUrl = null;    // 表字段名称为:s_full_url 相应注释为:菜单地址。
    private String name = null;    // 表字段名称为:s_name 相应注释为:菜单名称。
    private List<SysMenuVo> subMenus = null;
    private PermissionVo permission ;

    public String getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SysMenuVo> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<SysMenuVo> subMenus) {
        this.subMenus = subMenus;
    }
}
