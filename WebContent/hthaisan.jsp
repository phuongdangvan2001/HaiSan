
<%@page import="bo.giohangbo"%>
<%@page import="bean.giohangbean"%>
<%@page import="bean.khachhangbean"%>
<%@page import="bean.haisanbean"%>
<%@page import="bo.loaibo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.loaibean"%>
<%@page import="dao.loaidao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css" />
  <script src="https://code.jquery.com/jquery-3.2.1.js" ></script>
  <!-- JS tạo nút bấm di chuyển trang start -->
  <script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
  <!-- JS tạo nút bấm di chuyển trang end -->
  <style>
		/* unvisited link */
		a:link {
		  color: blue;
		}
		
		/* visited link */
		a:visited {
		  color: green;
		}
		
		/* mouse over link */
		a:hover {
		  color: red;
		}
		
		/* selected link */
		a:active {
		  color: blue;
		}
	</style>
		<script type="text/javascript">
            $(function () {
                var pageSize = 10; // Hiển thị 6 sản phẩm trên 1 trang
                showPage = function (page) {
                    $(".contentPage").hide();
                    $(".contentPage").each(function (n) {
                        if (n >= pageSize * (page - 1) && n < pageSize * page)
                            $(this).show();
                    });
                }
                //showPage(1);
                ///** Cần truyền giá trị vào đây **///
                var totalRows = 80; // Tổng số sản phẩm hiển thị
                //var btnPage = 10; // Số nút bấm hiển thị di chuyển trang
                var iTotalPages = Math.ceil(totalRows / pageSize);

                var obj = $('#pagination').twbsPagination({
                    totalPages: iTotalPages,
                    //visiblePages: btnPage,
                    onPageClick: function (event, page) {
                        console.info(page);
                        showPage(page);
                    }
                });
                console.info(obj.data());
            });
     </script>
     <style>
            ///** CSS căn id pagination ra giữa màn hình **///
            #pagination {
                display: flex;
                display: -webkit-flex; /* Safari 8 */
                flex-wrap: wrap;
                -webkit-flex-wrap: wrap; /* Safari 8 */
                justify-content: center;
                -webkit-justify-content: center;
            }
            .btnBuy {
				width: 100%;
				outline: none;
				border-radius: 4px;
				color: #fff;
				background-color: #2e8b57;
				transition: .2s;
				text-align: center;
				padding: 6px 16px;
				font-size: 16px;
				cursor: pointer;
				font-weight: 600;
				border: 3px solid #2e8b57;
				text-decoration: none;
			}
			.flexItem {
				width: calc(100%/ 3);
				padding: 8px;
				margin-bottom: 16px;
			}
			.flexItemMargin {
				border: 1px solid #ccc;
				border-radius: 4px;
				display: flex;
				justify-content: center;
				flex-direction: column;
				align-items: center;
				padding: 8px;
				text-align: center;
				transition: .2s;
			}
			.button {
				  background-color: #4CAF50; /* Green */
				  border: none;
				  color: white;
				  padding: 10px 20px;
				  text-align: center;
				  text-decoration: none;
				  display: inline-block;
				  font-size: 16px;
				  margin: 4px 2px;
				  transition-duration: 0.4s;
				  cursor: pointer;
				}
			.button5 {
				  background-color: white;
				  color: black;
				  border: 2px solid #555555;
			}

			.button5:hover {
			  background-color: #555555;
			  color: white;
			}
     </style>  
</head>


<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
    <li><a class="navbar-brand" href="#">Trang Chủ</a></li>
      <li><a href="htgioController">Giỏ hàng(<%
    		  giohangbo gh = (giohangbo)session.getAttribute("gio");
    		  if(gh != null){
      			out.print(gh.ds.size());}%>)</a></li>
      <li><a href="thanhtoantungdonhangController">Thanh toán</a></li>
      <li><a href="lichsumuahangController">Lịch sử mua hàng</a></li>
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
<tr><h1 align="center" class="text-danger"> SHOP HẢI SẢN CỦA PHƯƠNG</h1></tr>	
   <tr>
   		<td valign="top" width="200" > 
   		<table class="table table-hover">
	   		<%
	   		ArrayList<loaibean> dsloai = (ArrayList<loaibean>)request.getAttribute("dsloai");
	   			for(loaibean l: dsloai){%>
	   			   <tr><td>
	   				  <a href="hthaisanController?ml=<%=l.getMaloai()%>">
	   				   <%=l.getTenloai()%> </a>
	   				 </td>
	   				</tr>
	   		<%	}
	   		%>
   		 </table>
   		 </td>
   		<td valign="top" width="600" > 
   		<table class="table table-hover">
   			<tr>
   				<td colspan="2" align="center"><ul class="pagination" id="pagination" ></ul></td>
   			</tr>
	   		  <%
	   		    ArrayList<haisanbean> dssach= (ArrayList<haisanbean>)request.getAttribute("dssach");	   			   
	   		    for(int i=0;i<dssach.size();i++){
	   		    	haisanbean s=dssach.get(i);
	   		     %>
	   		     <tr>
	   		       <td align="center"><div class="contentPage">
		   		    <img height="300" width="300" src="<%=s.getAnh() %>"> <br>
		   		     <%=s.getTenhaisan() %> <br>
		   		     Giá: <%=s.getGia() %>Đ/kg<br>
			   		 <a href="giohangController?ms=<%=s.getMahaisan()%>&ts=<%=s.getTenhaisan()%>&gia=<%=s.getGia()%>&anh=<%=s.getAnh()%>" class="button button5">  
			   		     MUA</a>
		   		  </div></td>
		   		  
		   		   
		   		   <% i++; 
		   		   if(i<dssach.size()){
		   		     s=dssach.get(i);%>
		   		     <td align="center"><div class="contentPage">
			   		    <img height="300" width="300" src="<%=s.getAnh() %>"> <br>
			   		     <%=s.getTenhaisan() %> <br>
			   		     Giá: <%=s.getGia()%>Đ/kg<br>
						<a href="giohangController?ms=<%=s.getMahaisan()%>&ts=<%=s.getTenhaisan()%>&gia=<%=s.getGia()%>&anh=<%=s.getAnh()%>" class="button button5">  
			   		     MUA</a>
		   		     </div></td>
		   		     <%} %>
		   		  </tr>
		   		    <%} %>
   		 </table>
   		    </td>
   		<td valign="top" width="200" >
   		
   <form action="hthaisanController" method="post">
      <input name="txttk" type="text" value="" placeholder="Nhập tìm kiếm"> 
      <button type="submit" >
										<img alt="" src="search.png" width="20" height="20">
									</button>
   	</form>	 
   		 </td>
   </tr>
   <tr>
   		<td align="center">
		<ul class="pagination">
			<c:if test="${index > 1}">
				<li class="page-item disabled"><a class="page-link"
					href="hthaisanController?index=${index - 1}&txttk=${key}&ml=${ml}" tabindex="-1">Pre</a></li>
			</c:if>

			<c:forEach begin="1" end="${endP }" var="i">
				<li class="${index == i ? "page-item active" : "page-item" }"><a
					class="page-link" href="hthaisanController?index=${i}&txttk=${key}&ml=${ml}">${i }</a></li>
			</c:forEach>
			<c:if test="${index < endP }">
				<li class="page-item"><a class="page-link"
					href="hthaisanController?index=${index + 1}&txttk=${key}&ml=${ml}">Next</a></li>
			</c:if>

		</ul>
	</td></tr>
</table>
</body>
</html>