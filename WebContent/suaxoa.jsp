<%@page import="javax.swing.JOptionPane"%>
<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
  giohangbo gh=(giohangbo)session.getAttribute("gio");
  String[] check= request.getParameterValues("check");
  if(check!=null && request.getParameter("butxoa")!=null)
	for(String ms:check)
		gh.Xoa(ms);
  
  if(request.getParameter("butxoa")!=null){
	  String ms=request.getParameter("butxoa");
	  gh.Xoa(ms);
  }
  if(request.getParameter("butsua")!=null){
	  String ms=request.getParameter("butsua");
	  String sl=request.getParameter(ms);
	//  out.print(ms+":"+sl);
	  gh.Sua(ms, Long.parseLong(sl));
  }

  session.setAttribute("gio", gh);
  if(gh.ds.size()==0)
	  response.sendRedirect("hthaisanController");
  else
	  response.sendRedirect("htgioController");
%>
</body>
</html>
