<%@page import="java.util.ArrayList"%>
<%@page import="bean.haisanbean"%>
<%@page import="bean.tendangnhapbean"%>
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<tr><h1 align="center" class="text-danger"> ADMIN: HẢI SẢN
<a href="adminaddhaisanController"><img alt="" src="image\add.png" width="60" height="60" align="right"></a></h1></tr>
	<table width="1000" align="center" class="table">
		<td valign="top" width="900" > 
   		<table class="table table-hover">
   		<tr align="center" >
   				<td align="center" width="10">STT </td>
   				<td align="center" width="50">Mã hải sản</td>
   				<td align="center" width="200">Tên hải sản</td>
   				<td align="center" width="50">Số lượng</td>
   				<td align="center" width="70">Giá</td>
   				<td align="center" width="250">Ảnh</td>
   				<td align="center" width="100">Thao tác</td>
   		</tr align="center" >
	   		<%
	   		ArrayList<haisanbean> dsloai = (ArrayList<haisanbean>)request.getAttribute("dssachad");
	   		int i = 1;
	   			for(haisanbean l: dsloai){%>
	   			   <tr>
	   			   <td align="center" ><%=i %>
	   			   <td align="center" >
	   				   <%=l.getMahaisan()%> 
	   				 </td>
	   				 <td align="center" >
	   				 	<%=l.getTenhaisan() %>
	   				 </td>
	   				 <td align="center" >
	   				 	<%=l.getSoluong() %>
	   				 </td >
	   				 <td align="center" >
	   				 	<%=l.getGia() %>
	   				 </td>
	   				 <td align="center">
	   				 	<img height="100" width="100" src="<%=l.getAnh() %>">
	   				 </td>
	   				 <td width="50">
	   				 <a href="adminedithaisanController?ms=<%=l.getMahaisan()%>">  
			   		     <img src="image\edit.png" width="30" height="30"></a>
			   		  </td><td width="50">
			   		<a href="admindeletehaisanController?ms=<%=l.getMahaisan()%>">  
			   		     <img src="image\delete.png" width="30" height="30"></a>
			   		 </td>
	   				</tr>
	   		<%i++;	}
	   		%>
   		 </table>
   		 </td>
   		 	
	</table>
</body>
</html>