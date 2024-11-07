<%@page import="bean.khachhangbean"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
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
      <a class="navbar-brand" href="hthaisanController">Trang chủ</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="#">Giỏ hàng(<%
    		  giohangbo gh1 = (giohangbo)session.getAttribute("gio");
    		  if(gh1 != null){
      			out.print(gh1.ds.size());}%>)</a></li>
      <li><a href="thanhtoantungdonhangController">Thanh toán</a></li>
       <li><a href="lichsumuahangController">Lịch sử mua hàng</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="xoa.jsp"><span class="glyphicon glyphicon-user"></span> Sign Out</a></li>
      <li>
      <%if(session.getAttribute("kh")==null){ %>
      <a href="ktdnController">
          <span class="glyphicon glyphicon-log-in"></span>
	       Login
       </a></li>
       <%} else{  %>
       <a href="#">
          <span class="glyphicon glyphicon-log-in"></span>
	       Hi <%khachhangbean kh=(khachhangbean)session.getAttribute("kh");
	       out.print(kh.getHoten());
 %>
       </a></li>
       <%} %>
    </ul>
  </div>
</nav>
  
<table width="1000" align="center" class="table">
   <tr><h1 align="center" class="text-danger"> GIỎ HÀNG </h1></tr>	
   		<td valign="top" width="800" >
   		<form action="suaxoa.jsp" method="post"> 
   		<table  class="table table-hover">
   			<tr align="center">
   				<td width="10"> </td>
   				<td width="190">Tên hải sản</td>
   				<td width="150">Giá</td>
   				<td width="290">Số lượng</td>
   				<td width="150">Thành tiền</td>
   				<td width="400">Ảnh</td>
   			</tr>
	   		 <%
	   		 giohangbo gh=(giohangbo)session.getAttribute("gio");
	   		  for(giohangbean h: gh.ds){%>
	   		  <tr align="center">
	   		    <td> 
	   		    <input name="check" type="checkbox" value="<%=h.getMahaisan()%>"> <br>
	   		    </td>
	   		    
	   		    <td>
	   		      <%=h.getTenhaisan() %>
	   		    </td><td>
	   		      <%=h.getGia()%>vnđ
	   		    </td>
	   		    <td> 
	   		    	<%=h.getSoluong() %>
	   		    	<input name="<%=h.getMahaisan()%>" type="number" value="<%=h.getSoluong() %> " min="0"> 
	   		    	<button type="submit" name="butsua" value="<%=h.getMahaisan() %>"> Update</button>
	   		    	<button type="submit" name="butxoa" value="<%=h.getMahaisan() %>"> Delete</button>
	   		    </td>
	   		    <td><%=h.getThanhtien()%>vnđ</td>
	   		    <td><img height="200" width="200" src="<%=h.getAnh() %>"> </td></tr>
	   		    <%} %>
   		 	</table>
   		 </form> 
   		 <table class="table table-hover">
			<tr>
	   			<td align="left">
   		 			<p><b><big><big>Tổng cộng: <%=gh.TongTien()%>VNĐ</big></big></b></p>
   		 		</td>
   		 	</tr>
   		 	<tr>
   		 		<td align="right" width="300">
			   		<form action="dathangController" method="post">
			      		<button name="buttl" type="submit" value="<%=1%>"> Xác nhận đặt mua</button>
			      	</form>
			    </td>
   		 		<td align="right" width="300">
			   		<form action="xoahang.jsp" method="post">
			      		<button name="buttl" type="submit" value="<%=1%>"> Trả lại toàn bộ</button>
			      	</form>
			    </td>
			    <td align="center" width="200">
			      	<form action="hthaisanController" method="post">
			      		<button name="butdn" type="submit" value="">Tiếp tục mua hàng</button>
			      	</form>
			    </td>
			    <td align="left" width="300">
			      	<form action="thanhtoanController" method="post">	
			      		<button class="btn-primary" name="butttall" type="submit" value="">Thanh toán tất cả</button>
			      	</form>
			   		
			   	</td>	 
   			</tr>
				   		 
   		 </table>
   </td>
</table>
</body>
</html>


