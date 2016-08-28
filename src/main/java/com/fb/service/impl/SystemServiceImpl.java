package com.fb.service.impl;

import com.fb.util.CommonUtils;
import com.fb.converter.SysMenuConverter;
import com.fb.dao.SystemDao;
import com.fb.entity.SysMenu;
import com.fb.vo.SysMenuVo;
import com.fb.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Demos on 2016/8/22.
 */
@Service
public class SystemServiceImpl implements SystemService {
    private static final Logger logger = LoggerFactory.getLogger(SystemServiceImpl.class);
    @Autowired
    private SystemDao systemDao;

    public List<SysMenuVo> getSysMenuByUserId(String id) {
        List<SysMenu> sysMenus = systemDao.getSysMenuByUserId(id);
        List<SysMenuVo> sysMenuVos = new ArrayList<SysMenuVo>();
        SysMenuConverter converter = new SysMenuConverter();
        sysMenuVos = converter.convert2V(sysMenus);
        sysMenuVos = buildMenu(sysMenuVos);
        return sysMenuVos;
    }

    /**
     * sort and Construct menu
     */
    private List<SysMenuVo> buildMenu( List<SysMenuVo> menus ){
        try{
            if( CommonUtils.isEmpty(menus) ){
                return new ArrayList<SysMenuVo>() ;
            }

            List<SysMenuVo>superMenus = findMenusByParnetId(
                    "0" , menus ) ;
            for( SysMenuVo menu : superMenus ){
                List<SysMenuVo>childs = findMenusByParnetId(
                        menu.getId() , menus ) ;
                if(  !CommonUtils.isEmpty( childs ) ){
                    menu.setSubMenus(childs);
                }
            }
            menus.clear();
            menus = superMenus ;
        }catch(Exception e){
            e.printStackTrace();
            logger.error("build menu error "+ e.getMessage());
        }
        return menus ;
    }

    private List<SysMenuVo> findMenusByParnetId( String parentId
            , List<SysMenuVo> menus ){
        List<SysMenuVo> nMenus = new ArrayList<SysMenuVo>() ;
        try{
            for( SysMenuVo menu : menus ){
                if( menu.getParentMenuId().equals(parentId)){
                    nMenus.add(menu) ;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return nMenus ;
    }
}
