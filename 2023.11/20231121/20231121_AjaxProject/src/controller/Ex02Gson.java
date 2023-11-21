package controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.*;
import model.MemberDTO;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ex02Gson")
public class Ex02Gson extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=UTF-8");
		
		MemberDTO member1 = new MemberDTO("email1", "010-1111-2222", "경기도 안산시");
		MemberDTO member2 = new MemberDTO("email2", "010-2222-3333", "경기도 시흥시");
		MemberDTO member3 = new MemberDTO("email3", "010-3333-4444", "경기도 수원시");
		MemberDTO member4 = new MemberDTO("email4", "010-4444-5555", "경기도 화성시");
		
		List<MemberDTO> list = new ArrayList<>();
		list.add(member1);
		list.add(member2);
		list.add(member3);
		list.add(member4);
		
		PrintWriter out = res.getWriter();
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		
	}

}
