<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      <div class="market-search-group tmpt">
    	<input type="search" id="market_search" placeholder="책 정보입력" autocomplete="off"/>  
      </div>

   <div class="container panel">
      <h3 class="panel-heading ">장바구니</h3>   
      

      
   </div>   
     <form action="/market_order" method="post">
     
   <div class="marketCheck">
			<label for="marketAllcheck" id="marketAllcheck">전체선택</label>
			<input type="checkbox" id="marketAllCheck"/>
  </div>
     
   <div class="container panel">
       
		<c:forEach var="i" items="${cartlist}">		
		<div class="row">
    	<div class="col-sm-2">${i.MCart_id}</div>
    	<div class="col-sm-2">
		<img src="${i.market.bookinfo.book_image }" class="marketCartImg"  alt="${i.market.bookinfo.book_title }" style="height:200px;"/>
    	</div>
    	<div class="col-sm-2">${i.market.bookinfo.book_title }</div>
    	<div class="col-sm-2">${i.market.bookinfo.book_author}</div>
    	<div class="col-sm-2">${i.MCartDate}</div>
    	<div class="col-sm-2">${i.market.MPrice}</div>
		</div>
		</c:forEach>


  <div class="row"></div>
  
  <p id="market-paying">결제 예정 금액 : ${totalPrice} </p>

  <div class="marketBuy">
  		<input type="submit" class="btn btn-info" value="주문하기"/>
  </div>
  
  <div class="marketDelete">
  		<input type="button" class="btn btn-danger" value="삭제"/>
  </div>
    
    
    
  </div>
  
  </form>                
  

  
   <script>
   $(function() {
	    $("#marketAllCheck").on("click", function() {
	      var isChecked = $(this).is(":checked");
	      $("[id^=marketProductCheck]").prop("checked", isChecked);
	    });
   
     $(function(){
  	$("#market_search").keydown(function(event){
  		event.preventDefault();
  		var marketSearch ="";
  		if (event.keyCode === 13) {
  			marketSearch=$("#market_search").val();
  			location.href='${pageContext.request.contextPath}/market/marketSearch?book_title='+marketSearch;
  		}
  		
  		marketSearch = "";
  	});
  });
   </script>                              
<%@include file="../inc/footer.jsp" %>