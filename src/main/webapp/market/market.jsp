<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>Basic</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- asd -->
<!-- mail -->
<script src="https://cdn.ckeditor.com/4.21.0/standard/ckeditor.js"></script>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="container panel">
      <h3 class="panel-heading"></h3>   
   	<div class="row well">
   		<div class="col-sm-4">
	   		<div class="row">
	   			<div class="col-sm-4">
	   			<select >
	   				<option value="1"><%=request.getParameter("mDateY") %></option>
	   			</select>
	   			</div>
	   			<div class="col-sm-4">
	   			<select >
	   				<option value="1"><%=request.getParameter("mDateY") %></option>
	   			</select>
	   			</div>
	   			<div class="col-sm-4">
	   			<select >
	   				<option value="1"><%=request.getParameter("mDateY") %></option>
	   			</select>
	   			</div>
	   		</div>
   		</div>
   		
   		<div class="col-sm-4">
	   		<form action="#" method="get" id="form-group">
	   			<input type="search" value="asd"/>
	   		</form>
   		</div>
   		
   		<div class="col-sm-4">
   			<div class="row">
   				<div class="col-sm-6">
   					<select>
   						<option value="1"><%=request.getParameter("mDateY") %></option>
   					</select>
   				</div>
   				<div class="col-sm-6">
   					<select>
   						<option value="1"><%=request.getParameter("mDateY") %></option>
   					</select>
   				</div>
   			</div>
   		</div>
   	</div>
   </div>  
      
   
   
                                                      
</body>
</html>
<!-- 
   
 -->