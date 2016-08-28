package com.fb.dao;

import com.fb.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Demos on 2016/8/22.
 */
public interface SystemDao {
    List<SysMenu> getSysMenuByUserId(@Param("id")String id);
}
