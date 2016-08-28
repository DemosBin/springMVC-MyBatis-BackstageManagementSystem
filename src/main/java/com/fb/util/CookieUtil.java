package com.fb.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class CookieUtil {

    private CookieUtil() {
    }

    /**
     * 保存cookie
     *
     * @param name
     * @param value
     * @return Cookie
     */
    public static Cookie saveCookie(String name, String value, HttpServletResponse response) {
        Cookie cookie = getInstance(name);
        cookie.setValue(value);
        response.addCookie(cookie);
        return cookie;
    }

    /**
     * 获取cookies
     *
     * @param request
     * @param name
     * @return String
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        return getCookieValue(cookies, name);
    }

    public static Cookie getInstance(String name) {
        return getInstance(false, name);
    }

    /**
     *
     * @param isSupportSecureCookie boolean
     * @param name                  String
     * @return Cookie
     */
    public static Cookie getInstance(boolean isSupportSecureCookie, String name) {
        Cookie cookie = new Cookie(name, "");
        cookie.setSecure(isSupportSecureCookie);
//		cookie.setHttpOnly(true);
        cookie.setPath("/");
//		cookie.setMaxAge(14 * 24 * 60 * 60);
        return cookie;
    }

    /**
     * getCookieValue
     *
     * @param cookies    Cookie[]
     * @param cookieName String
     * @return String
     */
    private static String getCookieValue(Cookie[] cookies, String cookieName) {
        String cookieValue = null;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookieName.equals(cookie.getName())) {
                    cookieValue = cookie.getValue();
                    break;
                }
            }
        }
        return cookieValue;
    }
}

