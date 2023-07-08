<%@page import="org.w3c.dom.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
#market_search{
float-left:80px;
}
</style>

   <div class="container panel tmpt">
      <h3 class="panel-heading">
      			${marketDetail.bookInfo.Book_title }
      </h3>   
   </div>                     
   <div class="text-center">   
</div>
<%@include file="../inc/footer.jsp" %>
