package com.fb.converter;

import com.fb.entity.SysMenu;
import com.fb.vo.SysMenuVo;

import java.util.List;

/**
 * Created by Demos on 2016/8/22.
 */
public class SysMenuConverter extends BaseConvertor<SysMenu, SysMenuVo> {
    @Override
    public SysMenu convert2P(SysMenuVo sysMenuVo) {
        return null;
    }

    @Override
    public SysMenuVo convert2V(SysMenu sysMenu) {
        SysMenuVo menuVo = new SysMenuVo();
        menuVo.setId(sysMenu.getP_id());
        menuVo.setName(sysMenu.getS_name());
        menuVo.setFullUrl(sysMenu.getS_full_url());
        menuVo.setParentMenuId(sysMenu.getF_menu_id_parent());
        return menuVo;
    }

    @Override
    public List<SysMenu> convert2P(List<SysMenuVo> sysMenuVos) {
        return super.convert2P(sysMenuVos);
    }

    @Override
    public List<SysMenuVo> convert2V(List<SysMenu> sysMenus) {
        return super.convert2V(sysMenus);
    }
}
