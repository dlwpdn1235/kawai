
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

      </h3>   
      
      <c:forEach items="${selectedMarkets}" var="market">
  <p>${market.marketId}: ${market.name}</p>
  <!-- 추가적인 데이터 출력 또는 처리 -->
</c:forEach>
   </div>                     
   <div class="text-center">   
</div>
<%@include file="../inc/footer.jsp" %>
