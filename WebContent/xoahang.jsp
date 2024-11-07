<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
giohangbo gh;
//b1: gan session vao 1 bien
gh=(giohangbo) session.getAttribute("gio");
//b2: Thao tac trên bien: gh
gh.XoaAll();
//b3: Luu gh vao session
session.setAttribute("gio", gh);
//Hien thi gio
response.sendRedirect("hthaisanController");
%>
</body>
</html>