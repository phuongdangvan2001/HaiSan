<%@page import="bean.khachhangbean"%>
<%@page import="bo.lichsumuahangbo"%>
<%@page import="bean.lichsumuahangbean"%>
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

<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: visible; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  padding-top: 20px;
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
  position: absolute;
  right: 25px;
  top: 0;
  color: #000;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}

/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="hthaisanController">Trang chủ</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="htgioController">Giỏ hàng(<%
    		  giohangbo gh = (giohangbo)session.getAttribute("gio");
    		  if(gh != null){
      			out.print(gh.ds.size());}%>)</a></li>
      <li><a href="thanhtoantungdonhangController">Thanh toán</a></li>
       <li><a href="lichsumuahangController">Lịch sử mua hàng</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="xoa.jsp"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
      <li>
      <%if(session.getAttribute("kh")==null){ %>
      <a href="dangnhapController">
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

   		<td valign="top" width="800" >
   		<table  class="table table-hover">
   			<tr><h1 align="center" class="text-danger"> THANH TOÁN </h1></tr>	
   			<tr><td width="20">STT</td>
   				<td width="300">Tên hải sản</td>
   				<td width="150">Ngày mua</td>
   				<td width="150">Số Lượng</td>
   				<td width="100">Giá</td>
   				<td width="100">Thành tiền</td>
   				<td width="110">Chọn thao tác</td>
   			</tr>
	   		 <%int i =1;
	   		 ArrayList<lichsumuahangbean> dstt = (ArrayList<lichsumuahangbean>)request.getAttribute("dstt");   		 
	   		  for(lichsumuahangbean h: dstt){%>
	   		  <tr>
	   		  <td><%=i %>	    
	   		    <td>
	   		      <%=h.getTensach() %>
	   		    </td>
	   		    <td>
	   		      <%=h.getNgaymua() %>
	   		    </td><td>
	   		      <%=h.getSoluongmua()%>
	   		    </td>
	   		    <td> 
	   		    	<%=h.getGia() %>vnđ
	   		    </td>
	   		    <td><%=h.getThanhtien()%>vnđ</td>
	   		    <%
	   		    if(h.isDamua() == false){
	   		    %>
	   		    <td align="center">
	   		    <button onclick="document.getElementById('id01').style.display='block'" class="btn btn-default"><img src="image\pay.png" height="20" width="20"></button></td>
	   		    <div id="id01" class="modal">

				  <form class="modal-content animate" action="thanhtoantungdonhang1Controller?mct=<%=h.getMact()%>" method="post">
				    <div class="imgcontainer">
				      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
				
				    </div>
				
				    <div class="container">
				      <label for="uname"><b>LỜI GÓP Ý</b></label>
				      
				      <input name="txtun" type="text" value="" placeholder="Ghi vào đây" >
				      <button type="submit">GÓP Ý</button>
				    </div>
				  </form>
				</div>
	   		    <%} i++; %>
	   		  </tr>
	   		    <%} %>
   		 	</table>
   		 <table class="table table-hover">
   		 	<tr >
			    <td align="center" width="200">
			      	<form action="hthaisanController" method="post">
			      		<button name="butdn" type="submit" value="">Tiếp tục mua hàng</button>
			      	</form>
			    </td>
   			</tr>
				   		 
   		 </table>
   </td>
</table>

</body>
</html>


