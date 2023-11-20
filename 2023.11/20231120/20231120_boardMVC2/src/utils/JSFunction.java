package utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class JSFunction {

	public static void alertLocation(String msg, String url, JspWriter out) {
		String script = "<script script charset='utf-8'>" + "alert('" + msg + "'); " + "location.href='" + url + "'" + "</script>";
		try {
			out.print(script);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void alertBack(String msg, JspWriter out) {
		String script = "<script script charset='utf-8'>" + "alert('" + msg + "'); " + "history.back()" + "</script>";
		try {
			out.print(script);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 서블릿 사용 시 out객체 생성에 대한 변경 필요(2번의 오버로딩)
	
	public static void alertLocation(HttpServletResponse res, String msg, String url) { 
		String script = "<script script charset='utf-8'>" + "alert('" + msg + "'); " + "location.href='" + url + "'" + "</script>";
		try {
			PrintWriter out = res.getWriter();
			out.print(script);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void alertBack(HttpServletResponse res, String msg) {
		String script = "<script charset='utf-8'>" + "alert('" + msg + "'); " + "history.back()" + "</script>";
		try {
			PrintWriter out = res.getWriter();
			out.print(script);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
