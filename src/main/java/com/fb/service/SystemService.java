package com.fb.service;

import com.fb.entity.SysMenu;
import com.fb.vo.SysMenuVo;

import java.util.List;

/**
 * Created by Demos on 2016/8/22.
 */
public interface SystemService {
    public List<SysMenuVo> getSysMenuByUserId(String id);
}
