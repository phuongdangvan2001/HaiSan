	<%@page import="bean.tendangnhapbean"%>
<%@page import="bo.loaibo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.loaibean"%>
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
<h1 align="center" style="color-red"> ADMIN : LOẠI 
 <a href="adminaddloaiController"><img alt="" src="image\add.png" width="60" height="60" align="right"></a>
	<table width="500" align="center" class="table">
		<td valign="top" width="300" > 
   		<table class="table table-hover">
   		<tr>
   		<td>STT</td>
   		<td> Tên loại </td>
   		</tr>
	   		<%
	   		ArrayList<loaibean> dsloai = (ArrayList<loaibean>)request.getAttribute("dsloaiad");
	   		int i = 1;
	   			for(loaibean l: dsloai){%>
	   			   <tr>
	   			   <td><%=i %>
	   			   <td>
	   				  <a href="haisanController?ml=<%=l.getMaloai()%>">
	   				   <%=l.getTenloai()%> </a>
	   				 </td>
	   				 <td>
	   				 <a href="admineditloaiController?ml=<%=l.getMaloai()%>&tenloai=<%=l.getTenloai()%>">  
			   		     <img src="image\edit.png" width="30" height="30"></a>
			   		  </td><td>
			   		<a href="admindeleteloaiController?ml=<%=l.getMaloai()%>">  
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