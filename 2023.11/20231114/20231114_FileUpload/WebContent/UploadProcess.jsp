<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.io.*"%>
<%@ page import="fileupload.MyfileDTO" %>
<%@ page import="fileupload.MyfileDAO" %>
<%
	// System.out.print(application.getRealPath("/uploads"));
	// C:\eclipse\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\20231114_FileUpload\C:\eclipse\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\20231114_FileUpload\

	String saveDirectory = application.getRealPath("/Uploads");
	int maxPostSize = 1024 * 1000;
	String encoding = "utf-8";
	
	
	// MultipartRequest 객체 생성
	MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding); // 실행하는 순간 파일이 올라감
	String fileName = mr.getFilesystemName("attachedFile");
	String ext = fileName.substring(fileName.lastIndexOf("."));
	String now = new SimpleDateFormat("yyyyMMdd_Hms").format(new Date());
	String newFileName = now + ext; // 20231114_121022.txt
	
	// 파일명 변경
	File oldFile = new File(saveDirectory + File.separator + fileName);
	File newFile = new File(saveDirectory + File.separator + newFileName);
	
	oldFile.renameTo(newFile);
	
	String name = mr.getParameter("name");
	String title = mr.getParameter("title");
	String[] cateArray = mr.getParameterValues("cate");
			
	StringBuffer cateBuf = new StringBuffer();
	
	if(cateArray == null){
		cateBuf.append("선택 없음");
	} else {
		for(String s : cateArray){
			cateBuf.append(s + ", ");
		}
	}
	
	MyfileDTO dto = new MyfileDTO();
	dto.setName(name);
	dto.setTitle(title);
	dto.setCate(cateBuf.toString());
	dto.setOfile(fileName);
	dto.setSfile(newFileName);
	
	MyfileDAO dao = new MyfileDAO();
	dao.insertFile(dto);
	dao.close();
	
	response.sendRedirect("FileList.jsp");
%>