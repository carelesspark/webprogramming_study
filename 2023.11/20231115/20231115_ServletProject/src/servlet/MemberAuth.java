package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membership.MemberDAO;
import membership.MemberDTO;


@WebServlet(
         urlPatterns = "/MemberAuth.mvc",
         initParams = @WebInitParam(name="admin_id",value="jong")
         )
public class MemberAuth extends HttpServlet {
   
   MemberDAO dao;
   
   @Override
   public void init() throws ServletException {
      System.out.println("init() 호출됨");
      ServletContext application = this.getServletContext();
      String driver = application.getInitParameter("OracleDriver");
      String connectUrl = application.getInitParameter("OracleUrl");
        String oId = application.getInitParameter("OracleId");
        String oPass = application.getInitParameter("OraclePwd");
        
        dao = new MemberDAO(driver, connectUrl, oId, oPass);
   }

   @Override
   protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      String admin_id = this.getInitParameter("admin_id");
      
      String id = req.getParameter("id");
      String pass = req.getParameter("pass");
      
      MemberDTO memberDTO = dao.getMemberDTO(id, pass);
      
      String memberName = memberDTO.getName();
      
      if(memberName != null) {
         req.setAttribute("authMessage", memberName + " 회원님 반갑습니다.");
      }else {
         if(admin_id.equals(id)) {
            req.setAttribute("authMessage", admin_id + "는 최고 관리자 입니다.");
         }else {
            req.setAttribute("authMessage", "귀하는 회원이 아닙니다.");
         }
      }
      
      req.getRequestDispatcher("./MemberAuth.jsp").forward(req, res);
      
   }

   @Override
   public void destroy() {
      dao.close();
   }


}