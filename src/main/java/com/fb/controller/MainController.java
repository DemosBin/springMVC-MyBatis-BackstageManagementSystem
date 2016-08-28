package com.fb.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fb.entity.SysMenu;
import com.fb.entity.User;
import com.fb.service.SystemService;
import com.fb.service.impl.UserService;
import com.fb.vo.SysMenuVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private SystemService systemService;

    User user = new User();
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView main(ModelAndView model, HttpSession session) {
        List<SysMenuVo> sysMenuList = systemService.getSysMenuByUserId("admin");
        model.setViewName("index");
        model.addObject("menus",sysMenuList);
        return model;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView aa(Model model, HttpSession session, HttpServletRequest request) {

        user.setP_id("00001");
        user = userService.getUserById(user);
        return new ModelAndView("home","user",user);
    }

    @RequestMapping(value = "getUserById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User json(@PathVariable String id, Model model, HttpSession session) {
        user.setP_id(id);
        user = userService.getUserById(user);
        return user;
    }
    @RequestMapping(value = "getUserList", method = RequestMethod.GET)
    @ResponseBody
    public List<User> UserList(Model model, HttpSession session) {
        List<User> ul = new ArrayList<User>();
        ul = userService.getUserList();
        return ul;
    }
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    @ResponseBody
    public Object updateUser(Model model,@ModelAttribute("user") User user, HttpSession session) {
        //List<User> ul = new ArrayList<User>();
        userService.updateUser(user);
        user = userService.getUserById(user);
        return "ok";
    }
    @RequestMapping(value = "delUser", method = RequestMethod.GET)
    @ResponseBody
    public Object delUser(Model model, HttpSession session) {
        List<User> ul = new ArrayList<User>();
        ul = userService.getUserList();
        return "ok";
    }

}