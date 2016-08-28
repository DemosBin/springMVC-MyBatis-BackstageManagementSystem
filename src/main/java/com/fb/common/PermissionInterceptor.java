package com.fb.common;

import com.fb.util.AppConfig;
import com.fb.util.CookieUtil;
import com.fb.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/2.
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(PermissionInterceptor.class);

    @Autowired
    private AppConfig appConfig;

    private StringUtil stringUtil;
    private CookieUtil cookieUtil;

    /**
     * verify user by cookie
     * @param request
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookies = request.getCookies();

        String token = cookieUtil.getCookieValue(request,"token");
        String userId = cookieUtil.getCookieValue(request,"userId");

        if(!StringUtil.isEmpty(token)&&!stringUtil.isEmpty(userId)){
           /* Map<String, Object> verify = userService.verify(token);
            String verifyUserId = stringUtil.getString(verify.get("userId"));
            if(stringUtil.equal(verifyUserId,userId)){
                return true;
            }*/
        }
        httpServletResponse.sendRedirect(appConfig.getLoginPage());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
