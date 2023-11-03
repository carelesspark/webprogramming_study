package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {

	public static void makeCookie(HttpServletResponse response, String cName, String cValue, int cTime) {
		Cookie loginCookie = new Cookie(cName, cValue);
		loginCookie.setPath("/");
		loginCookie.setMaxAge(cTime);
		response.addCookie(loginCookie);
	}

	public static String readCookie(HttpServletRequest request, String cName) {

		String cookieValue = "";

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				String cookieName = c.getName();
				if (cName.equals(cookieName)) {
					cookieValue = c.getValue();
				}

			}
		}

		return cookieValue;
	}

	public static void deleteCookie(HttpServletResponse response, String cName) {
		makeCookie(response, cName, "", 0);
	}
}
