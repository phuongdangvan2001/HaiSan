 <%@page import="bo.xacnhanbo"%>
<%@page import="bean.xacnhanbean"%>
<%@page import="bean.tendangnhapbean"%>
<%@page import="bean.khachhangbean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="bo.haisanbo"%>
<%@page import="bo.loaibo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.haisanbean"%>
<%@page import="dao.haisandao"%>
<%@page import="bean.loaibean"%>
<%@page import="dao.loaidao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="loaiController">Loại</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="haisanController">Hải Sản</a></li>
      <li><a href="xacnhanController">Xác nhận hóa đơn</a></li>
       <li><a href="dschuyentienController">Danh sách chuyển tiền</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="xoaadmin.jsp"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
      <li>
      <%if(session.getAttribute("admin")==null){ %>
      <a href="ktdnAdminController">
          <span class="glyphicon glyphicon-log-in"></span>
	       Login
       </a></li>
       <%} else{  %>
       <a href="#">
          <span class="glyphicon glyphicon-log-in"></span>
	       Hi <%
	       tendangnhapbean dn=(tendangnhapbean)session.getAttribute("admin");
	       out.print(dn.getTendangnhap());
	       %>
       </a></li>
       <%} %>
    </ul>
  </div>
</nav>
  
<table width="1000" align="center" class="table">
<tr><h1 align="center" class="text-danger">DANH SÁCH CHUYỂN TIỀN</h1></tr>	
	<tr>
   				<td width="10">STT </td>
   				<td width="100">Tên khách hàng</td>
   				<td width="150">Tên Hải Sản</td>
   				<td width="50">Giá</td>
   				<td width="20">Số lượng</td>
   				<td width="100">Thành tiền</td>
   				<td width="100">Ngày đặt mua</td>
   				<td width="110">Tình Trạng</td>
   				<td width="110">Góp ý của khách hàng</td>
   			</tr>
   <%ArrayList<xacnhanbean> ds= (ArrayList<xacnhanbean>) request.getAttribute("dsct"); 
   int i=0;
   for(xacnhanbean xn: ds){ %>
      <tr>
      <td><%=i %></td>
      <td><%=xn.getHoten() %></td>
      <td><%=xn.getTenhaisan() %></td>
      <td><%=xn.getGia() %></td>
      <td><%=xn.getSoluongmua()%></td>
      <td><%=xn.getThanhtien() %></td>
      <td><%=xn.getNgaymua() %></td>
      <td><%=(xn.isDamua()?"Đã thanh toán":"Đang đặt mua") %></td>
      <td><%=xn.getGopy()!= null? xn.getGopy() : "Không có góp ý" %></td>
   <% i++;} %>

   		
</table>
</body>
</html>
